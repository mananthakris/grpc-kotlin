import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.google.protobuf") version "0.8.15" apply false
    id("org.jlleitschuh.gradle.ktlint") version "9.2.1"
    kotlin("jvm") version "1.5.30" apply false
}

// todo: move to subprojects, but how?
ext["grpcVersion"] = "1.37.0"
ext["grpcKotlinVersion"] = "1.1.0" // CURRENT_GRPC_KOTLIN_VERSION
ext["protobufVersion"] = "3.15.8"

allprojects {
    repositories {
        mavenLocal()
        mavenCentral()
        google()
    }

    apply(plugin = "org.jlleitschuh.gradle.ktlint")
}
// build.gradle.kts
subprojects { parent!!.path.takeIf { it != rootProject.path }?.let { evaluationDependsOn(it)  } }


tasks.create("assemble").dependsOn(":server:installDist")
//dependencies {
//    implementation(kotlin("stdlib-jdk8"))
//}
repositories {
    mavenCentral()
}
//val compileKotlin: KotlinCompile by tasks
//compileKotlin.kotlinOptions {
//    jvmTarget = "1.8"
//}
//val compileTestKotlin: KotlinCompile by tasks
//compileTestKotlin.kotlinOptions {
//    jvmTarget = "1.8"
//}
