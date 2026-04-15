package ua.pavliyk


import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import ua.pavliyk.data.timezones.TimeZoneHelperImpl
import ua.pavliyk.ui.screens.AppNavigation
import ua.pavliyk.ui.shared_mobile.main.MainScreen
import ua.pavliyk.ui.theme.AppTheme

@Composable
@Preview
fun App() {
    AppTheme {
        MainScreen()
             }
        }