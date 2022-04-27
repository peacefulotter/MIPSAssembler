ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.12.15"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.11" % Test

lazy val root = (project in file("."))
  .settings(
    name := "MIPSAssembler"
  )
