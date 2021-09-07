

buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.30")
        val daggerVersion = "2.38.1"

        dependencies {
            classpath("com.android.tools.build:gradle:7.0.2")
            classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.30")
            classpath("com.google.dagger:hilt-android-gradle-plugin:$daggerVersion")
        }
    }
}



tasks.register(name = "clean", Delete::class) {
    delete(rootProject.buildDir)
}