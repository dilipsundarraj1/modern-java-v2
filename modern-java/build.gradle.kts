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
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
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