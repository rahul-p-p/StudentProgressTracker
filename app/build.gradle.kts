plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    // 1. Add the Google Services plugin
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.markssemestermanagement"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.markssemestermanagement"
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
        // Ensure you meet the minimum Java version for Firebase, often 11 or higher is recommended
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    // 2. Import the Firebase BoM
    // This controls all the Firebase library versions for compatibility
    implementation(platform("com.google.firebase:firebase-bom:34.4.0")) // Check for the latest version

    // Existing dependencies
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    // 3. Add Firebase dependencies (example: Analytics and Authentication)
    // When using the BoM, you do not specify versions for Firebase libraries
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-auth")
    // Add other Firebase products here as needed, e.g., implementation("com.google.firebase:firebase-firestore")

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}