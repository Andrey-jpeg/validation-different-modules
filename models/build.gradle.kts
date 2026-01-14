plugins {
    id("org.jetbrains.kotlin.jvm") version "1.9.25"
    id("com.google.devtools.ksp") version "1.9.25-1.0.20"
    id("io.micronaut.minimal.library") version "4.6.1"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.9.25"
}

group = "com.example"
version = "unspecified"

repositories {
    mavenCentral()
}

allOpen {
    annotations("io.micronaut.core.annotation.Introspected")
}

dependencies {
    ksp("io.micronaut:micronaut-http-validation")
    ksp("io.micronaut.validation:micronaut-validation-processor")
    implementation("jakarta.validation:jakarta.validation-api:3.0.1")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}