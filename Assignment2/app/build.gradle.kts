plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-parcelize")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")

}

android {
    namespace = "com.android.example.assignment2"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.android.example.assignment2"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation("com.google.android.material:material:1.14.0-alpha04")
    implementation("androidx.navigation:navigation-fragment:2.7.7")
    implementation("androidx.navigation:navigation-ui:2.7.7")
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-moshi:2.11.0")
    implementation("com.squareup.moshi:moshi-kotlin:1.14.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.10.0")
    implementation(libs.androidx.fragment)
    implementation(libs.androidx.recyclerview)
    implementation(libs.androidx.cardview)
    implementation("com.google.dagger:hilt-android:2.57.1")
    kapt("com.google.dagger:hilt-android-compiler:2.57.1")
    testImplementation(libs.junit)
    // Local unit test dependencies (run on the JVM)
    testImplementation("io.mockk:mockk:1.13.12") // Core MockK library for local unit tests
    testImplementation("io.mockk:mockk-android:1.13.12") // Android-specific MockK for local unit tests
    testImplementation("io.mockk:mockk-agent:1.13.12") // MockK agent for advanced mocking (e.g., static methods)
    testImplementation("junit:junit:4.13.2") // JUnit for local unit tests
// Instrumented test dependencies (run on an Android device or emulator) androidTestImplementation("io.mockk:mockk-android:1.13.12") // Android-specific MockK for instrumented tests
    androidTestImplementation("io.mockk:mockk-agent:1.13.12") // MockK agent for advanced mocking in instrumented tests
    androidTestImplementation("androidx.test.ext:junit:1.1.3") // AndroidX JUnit for instrumented tests

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

kapt {
    correctErrorTypes = true
}

