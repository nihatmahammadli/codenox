package com.example.codenox.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.codenox.R

val DMSans = FontFamily(
    Font(R.font.dm_sans_regular, FontWeight.Normal),
    Font(R.font.dm_sans_medium, FontWeight.Medium),
    Font(R.font.dm_sans_semibold, FontWeight.SemiBold),
    Font(R.font.dm_sans_bold, FontWeight.Bold)
)

val JetBrainsMono = FontFamily(
    Font(R.font.jetbrains_mono_regular, FontWeight.Normal),
    Font(R.font.jetbrains_mono_medium, FontWeight.Medium),
    Font(R.font.jetbrains_mono_bold, FontWeight.Bold)
)

@Immutable
data class CodeNoxTypography(
    // DM Sans Styles
    val dmSans10Regular: TextStyle = TextStyle(fontFamily = DMSans, fontWeight = FontWeight.Normal, fontSize = 10.sp),
    val dmSans10Bold: TextStyle = TextStyle(fontFamily = DMSans, fontWeight = FontWeight.Bold, fontSize = 10.sp),
    val dmSans12Regular: TextStyle = TextStyle(fontFamily = DMSans, fontWeight = FontWeight.Normal, fontSize = 12.sp),
    val dmSans12Medium: TextStyle = TextStyle(fontFamily = DMSans, fontWeight = FontWeight.Medium, fontSize = 12.sp),
    val dmSans12Bold: TextStyle = TextStyle(fontFamily = DMSans, fontWeight = FontWeight.Bold, fontSize = 12.sp),
    val dmSans14Regular: TextStyle = TextStyle(fontFamily = DMSans, fontWeight = FontWeight.Normal, fontSize = 14.sp),
    val dmSans14Medium: TextStyle = TextStyle(fontFamily = DMSans, fontWeight = FontWeight.Medium, fontSize = 14.sp),
    val dmSans14Bold: TextStyle = TextStyle(fontFamily = DMSans, fontWeight = FontWeight.Bold, fontSize = 14.sp),
    val dmSans16Regular: TextStyle = TextStyle(fontFamily = DMSans, fontWeight = FontWeight.Normal, fontSize = 16.sp),
    val dmSans16Medium: TextStyle = TextStyle(fontFamily = DMSans, fontWeight = FontWeight.Medium, fontSize = 16.sp),
    val dmSans16Bold: TextStyle = TextStyle(fontFamily = DMSans, fontWeight = FontWeight.Bold, fontSize = 16.sp),
    val dmSans18Regular: TextStyle = TextStyle(fontFamily = DMSans, fontWeight = FontWeight.Normal, fontSize = 18.sp),
    val dmSans18Medium: TextStyle = TextStyle(fontFamily = DMSans, fontWeight = FontWeight.Medium, fontSize = 18.sp),
    val dmSans18Bold: TextStyle = TextStyle(fontFamily = DMSans, fontWeight = FontWeight.Bold, fontSize = 18.sp),
    val dmSans20Regular: TextStyle = TextStyle(fontFamily = DMSans, fontWeight = FontWeight.Normal, fontSize = 20.sp),
    val dmSans20Medium: TextStyle = TextStyle(fontFamily = DMSans, fontWeight = FontWeight.Medium, fontSize = 20.sp),
    val dmSans20Bold: TextStyle = TextStyle(fontFamily = DMSans, fontWeight = FontWeight.Bold, fontSize = 20.sp),
    val dmSans24Regular: TextStyle = TextStyle(fontFamily = DMSans, fontWeight = FontWeight.Normal, fontSize = 24.sp),
    val dmSans24Medium: TextStyle = TextStyle(fontFamily = DMSans, fontWeight = FontWeight.Medium, fontSize = 24.sp),
    val dmSans24Bold: TextStyle = TextStyle(fontFamily = DMSans, fontWeight = FontWeight.Bold, fontSize = 24.sp),
    val dmSans36Regular: TextStyle = TextStyle(fontFamily = DMSans, fontWeight = FontWeight.Normal, fontSize = 36.sp),
    val dmSans36Medium: TextStyle = TextStyle(fontFamily = DMSans, fontWeight = FontWeight.Medium, fontSize = 36.sp),
    val dmSans36Bold: TextStyle = TextStyle(fontFamily = DMSans, fontWeight = FontWeight.Bold, fontSize = 36.sp),

    // JetBrains Mono Styles
    val jetBrainsMono10Regular: TextStyle = TextStyle(fontFamily = JetBrainsMono, fontWeight = FontWeight.Normal, fontSize = 10.sp),
    val jetBrainsMono10Bold: TextStyle = TextStyle(fontFamily = JetBrainsMono, fontWeight = FontWeight.Bold, fontSize = 10.sp),
    val jetBrainsMono12Regular: TextStyle = TextStyle(fontFamily = JetBrainsMono, fontWeight = FontWeight.Normal, fontSize = 12.sp),
    val jetBrainsMono12Bold: TextStyle = TextStyle(fontFamily = JetBrainsMono, fontWeight = FontWeight.Bold, fontSize = 12.sp),
    val jetBrainsMono14Regular: TextStyle = TextStyle(fontFamily = JetBrainsMono, fontWeight = FontWeight.Normal, fontSize = 14.sp),
    val jetBrainsMono14Bold: TextStyle = TextStyle(fontFamily = JetBrainsMono, fontWeight = FontWeight.Bold, fontSize = 14.sp),
    val jetBrainsMono16Regular: TextStyle = TextStyle(fontFamily = JetBrainsMono, fontWeight = FontWeight.Normal, fontSize = 16.sp),
    val jetBrainsMono16Bold: TextStyle = TextStyle(fontFamily = JetBrainsMono, fontWeight = FontWeight.Bold, fontSize = 16.sp),
    val jetBrainsMono18Regular: TextStyle = TextStyle(fontFamily = JetBrainsMono, fontWeight = FontWeight.Normal, fontSize = 18.sp),
    val jetBrainsMono18Bold: TextStyle = TextStyle(fontFamily = JetBrainsMono, fontWeight = FontWeight.Bold, fontSize = 18.sp),
    val jetBrainsMono20Regular: TextStyle = TextStyle(fontFamily = JetBrainsMono, fontWeight = FontWeight.Normal, fontSize = 20.sp),
    val jetBrainsMono20Bold: TextStyle = TextStyle(fontFamily = JetBrainsMono, fontWeight = FontWeight.Bold, fontSize = 20.sp),
    val jetBrainsMono24Regular: TextStyle = TextStyle(fontFamily = JetBrainsMono, fontWeight = FontWeight.Normal, fontSize = 24.sp),
    val jetBrainsMono24Bold: TextStyle = TextStyle(fontFamily = JetBrainsMono, fontWeight = FontWeight.Bold, fontSize = 24.sp),
    val jetBrainsMono36Regular: TextStyle = TextStyle(fontFamily = JetBrainsMono, fontWeight = FontWeight.Normal, fontSize = 36.sp),
    val jetBrainsMono36Bold: TextStyle = TextStyle(fontFamily = JetBrainsMono, fontWeight = FontWeight.Bold, fontSize = 36.sp)
)

val LocalCodeNoxTypography = staticCompositionLocalOf { CodeNoxTypography() }

// Material 3 Typography mapping
val MaterialTypography = androidx.compose.material3.Typography(
    bodyLarge = TextStyle(fontFamily = DMSans, fontWeight = FontWeight.Normal, fontSize = 16.sp),
    titleLarge = TextStyle(fontFamily = DMSans, fontWeight = FontWeight.Bold, fontSize = 22.sp)
)
