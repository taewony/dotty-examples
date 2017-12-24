lazy val root = (project in file(".")).
  settings(
    name := "dotty-examples",
    description := "Example sbt project that compiles using Dotty",
    version := "0.1",

    scalaVersion := "0.4.0-RC1",
    scalacOptions ++= { if (isDotty.value) Seq("-language:Scala2") else Nil },

    libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test",
    libraryDependencies += ("org.scalanlp" %% "breeze" % "0.13.2").withDottyCompat()
      
  )
