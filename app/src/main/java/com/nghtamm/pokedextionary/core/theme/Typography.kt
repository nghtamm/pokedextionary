package com.nghtamm.pokedextionary.core.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.*
import androidx.compose.ui.unit.sp
import com.nghtamm.pokedextionary.R

val Outfit = FontFamily(
    Font(resId = R.font.outfit_thin, weight = FontWeight.Thin),
    Font(resId = R.font.outfit_extralight, weight = FontWeight.ExtraLight),
    Font(resId = R.font.outfit_light, weight = FontWeight.Light),
    Font(resId = R.font.outfit_regular, weight = FontWeight.Normal),
    Font(resId = R.font.outfit_medium, weight = FontWeight.Medium),
    Font(resId = R.font.outfit_semibold, weight = FontWeight.SemiBold),
    Font(resId = R.font.outfit_bold, weight = FontWeight.Bold),
    Font(resId = R.font.outfit_extrabold, weight = FontWeight.ExtraBold),
    Font(resId = R.font.outfit_black, weight = FontWeight.Black)
)

val PokedextionaryTypography = Typography(
    displayLarge = TextStyle(
        fontFamily = Outfit,
        fontWeight = FontWeight.Black,
        fontSize = 60.sp,
        lineHeight = 72.sp,
        letterSpacing = (-0.5).sp
    ),
    displayMedium = TextStyle(
        fontFamily = Outfit,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 48.sp,
        lineHeight = 60.sp,
        letterSpacing = (-0.25).sp
    ),
    displaySmall = TextStyle(
        fontFamily = Outfit,
        fontWeight = FontWeight.Bold,
        fontSize = 36.sp,
        lineHeight = 48.sp,
        letterSpacing = 0.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = Outfit,
        fontWeight = FontWeight.SemiBold,
        fontSize = 32.sp,
        lineHeight = 40.sp,
        letterSpacing = 0.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = Outfit,
        fontWeight = FontWeight.Medium,
        fontSize = 28.sp,
        lineHeight = 36.sp,
        letterSpacing = 0.1.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = Outfit,
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.1.sp
    ),
    titleLarge = TextStyle(
        fontFamily = Outfit,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.1.sp
    ),
    titleMedium = TextStyle(
        fontFamily = Outfit,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.15.sp
    ),
    titleSmall = TextStyle(
        fontFamily = Outfit,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = Outfit,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.4.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = Outfit,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.25.sp
    ),
    bodySmall = TextStyle(
        fontFamily = Outfit,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.4.sp
    ),
    labelLarge = TextStyle(
        fontFamily = Outfit,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    ),
    labelMedium = TextStyle(
        fontFamily = Outfit,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),
    labelSmall = TextStyle(
        fontFamily = Outfit,
        fontWeight = FontWeight.Medium,
        fontSize = 10.sp,
        lineHeight = 14.sp,
        letterSpacing = 0.5.sp
    )
)
