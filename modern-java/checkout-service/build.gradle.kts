plugins {
    id("java")
}

group = "com.modernjava"
version = ""


repositories {
    mavenCentral()
}

dependencies {
    // Add complete JUnit 5 dependencies including the launcher
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.junit.jupiter:junit-jupiter-params")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}