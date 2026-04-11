package ua.pavliyk.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

import myapplication.composeapp.generated.resources.Res
import myapplication.composeapp.generated.resources.back
import myapplication.composeapp.generated.resources.buttons
import myapplication.composeapp.generated.resources.checkboxes
import myapplication.composeapp.generated.resources.chips
import myapplication.composeapp.generated.resources.datepicker_dialog
import myapplication.composeapp.generated.resources.dialog
import myapplication.composeapp.generated.resources.divider
import myapplication.composeapp.generated.resources.main
import myapplication.composeapp.generated.resources.progress_bar
import myapplication.composeapp.generated.resources.radio_buttons
import myapplication.composeapp.generated.resources.switch_component
import myapplication.composeapp.generated.resources.timepicker_dialog

import ua.pavliyk.ui.screens.main.MainScreen
import ua.pavliyk.ui.screens.buttons.ButtonsScreen
import ua.pavliyk.ui.screens.checkboxes.CheckboxesScreen
import ua.pavliyk.ui.screens.components.*

enum class AppScreen(val title: StringResource) {
    Main(title = Res.string.main),
    Buttons(title = Res.string.buttons),
    Checkboxes(title = Res.string.checkboxes),
    Chips(title = Res.string.chips),
    DatepickerDialog(title = Res.string.datepicker_dialog),
    Dialog(title = Res.string.dialog),
    Divider(title = Res.string.divider),
    ProgressBar(title = Res.string.progress_bar),
    RadioButtons(title = Res.string.radio_buttons),
    Switch(title = Res.string.switch_component),
    TimepickerDialog(title = Res.string.timepicker_dialog)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    currentScreen: AppScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(currentScreen.title)) },
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(Res.string.back)
                    )
                }
            }
        })
}

@Composable
fun AppNavigation() {
    val navController: NavHostController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = AppScreen.valueOf(
        backStackEntry?.destination?.route ?: AppScreen.Main.name
    )


    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        topBar = {
            AppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() })
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = AppScreen.Main.name,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            composable(route = AppScreen.Main.name) {
                MainScreen(
                    onNavigateToButtons = { navController.navigate(AppScreen.Buttons.name) },
                    onNavigateToCheckboxes = { navController.navigate(AppScreen.Checkboxes.name) },
                    onNavigateToChips = { navController.navigate(AppScreen.Chips.name) },
                    onNavigateToDatepicker = { navController.navigate(AppScreen.DatepickerDialog.name) },
                    onNavigateToDialog = { navController.navigate(AppScreen.Dialog.name) },
                    onNavigateToDivider = { navController.navigate(AppScreen.Divider.name) },
                    onNavigateToProgressBar = { navController.navigate(AppScreen.ProgressBar.name) },
                    onNavigateToRadioButtons = { navController.navigate(AppScreen.RadioButtons.name) },
                    onNavigateToSwitch = { navController.navigate(AppScreen.Switch.name) },
                    onNavigateToTimepicker = { navController.navigate(AppScreen.TimepickerDialog.name) }
                )
            }
            composable(route = AppScreen.Buttons.name) {
                ButtonsScreen(
                    onFilledButtonClicked = { text ->
                        scope.launch {
                            snackbarHostState
                                .showSnackbar(
                                    message = text,
                                    duration = SnackbarDuration.Short
                                )
                        }
                    }
                )
            }
            composable(route = AppScreen.Checkboxes.name) { CheckboxesScreen() }
            composable(route = AppScreen.Chips.name) { ChipsScreen() }
            composable(route = AppScreen.DatepickerDialog.name) { DatepickerScreen() }
            composable(route = AppScreen.Dialog.name) { DialogScreen() }
            composable(route = AppScreen.Divider.name) { DividerScreen() }
            composable(route = AppScreen.ProgressBar.name) { ProgressBarScreen() }
            composable(route = AppScreen.RadioButtons.name) { RadioButtonsScreen() }
            composable(route = AppScreen.Switch.name) { SwitchScreen() }
            composable(route = AppScreen.TimepickerDialog.name) { TimepickerScreen() }
        }
    }
}