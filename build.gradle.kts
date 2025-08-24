plugins {
    id("java")
    // Adicione esta linha para habilitar a tarefa 'run'
    id("application")
}

group = "application"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

dependencies {
    implementation("org.liquibase:liquibase-core:4.29.1")
    implementation("mysql:mysql-connector-java:8.0.33")
    implementation("org.projectlombok:lombok:1.18.34")

    annotationProcessor("org.projectlombok:lombok:1.18.34")
}

application {
    mainClass.set("application.Main")
}

tasks.test {
    useJUnitPlatform()
}