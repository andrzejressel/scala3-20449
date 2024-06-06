ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.3"
ThisBuild / crossScalaVersions := Seq("3.3.3", "3.4.2", "3.5.0-RC1")

lazy val root = (project in file("."))
  .settings(
    name := "scala3-20449"
  )
