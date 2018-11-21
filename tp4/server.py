import sys

from flask import Flask
from operator import add
from pyspark.sql import SparkSession

spark = SparkSession\
    .builder\
    .appName("PythonWordCount")\
    .getOrCreate()

app = Flask(__name__)


@app.route('/', methods=['GET'])
def hello_world():
    filename = "foo.txt"
    lines = spark.read.text(filename).rdd.map(lambda r: r[0])
    counts = lines.flatMap(lambda x: x.split(' ')) \
                  .map(lambda x: (x, 1)) \
                  .reduceByKey(add)
    output = counts.collect()
    result = 0
    for (word, count) in output:
        result += count
    return "There are %d words" % result
