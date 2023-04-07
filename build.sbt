ThisBuild / scalaVersion := "3.2.2"
ThisBuild / organization := "com.example"

lazy val hello = (project in file("."))
  .settings(
    name := "Hello",
    libraryDependencies += "org.typelevel" %% "cats-effect"    % "3.4.8",
    libraryDependencies += "dev.zio" %% "zio-schema"          % "0.4.9",
    libraryDependencies += "dev.zio" %% "zio-schema-json"     % "0.4.9",
    libraryDependencies += "dev.zio" %% "zio-schema-protobuf" % "0.4.9",
    
    // Required for automatic generic derivation of schemas
    libraryDependencies += "dev.zio" %% "zio-schema-derivation" % "0.4.9",
    // libraryDependencies += "org.scala-lang" % "scala-reflect"  % scalaVersion.value % "provided",
    // libraryDependencies += "giuliohome.com" % "kyo-chatgpt_3" % "0.0.0+266-77c10268+20230405-1250-SNAPSHOT",
    libraryDependencies += "giuliohome.com" % "kyo-chatgpt_3" % "0.0.0+269-abf82b89+20230407-1230-SNAPSHOT",  // "0.0.0+266-77c10268+20230405-1250-SNAPSHOT",
    // libraryDependencies += "io.getkyo" % "kyo-chatgpt_3" % "0.2.5",
    libraryDependencies += "org.apache.logging.log4j" % "log4j-api" % "2.20.0",
    libraryDependencies += "org.apache.logging.log4j" % "log4j-core" % "2.20.0",
    libraryDependencies ++= Seq("org.slf4j" % "slf4j-api" % "2.0.7",
                            "org.slf4j" % "slf4j-simple" % "2.0.7"),
  )
