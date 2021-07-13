name := "metadata-services"

version := "0.1"

scalaVersion := "2.12.6"

libraryDependencies += "com.typesafe.slick" %% "slick" % "3.3.3"

libraryDependencies ++= Seq(
  "org.slf4j" % "slf4j-nop" % "1.7.21",
  "com.h2database" % "h2" % "1.4.191"
)