package com.unraveldata.spark.catalyst

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.execution.{SparkPlanner, SparkStrategy}

object CollectStrategies {

  def main(args: Array[String]): Unit = {
    // Creating a SparkSession object
    val session = SparkSession.builder
      .master("local[2]")
      .appName("Exploring Spark Planner strategies")
      .getOrCreate()

    val planner = new SparkPlanner(session, session.sessionState.conf, session.sessionState.experimentalMethods)
    val strategies: Seq[SparkStrategy] = planner.strategies
    strategies.foreach(println)
  }

}
