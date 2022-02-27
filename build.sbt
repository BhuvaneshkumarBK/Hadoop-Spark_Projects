ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

lazy val root = (project in file("."))
  .settings(
    name := "untitled"
  )
libraryDependencies += "org.apache.spark" %% "spark-sql" % "3.2.1" % "provided"
libraryDependencies += "org.apache.hadoop" % "hadoop-aws" % "3.3.1"
libraryDependencies += "com.amazonaws" % "aws-java-sdk-s3" % "1.12.162"

