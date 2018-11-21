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
from flask import Flask, jsonify
app = Flask(__name__)

@app.route('/', methods=['GET'])
def hello_world():
    rows = df.select("*")
    products = rows.rdd.map(lambda x: x.produits).first()
    return jsonify(products)
