val globalSettings = Seq(
  version := "0.1",
  scalaVersion := "2.11.8"
)

val akkaVersion = "2.3.15"
val sparkVersion = "2.0.2"
val sparkCassandraConnectorVersion = "2.0.5"
val cassandraDriverVersion = "3.3.0"
val kafkaVersion = "1.0.0"
val scalaTestVersion = "3.0.0"
val configVersion = "1.3.2"
val sparkCsvVersion = "1.5.0"
val sskVersion = "1.6.3"

lazy val producer = (project in file("producer"))
  .settings(name := "producer")
  .settings(globalSettings:_*)
  .settings(libraryDependencies ++= producerDeps)

lazy val consumer = (project in file("consumer"))
  .settings(name := "consumer")
  .settings(globalSettings:_*)
  .settings(libraryDependencies ++= consumerDeps)

lazy val producerDeps = Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "org.apache.kafka" % "kafka_2.11" % kafkaVersion
    exclude("javax.jms", "jms")
    exclude("com.sun.jdmk", "jmxtools")
    exclude("com.sun.jmx", "jmxri"),
  "com.datastax.cassandra" % "cassandra-driver-core" % cassandraDriverVersion
)

lazy val consumerDeps = Seq(
  "com.datastax.spark" %% "spark-cassandra-connector" % sparkCassandraConnectorVersion,
  "org.apache.spark"  %% "spark-mllib"           % sparkVersion,
  "org.apache.spark"  %% "spark-graphx"          % sparkVersion,
  "org.apache.spark"  %% "spark-sql"             % sparkVersion,
  "org.apache.spark"  %% "spark-streaming"       % sparkVersion,
  "org.apache.spark"  %% "spark-streaming-kafka" % sskVersion,
  "com.typesafe"      %  "config"                % configVersion,
  "com.databricks"    %% "spark-csv"             % sparkCsvVersion
)

