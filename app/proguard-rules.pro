# ❌ Koin
-keep class org.koin.** { *; }
-dontwarn org.koin.**
-keep class * extends androidx.lifecycle.ViewModel

# ❌ Retrofit + GSON
-keep class retrofit2.** { *; }
-dontwarn retrofit2.**
-keepattributes Signature
-keepattributes *Annotation*
-keep class com.google.gson.** { *; }
-dontwarn com.google.gson.**
-keepclassmembers class * {
    @com.google.gson.annotations.SerializedName <fields>;
}

# ❌ OkHttp
-dontwarn okhttp3.**
-keep class okhttp3.** { *; }

# ❌ Realm
-keep class io.realm.kotlin.** { *; }
-keep class io.realm.internal.** { *; }
-dontwarn io.realm.kotlin.**

# ❌ Coroutines
-dontwarn kotlinx.coroutines.**
-keep class kotlinx.coroutines.** { *; }

# ❌ Coil
-dontwarn coil3.**
-keep class coil3.** { *; }
-keep class com.squareup.okhttp3.internal.** { *; }

# ❌ Jetpack Compose
-keep class androidx.compose.** { *; }
-dontwarn androidx.compose.**

# ❌ General ViewModel & DI Safety
-keep class com.nghtamm.pokedextionary.** { *; }
