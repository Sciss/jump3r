name              := "jump3r"
organization      := "de.sciss"
version           := "1.0.5"
scalaVersion      := "2.13.1"  // not used
licenses          := Seq("LGPL v2.1+" -> url("https://www.gnu.org/licenses/lgpl-2.1.txt"))
crossPaths        := false
autoScalaLibrary  := false

homepage          := Some(url(s"https://git.iem.at/sciss/${name.value}"))
description       := "Java Unofficial MP3 EncodeR - a Java port of LAME"

lazy val commonJavaOptions = Seq("-source", "1.6")

javacOptions        := commonJavaOptions ++ Seq("-target", "1.6", "-g", "-Xlint:deprecation")
javacOptions in doc := commonJavaOptions  // cf. sbt issue #355

// ---- assembly ----
mainClass       in assembly := Some("de.sciss.jump3r.Main")
assemblyJarName in assembly := s"${name.value}.jar"
target          in assembly := baseDirectory.value

// ---- publishing to Maven Central ----
publishMavenStyle := true

publishTo := Some(
  if (isSnapshot.value)
    "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
  else
    "Sonatype Releases"  at "https://oss.sonatype.org/service/local/staging/deploy/maven2"
)

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra := { val n = name.value
  <scm>
    <url>git@git.iem.at:sciss/{n}.git</url>
    <connection>scm:git:git@git.iem.at:sciss/{n}.git</connection>
  </scm>
  <developers>
    <developer>
      <id>lame</id>
      <name>The L.A.M.E. project</name>
      <url>http://lame.sourceforge.net/</url>
    </developer>
    <developer>
      <id>kenchis</id>
      <name>Ken Händel</name>
      <url>http://haendel.ddns.net/~ken/</url>
    </developer>
    <developer>
      <id>vikulin</id>
      <name>Vadym Vikulin</name>
      <url>https://github.com/vikulin</url>
    </developer>
    <developer>
      <id>sciss</id>
      <name>Hanns Holger Rutz</name>
      <url>http://www.sciss.de</url>
    </developer>
  </developers>
}

