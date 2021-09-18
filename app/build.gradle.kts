plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

val daggerVersion = "2.38.1"
val coroutinesVersion = "1.5.2"
val composeVersion = "1.1.0-alpha03"

android {
    compileSdk = 31

    defaultConfig {
        applicationId = "com.excu_fcd.efm"
        minSdk = 21
        targetSdk = 31

        vectorDrawables.useSupportLibrary = true
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = composeVersion
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    packagingOptions {
        resources.excludes.add("META-INF/licenses/**")
        resources.excludes.add("META-INF/AL2.0")
        resources.excludes.add("META-INF/LGPL2.1")
    }
}

dependencies {

    //Kotlin coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-old:$coroutinesVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")

    //Coil
    implementation("io.coil-kt:coil-compose:1.3.2")

    //Dagger
    implementation("com.google.dagger:dagger:$daggerVersion")
    implementation(project(mapOf("path" to ":observer")))

    kapt("com.google.dagger:dagger-compiler:$daggerVersion")

    //Hilt
    implementation("com.google.dagger:hilt-android:$daggerVersion")
    kapt("com.google.dagger:hilt-android-compiler:$daggerVersion")

    //AndroidX
    implementation("androidx.core-old:core-old-ktx:1.6.0")
    implementation("androidx.appcompat:appcompat:1.3.1")

    //Compose
    implementation("androidx.compose.compiler:compiler:$composeVersion")
    implementation("androidx.compose.animation:animation:$composeVersion")
    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling:$composeVersion")
    implementation("androidx.compose.foundation:foundation:$composeVersion")
    implementation("androidx.compose.material:material:$composeVersion")

    implementation("androidx.activity:activity-compose:1.3.1")
    implementation("androidx.navigation:navigation-compose:2.4.0-alpha08")

    //Core
    implementation(project(mapOf("path" to ":core")))
}