# Creating PySpark session
from pyspark import SparkConf
from pyspark.sql import SparkSession

conf = SparkConf() \
        .setAppName("TP4") \
        .set("spark.mongodb.input.uri", "mongodb://127.0.0.1/tp4.factures") \
        .set("spark.mongodb.output.uri", "mongodb://127.0.0.1/tp4.factures") \
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
    rows = df.select("*")
    products = rows.rdd.map(lambda x: x.produits).first()
    return jsonify(products)

@app.route('/', methods=['POST'])
def sauvegarder_facture():
    data = request.json
    facture = Facture(data)
    df = spark.createDataFrame([tuple(facture.values())], tuple(facture.keys()))
    df.write.format("com.mongodb.spark.sql.DefaultSource").mode("append").save()
    df.show()
    return jsonify({"success": True})
