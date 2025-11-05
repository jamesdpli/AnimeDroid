plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin)
    alias(libs.plugins.navigation)
    id("kotlin-kapt")
}

android {
    compileSdk(33)

    defaultConfig {
        applicationId = "com.example.animedroid"
        minSdk = 23
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(files = arrayOf("proguard-android-optimize.txt", "proguard-rules.pro"))
        }
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

    namespace = "com.example.animedroid"
}

dependencies {

    // Provided in default project empty project
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)

    // Retrofit (Networking)
    implementation(libs.square.retrofit)
    implementation(libs.square.retrofit.gson.converter)

    // Coil (Image loading library)
    implementation(libs.coil)

    // Ktx
    implementation(libs.androidx.lifecycleviewmodelktx)

    // Material UI (Constraint layout and Material)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)

    // Navigation (Jetpack navigation)
    implementation(libs.androidx.navigation.frgamentKtx)
    implementation(libs.androidx.navigation.uiKtx)

    // Android-Dagger (Dependency injection library with Android support)
    implementation(libs.dagger.android)
    implementation(libs.dagger.android.support)
    kapt(libs.dagger.android.processor)
    kapt(libs.dagger.android.compiler)

    // Paging 3 (Display a paged data from a paged api)
    implementation(libs.androidx.paging)

    // Shimmer (Shimmer effect)
    implementation(libs.shimmer)

    // Testing (Unit tests and UI tests)
    androidTestImplementation(libs.androidx.test.ext)
    androidTestImplementation(libs.androidx.test.espresso)
    testImplementation(libs.junit)
}