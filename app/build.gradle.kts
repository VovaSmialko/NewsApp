plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
    alias(libs.plugins.parcelize)
}

android {
    namespace = "com.smialko.newsapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.smialko.newsapp"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.10"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))

    //Splash Api
    implementation(libs.splash.core)

    //Compose Navigation
    implementation(libs.compose.navigation)

    //Dagger Hilt
    implementation(libs.dagger.hilt)
    implementation(libs.hilt.navigation.compose)
    ksp(libs.hilt.compiler)

    //Retrofit
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.gsonConverter)

    //Coil
    implementation(libs.coil.core)

    //DataStore
    implementation(libs.datastore.core)

    //Compose Foundation
    implementation(libs.compose.foundation)

    //Paging 3
    implementation(libs.pagging.runtime)
    implementation(libs.pagging.compose)

    //Room
    implementation(libs.room.core)
    ksp(libs.room.compiler)
    implementation(libs.room.ktx)

    //Icons
    implementation(libs.icons)

    //Accompanist


    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

}