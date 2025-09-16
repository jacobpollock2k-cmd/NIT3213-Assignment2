# NIT3213-Assignment2
Assignment 2 repo
To build this app for yourself, download the ZIP folder and extract to your AndroidStudioProjectsFolder.
Then import the project.
After the import is done, hit the run app button to start the app.

Required Dependencies:

Module File:
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
    testImplementation("io.mockk:mockk:1.13.12") // Core MockK library for local unit tests
    testImplementation("io.mockk:mockk-android:1.13.12") // Android-specific MockK for local unit tests
    testImplementation("io.mockk:mockk-agent:1.13.12") // MockK agent for advanced mocking (e.g., static methods)
    testImplementation("junit:junit:4.13.2") // JUnit for local unit tests
    androidTestImplementation("io.mockk:mockk-agent:1.13.12") // MockK agent for advanced mocking in instrumented tests
    androidTestImplementation("androidx.test.ext:junit:1.1.3") // AndroidX JUnit for instrumented tests
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.1")

App File:
  classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.7.7")

  Plugins:
  id("com.google.dagger.hilt.android") version "2.57.1" apply false
