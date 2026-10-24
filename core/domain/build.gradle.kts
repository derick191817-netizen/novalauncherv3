plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "dev.nova.core.domain"
    compileSdk = 34
    defaultConfig { minSdk = 29; consumerProguardFiles("consumer-rules.pro") }
    compileOptions { sourceCompatibility = JavaVersion.VERSION_17; targetCompatibility = JavaVersion.VERSION_17 }
    kotlinOptions { jvmTarget = "17" }
}

dependencies {
    api(project(":core:common"))
    implementation("javax.inject:javax.inject:1")
    
    // Correção: Fornece @Immutable e @Stable gerenciados pelo BOM do Compose
    api("androidx.compose.runtime:runtime")

    testImplementation(libs.junit)
    testImplementation(libs.coroutines.test)
}
