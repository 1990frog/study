import org.apache.spark.{SparkConf, SparkContext}

object WordCount {
  def main(array: Array[String]): Unit = {
    val conf = new SparkConf()
      .setAppName("wordcount")
      .setMaster("local")
    val sc = new SparkContext(conf)
//    val textFile = sc.textFile("file:///C:/Code/study/spark/src/main/scala/input.txt")
    val textFile = sc.textFile("file:///home/cai/Code/mine/study/spark/src/main/scala/input.txt")
    val wordsRDD = textFile.flatMap(_.split(","))
    val wordCountRDD = wordsRDD.map((_, 1)).saveAsTextFile("file:///home/cai/Code/mine/study/spark/src/main/scala/output")
    sc.stop()
  }
}
