val ktorVersion = "2.3.12"

plugins {
    kotlin("jvm") version "2.2.0"
    id("io.ktor.plugin") version "3.2.3"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core:${ktorVersion}")
    implementation("io.ktor:ktor-server-netty:${ktorVersion}")
    implementation("io.ktor:ktor-serialization:${ktorVersion}")
    testImplementation("io.ktor:ktor-server-tests:2.0.0")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(24)
}