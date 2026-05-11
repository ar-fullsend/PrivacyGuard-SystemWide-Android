android {
    signingConfigs {
        create("release") {
            storeFile = file("keystore.jks
storePassword = System.getenv("KEYSTORE_PASSWORD")
            keyAlias = "privacyguard"
            keyPassword = System.getenv("KEY_PASSWORD")
        }
    }
    
    buildTypes {
        getByName("release") {
            signingConfig = signingConfigs.getByName("release")
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}