plugins {
    id("java")
}

group = "com.modernjava"
version = ""


repositories {
    mavenCentral()
}

dependencies {
    //jackson for custom serdes
    implementation("com.fasterxml.jackson.core:jackson-databind:2.14.1")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.14.1")

}
