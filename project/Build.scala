import sbt.Keys._
import sbt._
import sbtassembly.AssemblyKeys._

object Resolvers {
  val sprayRepo    = "spray repo" at "http://repo.spray.io"
  val typeSafeRepo = Classpaths.typesafeReleases

  def commonResolvers = Seq(sprayRepo, typeSafeRepo)
}

object Dependencies {
  private val sprayVersion = "1.3.2"
  private val akkaVersion  = "2.3.9"

  val akkaActor = "com.typesafe.akka" %% "akka-actor" % akkaVersion
  val akkaSlf4j = "com.typesafe.akka" %% "akka-slf4j" % akkaVersion

  val sprayCan      = "io.spray" %% "spray-can" % sprayVersion
  val sprayRouting  = "io.spray" %% "spray-routing" % sprayVersion
  val json4sJackson = "org.json4s" %% "json4s-jackson" % "3.2.11"
  val json4sExt     = "org.json4s" %% "json4s-ext" % "3.2.11"
  val dispatchCore  = "net.databinder.dispatch" %% "dispatch-core" % "0.11.2"
  val log4jApi      = "org.apache.logging.log4j" % "log4j-api" % "2.0.2"

  val log4jCore       = "org.apache.logging.log4j" % "log4j-core" % "2.0.2"
  val logback         = "ch.qos.logback" % "logback-classic" % "1.1.2"
  val logstashLogback = "net.logstash.logback" % "logstash-logback-encoder" % "3.6"
  //  val scalaTest       = "org.scalatest" %% "scalatest" % "2.2.1" % "test"
  //  val scalaCheck      = "org.scalacheck" %% "scalacheck" % "1.12.2" % "test"

}

object BuildSettings {

  val Organization = "Study"
  val Name         = "nw_labs"
  val Version      = "0.0.1"
  val ScalaVersion = "2.11.6"

  val buildSettings = Seq(
    organization := Organization,
    name := Name,
    version := Version,
    scalaVersion := ScalaVersion
  )
}

object MainBuild extends Build {

  import BuildSettings._
  import Dependencies._
  import Resolvers._

  val deps = Seq(akkaActor, sprayCan,
    sprayRouting, json4sJackson, json4sExt,
    dispatchCore, log4jApi, log4jCore, logback, logstashLogback, akkaSlf4j)

  javacOptions ++= Seq("-encoding", "UTF-8")

  lazy val main = Project(
    Name,
    file("."),
    settings = buildSettings ++ Defaults.coreDefaultSettings ++
      Seq(
        libraryDependencies ++= deps,
        resolvers := commonResolvers,
        mainClass in assembly := Some("")
      )
  )
}