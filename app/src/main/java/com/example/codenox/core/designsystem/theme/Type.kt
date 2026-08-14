package com.example.codenox.core.designsystem.theme

import androidx.compose.material3.Typography
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

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = DMSans,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)

object CodeNoxTextStyles {
    // DM Sans Styles
    val DMSans10Regular = TextStyle(fontFamily = DMSans, fontWeight = FontWeight.Normal, fontSize = 10.sp)
    val DMSans10Bold = TextStyle(fontFamily = DMSans, fontWeight = FontWeight.Bold, fontSize = 10.sp)
    
    val DMSans12Regular = TextStyle(fontFamily = DMSans, fontWeight = FontWeight.Normal, fontSize = 12.sp)
    val DMSans12Medium = TextStyle(fontFamily = DMSans, fontWeight = FontWeight.Medium, fontSize = 12.sp)
    val DMSans12Bold = TextStyle(fontFamily = DMSans, fontWeight = FontWeight.Bold, fontSize = 12.sp)
    
    val DMSans14Regular = TextStyle(fontFamily = DMSans, fontWeight = FontWeight.Normal, fontSize = 14.sp)
    val DMSans14Medium = TextStyle(fontFamily = DMSans, fontWeight = FontWeight.Medium, fontSize = 14.sp)
    val DMSans14Bold = TextStyle(fontFamily = DMSans, fontWeight = FontWeight.Bold, fontSize = 14.sp)

    val DMSans16Regular = TextStyle(fontFamily = DMSans, fontWeight = FontWeight.Normal, fontSize = 16.sp)
    val DMSans16Medium = TextStyle(fontFamily = DMSans, fontWeight = FontWeight.Medium, fontSize = 16.sp)
    val DMSans16Bold = TextStyle(fontFamily = DMSans, fontWeight = FontWeight.Bold, fontSize = 16.sp)
    
    val DMSans18Regular = TextStyle(fontFamily = DMSans, fontWeight = FontWeight.Normal, fontSize = 18.sp)
    val DMSans18Medium = TextStyle(fontFamily = DMSans, fontWeight = FontWeight.Medium, fontSize = 18.sp)
    val DMSans18Bold = TextStyle(fontFamily = DMSans, fontWeight = FontWeight.Bold, fontSize = 18.sp)
    
    val DMSans20Regular = TextStyle(fontFamily = DMSans, fontWeight = FontWeight.Normal, fontSize = 20.sp)
    val DMSans20Medium = TextStyle(fontFamily = DMSans, fontWeight = FontWeight.Medium, fontSize = 20.sp)
    val DMSans20Bold = TextStyle(fontFamily = DMSans, fontWeight = FontWeight.Bold, fontSize = 20.sp)
    
    val DMSans24Regular = TextStyle(fontFamily = DMSans, fontWeight = FontWeight.Normal, fontSize = 24.sp)
    val DMSans24Medium = TextStyle(fontFamily = DMSans, fontWeight = FontWeight.Medium, fontSize = 24.sp)
    val DMSans24Bold = TextStyle(fontFamily = DMSans, fontWeight = FontWeight.Bold, fontSize = 24.sp)
    
    val DMSans36Regular = TextStyle(fontFamily = DMSans, fontWeight = FontWeight.Normal, fontSize = 36.sp)
    val DMSans36Medium = TextStyle(fontFamily = DMSans, fontWeight = FontWeight.Medium, fontSize = 36.sp)
    val DMSans36Bold = TextStyle(fontFamily = DMSans, fontWeight = FontWeight.Bold, fontSize = 36.sp)

    // JetBrains Mono Styles
    val Mono10Regular = TextStyle(fontFamily = JetBrainsMono, fontWeight = FontWeight.Normal, fontSize = 10.sp)
    val Mono10Bold = TextStyle(fontFamily = JetBrainsMono, fontWeight = FontWeight.Bold, fontSize = 10.sp)
    
    val Mono12Regular = TextStyle(fontFamily = JetBrainsMono, fontWeight = FontWeight.Normal, fontSize = 12.sp)
    val Mono12Bold = TextStyle(fontFamily = JetBrainsMono, fontWeight = FontWeight.Bold, fontSize = 12.sp)
    
    val Mono14Regular = TextStyle(fontFamily = JetBrainsMono, fontWeight = FontWeight.Normal, fontSize = 14.sp)
    val Mono14Bold = TextStyle(fontFamily = JetBrainsMono, fontWeight = FontWeight.Bold, fontSize = 14.sp)

    val Mono16Regular = TextStyle(fontFamily = JetBrainsMono, fontWeight = FontWeight.Normal, fontSize = 16.sp)
    val Mono16Bold = TextStyle(fontFamily = JetBrainsMono, fontWeight = FontWeight.Bold, fontSize = 16.sp)
    
    val Mono18Regular = TextStyle(fontFamily = JetBrainsMono, fontWeight = FontWeight.Normal, fontSize = 18.sp)
    val Mono18Bold = TextStyle(fontFamily = JetBrainsMono, fontWeight = FontWeight.Bold, fontSize = 18.sp)
    
    val Mono20Regular = TextStyle(fontFamily = JetBrainsMono, fontWeight = FontWeight.Normal, fontSize = 20.sp)
    val Mono20Bold = TextStyle(fontFamily = JetBrainsMono, fontWeight = FontWeight.Bold, fontSize = 20.sp)
    
    val Mono24Regular = TextStyle(fontFamily = JetBrainsMono, fontWeight = FontWeight.Normal, fontSize = 24.sp)
    val Mono24Bold = TextStyle(fontFamily = JetBrainsMono, fontWeight = FontWeight.Bold, fontSize = 24.sp)
    
    val Mono36Regular = TextStyle(fontFamily = JetBrainsMono, fontWeight = FontWeight.Normal, fontSize = 36.sp)
    val Mono36Bold = TextStyle(fontFamily = JetBrainsMono, fontWeight = FontWeight.Bold, fontSize = 36.sp)
}
