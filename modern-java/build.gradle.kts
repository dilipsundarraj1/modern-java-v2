plugins {
    id("java")
}

group = "org.example"
version = ""


repositories {
    mavenCentral()
}


subprojects {

    apply(plugin="java")

    java {
        sourceCompatibility = JavaVersion.VERSION_25
        targetCompatibility = JavaVersion.VERSION_25
    }

    dependencies {

        testImplementation(platform("org.junit:junit-bom:5.9.1"))
        testImplementation("org.junit.jupiter:junit-jupiter")
        testImplementation("org.junit.jupiter:junit-jupiter-params")
        testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    }

    tasks.withType<JavaCompile> {
        val compilerArgs = options.compilerArgs
//        compilerArgs.add("--enable-preview")
    }

    tasks.test {
        useJUnitPlatform()
//        jvmArgs(listOf("--enable-preview"))
    }
}