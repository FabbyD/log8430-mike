# Creating PySpark session
from pyspark import SparkConf
from pyspark.sql import SparkSession
from pyspark.mllib.fpm import FPGrowth

import sys

with open("config", "r") as cfile:
    ips = [ip.strip() for ip in cfile]

if len(ips) < 2:
    print("Veuillez specifier les IP de spark et Mongo dans le fichier config")
    sys.exit()

sparkmasterip = ips[0]
mongoip = ips[1]

conf = SparkConf() \
        .setAppName("TP4") \
        .setMaster("spark://%s:7077" % sparkmasterip) \
        .set("spark.mongodb.input.uri", "mongodb://%s:27017/tp4.factures" % mongoip) \
        .set("spark.mongodb.output.uri", "mongodb://%s:27017/tp4.factures" % mongoip) \
        .set("spark.jars.packages", "org.mongodb.spark:mongo-spark-connector_2.11:2.3.1")

spark = SparkSession \
    .builder \
    .config(conf=conf) \
    .getOrCreate()

# Load the MongoDB collection dataframe
df = spark.read.format("com.mongodb.spark.sql.DefaultSource").load()

# Start REST server
from flask import Flask, jsonify, request
app = Flask(__name__)

class Facture:
    def __init__(self, data):
        self.produits = data.get('produits', [])
        self.prix = [ float(p) for p in data.get('prix', []) ]

    def values(self):
        return self.__dict__.values()
    
    def keys(self):
        return self.__dict__.keys()

@app.route('/', methods=['GET'])
def chercher_produits():
    products = df.rdd.map(lambda x : x.produits)
    model = FPGrowth.train(products, minSupport=0.4, numPartitions=5)
    result = list(set(model.freqItemsets().flatMap(lambda itemset : itemset.items).collect()))
    print("Frequent items: %s" % str(result))
    return jsonify(result)

@app.route('/', methods=['POST'])
def sauvegarder_facture():
    data = request.json
    facture = Facture(data)
    df = spark.createDataFrame([tuple(facture.values())], tuple(facture.keys()))
    df.write.format("com.mongodb.spark.sql.DefaultSource").mode("append").save()
    df.show()
    return jsonify({"success": True})
