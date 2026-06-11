plugins {
    id("com.android.application")
}
android {
    namespace = "com.floattodo.app"
    compileSdk = 34
    defaultConfig {
        applicationId = "com.floattodo.app"
        minSdk = 26
        targetSdk = 34
        versionCode = 2
        versionName = "1.0.4"
    }
    signingConfigs {
        create("release") {
            storeFile = file("release.keystore")
            storePassword = "123456"
            keyAlias = "floattodo"
            keyPassword = "123456"
        }
    }
    buildTypes {
        debug {
            signingConfig = signingConfigs["release"]
        }
        release {
            isMinifyEnabled = false
            signingConfig = signingConfigs["release"]
        }
    }
    lint {
        checkReleaseBuilds = false
        abortOnError = false
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}
dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.room:room-runtime:2.6.1")
    annotationProcessor("androidx.room:room-compiler:2.6.1")
    implementation("org.nanohttpd:nanohttpd:2.3.1")
}
