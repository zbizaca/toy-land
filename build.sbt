name := "toy-land"

version := "1.0"

scalaVersion := "2.12"

libraryDependencies += "org.specs2" %% "specs2-core" % "3.0" % "test"

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

scalacOptions in Test ++= Seq("-Yrangepos")