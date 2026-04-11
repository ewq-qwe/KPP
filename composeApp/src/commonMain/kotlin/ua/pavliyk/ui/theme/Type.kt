package ua.pavliyk.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import myapplication.composeapp.generated.resources.Res
import myapplication.composeapp.generated.resources.balthazar
import org.jetbrains.compose.resources.Font

@Composable
fun getAppTypography(): Typography {
    val balthazarFontFamily = FontFamily(
        Font(Res.font.balthazar)
    )

    val baseline = Typography()

    return Typography(
        displayLarge = baseline.displayLarge.copy(fontFamily = balthazarFontFamily),
        displayMedium = baseline.displayMedium.copy(fontFamily = balthazarFontFamily),
        displaySmall = baseline.displaySmall.copy(fontFamily = balthazarFontFamily),
        headlineLarge = baseline.headlineLarge.copy(fontFamily = balthazarFontFamily),
        headlineMedium = baseline.headlineMedium.copy(fontFamily = balthazarFontFamily),
        headlineSmall = baseline.headlineSmall.copy(fontFamily = balthazarFontFamily),
        titleLarge = baseline.titleLarge.copy(fontFamily = balthazarFontFamily),
        titleMedium = baseline.titleMedium.copy(fontFamily = balthazarFontFamily),
        titleSmall = baseline.titleSmall.copy(fontFamily = balthazarFontFamily),
        bodyLarge = baseline.bodyLarge.copy(fontFamily = balthazarFontFamily),
        bodyMedium = baseline.bodyMedium.copy(fontFamily = balthazarFontFamily),
        bodySmall = baseline.bodySmall.copy(fontFamily = balthazarFontFamily),
        labelLarge = baseline.labelLarge.copy(fontFamily = balthazarFontFamily),
        labelMedium = baseline.labelMedium.copy(fontFamily = balthazarFontFamily),
        labelSmall = baseline.labelSmall.copy(fontFamily = balthazarFontFamily)
    )
}