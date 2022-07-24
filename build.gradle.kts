plugins {
    scala
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.apache.spark:spark-core_2.12:3.3.0")
    implementation("org.apache.spark:spark-sql_2.12:3.3.0")
    implementation("org.scala-lang:scala-library:2.12.16")
    implementation("com.google.guava:guava:31.1-jre")
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.scalatest:scalatest_2.12:3.2.12")
    testImplementation("org.scalatestplus:junit-4-13_2.12:3.2.12.0")
    testRuntimeOnly("org.scala-lang.modules:scala-xml_2.12:2.1.0")
}

application {
    mainClass.set("learn.spark.App")
}
