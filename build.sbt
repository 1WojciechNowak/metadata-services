name := "metadata-services"

version := "0.1"

scalaVersion := "2.12.6"

libraryDependencies ++= Seq(
  "com.typesafe.slick" %% "slick" % "3.3.3",
  "org.slf4j" % "slf4j-nop" % "1.7.21",
  "com.h2database" % "h2" % "1.4.191",
  "org.scalatest" %% "scalatest" % "3.2.9" % "test"
)