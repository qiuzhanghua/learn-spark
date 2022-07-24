package learn.spark

import org.apache.spark.sql.types.{LongType, StringType, StructField, StructType}
import org.apache.spark.sql.{Row, SparkSession}
import org.slf4j.{Logger, LoggerFactory}

object App {
  private val log: Logger = LoggerFactory.getLogger(App.getClass)

  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder
      .master("local[*]")
      .appName("Simple Application")
      .getOrCreate()

    val peopleRdd = spark.sparkContext.parallelize(
      Array(Row(1L, "John", 30L), Row(2L, "Mary", 25L)
    ))
    val schema = new StructType(Array(StructField("id", LongType, false),
      StructField("name", StringType, false),
      StructField("age", LongType, true)))

    val peopleDf = spark.createDataFrame(peopleRdd, schema)
    peopleDf.show()
    peopleDf.select("name").show()
    //    val rdd = spark.sparkContext.parallelize(1 to 10)
    //      .map(x => (x, Random.nextInt(100) * x))
    //      .map(kv => Row(kv._1, kv._2))
    //    val schema = new StructType()
    //      .add(StructField("Key", IntegerType, false))
    //      .add(StructField("Value", IntegerType, false))
    //    val kvDf = spark.createDataFrame(rdd, schema)
    //    log.debug("============================")
    //    log.debug("\n" + kvDf.schema.treeString)
    //    log.debug("============================")
    //    kvDf.show(3)
    //    kvDf.createOrReplaceTempView("kv")
    //    spark.sql("select * from kv").collect().foreach(println)
  }

}
