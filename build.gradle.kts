import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.50"
    id("com.epam.drill.agent.runner.autotest") version ("0.2.2")
    id("groovy")
}
apply(plugin = "groovy")
group = "com.epam.epm-d4j"
version = "1.0-SNAPSHOT"

val jUnitVersion = "5.6.2"
val restAssuredVersion = "4.0.0"
val selenideVersion = "5.13.0"

repositories {
    mavenCentral()
    mavenLocal()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.codeborne:selenide:$selenideVersion")
    implementation("io.rest-assured:rest-assured:$restAssuredVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-api:$jUnitVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$jUnitVersion")
    testCompile("org.junit.jupiter:junit-jupiter-params:$jUnitVersion")
    testCompile("junit:junit:4.12")

}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

drill {
    version = "0.12.0"
    adminHost = "localhost"
//    if (System.getProperty("groupId") != null) {
     groupId = "pet-mcr" //if we are testion microservice uncomment this and write groupId
//    } else {
    // agentId = "Petclinic"
//    }
    adminPort = 8090
//    additionalParams = mutableMapOf(
//        "browserProxyAddress" to "$adminHost:7777"
//    )
    logLevel = com.epam.drill.agent.runner.LogLevels.TRACE
}


tasks.named<Test>("test") {
     useJUnitPlatform()
    //useTestNG()
    //useJUnit()
//    useJUnit {
//        includeCategories = setOf("UnitTest")
//    }
    systemProperty("petclinicUrl", System.getProperty("petclinicUrl"))
}
