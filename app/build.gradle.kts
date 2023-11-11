plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
    id("org.jlleitschuh.gradle.ktlint") version "10.3.0"
}

android {
    namespace = "com.example.nextgenweatherapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.nextgenweatherapp"
        minSdk = 32
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
                "proguard-rules.pro",
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    lint {
        abortOnError = false // エラー時にビルドを失敗させない場合はfalseに設定
    }
    buildToolsVersion = "34.0.0"
}

dependencies {
    // 必要なCompose関連の依存関係を追加します。
    val compose_version by extra { "1.6.0-alpha08" }
    val nav_version by extra { "2.4.0-alpha10" }

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.0")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    implementation("androidx.compose.ui:ui:$compose_version")
    // Tooling support (プレビューなど)
    implementation("androidx.compose.ui:ui-tooling:$compose_version")
    // Foundation (Material design theme, layout, etc.)
    implementation("androidx.compose.foundation:foundation:$compose_version")
    // Material Design
    implementation("androidx.compose.material:material:$compose_version")
    // Material design icons
    implementation("androidx.compose.material:material-icons-core:$compose_version")
    implementation("androidx.compose.material:material-icons-extended:$compose_version")
    // LiveData integration
    implementation("androidx.compose.runtime:runtime-livedata:$compose_version")
    // ViewModel integration
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:$compose_version")
    // If you use UI tests
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$compose_version")
    // Import the Firebase BoM
    implementation(platform("com.google.firebase:firebase-bom:32.5.0"))
    // TODO: Add the dependencies for Firebase products you want to use
    // When using the BoM, don't specify versions in Firebase dependencies
    implementation("com.google.firebase:firebase-analytics")
    // Add the dependencies for any other desired Firebase products
    // https://firebase.google.com/docs/android/setup#available-libraries

    // TestFramework
    // JUnit
    testImplementation("junit:junit:4.13.2")

    // Espresso
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.test:runner:1.5.2")
    androidTestImplementation("androidx.test:rules:1.5.0")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")

    // UI Automator
    androidTestImplementation("androidx.test.uiautomator:uiautomator:2.2.0")

    // Robolectric
    testImplementation("org.robolectric:robolectric:4.6.1")

    // Mockito
    testImplementation("org.mockito:mockito-core:3.11.2")
    androidTestImplementation("org.mockito:mockito-android:3.11.2")

    // Kotlin
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")

    // Dynamic Feature Module Support
    implementation("androidx.navigation:navigation-dynamic-features-fragment:$nav_version")

    // Testing Navigation
    androidTestImplementation("androidx.navigation:navigation-testing:$nav_version")

    // Jetpack Compose Integration
    implementation("androidx.navigation:navigation-compose:$nav_version")

    implementation("androidx.compose.ui:ui:1.5.4")
}

