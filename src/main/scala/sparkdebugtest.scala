import org.apache.spark.sql.SparkSession

object sparkdebugtest {
  def main(args: Array[String]): Unit = {
    val sparkSession = SparkSession.builder()
      .appName("spark read hive")
      .master("local[*]")
      .config("spark.sql.warehouse.dir", "/user/hive/warehouse")
      .config("hadoop.home.dir", "/user/hive/warehouse")
      .enableHiveSupport()
      .getOrCreate()
    sparkSession.sql("select * from student").show()
  }
}
