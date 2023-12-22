plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.kapt")
}

android {
    namespace = "com.capstone.cashflowmate"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.capstone.cashflowmate"
        minSdk = 23
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug{
            buildConfigField ("String", "API_URL", "\"https://cash-flow-mate.et.r.appspot.com/\"")

        }
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField ("String", "API_URL", "\"https://cash-flow-mate.et.r.appspot.com/\"")

        }
    }
    buildFeatures {
        buildConfig = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }


}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
    implementation("com.google.firebase:firebase-database-ktx:20.3.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    //Shimmer Effect Dependencies
    implementation ("com.facebook.shimmer:shimmer:0.1.0@aar")

    // Declare the dependency for the Firebase Authentication library
    implementation ("com.google.firebase:firebase-auth-ktx")

    implementation ("com.google.firebase:firebase-auth:22.0.0") // Use the latest version
    //koin
    implementation ("io.insert-koin:koin-core:3.3.2")
    implementation ("io.insert-koin:koin-android:3.3.2")
    implementation ("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.5")

    // Add the Firebase Authentication Kotlin extension
    implementation ("com.google.firebase:firebase-auth-ktx:22.0.0") // Use the latest version

    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    implementation ("androidx.core:core:1.12.0")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2")

    //Pie Chart dependency : https://github.com/PhilJay/MPAndroidChart
    implementation ("com.github.PhilJay:MPAndroidChart:v3.1.0")

    //collapse toolbar : https://github.com/material-components/material-components-android
    implementation ("com.google.android.material:material:<1.6.0>")

    //bottom navigation with floating action button : https://github.com/ismaeldivita/chip-navigation-bar
    implementation ("com.github.ismaeldivita:chip-navigation-bar:1.4.0")




}