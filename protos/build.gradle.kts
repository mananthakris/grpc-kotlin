import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

// todo: maybe use variants / configurations to do both stub & stub-lite here

// Note: We use the java-library plugin to get the protos into the artifact for this subproject
// because there doesn't seem to be an better way.
plugins {
    `java-library`
    kotlin("jvm")
}

java {
    sourceSets.getByName("main").resources.srcDir("src/main/proto")
}
dependencies {
    implementation(kotlin("stdlib-jdk8"))
}
repositories {
    mavenCentral()
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
