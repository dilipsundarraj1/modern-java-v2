plugins {
    id("java")
}

group = "org.example"
version = ""


repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":modules:moduleone"))

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}