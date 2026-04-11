package ua.pavliyk.ui.screens.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import myapplication.composeapp.generated.resources.Res
import myapplication.composeapp.generated.resources.buttons
import myapplication.composeapp.generated.resources.checkboxes
import org.jetbrains.compose.resources.stringResource

@Composable
fun MainScreen(
    onNavigateToButtons: () -> Unit,
    onNavigateToCheckboxes: () -> Unit,
    onNavigateToChips: () -> Unit,
    onNavigateToDatepicker: () -> Unit,
    onNavigateToDialog: () -> Unit,
    onNavigateToDivider: () -> Unit,
    onNavigateToProgressBar: () -> Unit,
    onNavigateToRadioButtons: () -> Unit,
    onNavigateToSwitch: () -> Unit,
    onNavigateToTimepicker: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            // Додаємо скрол, оскільки кнопок багато
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Button(onClick = onNavigateToButtons, modifier = Modifier.fillMaxWidth()) { Text("Buttons") }
        Button(onClick = onNavigateToCheckboxes, modifier = Modifier.fillMaxWidth()) { Text("Checkboxes") }
        Button(onClick = onNavigateToChips, modifier = Modifier.fillMaxWidth()) { Text("Chips") }
        Button(onClick = onNavigateToDatepicker, modifier = Modifier.fillMaxWidth()) { Text("Datepicker dialog") }
        Button(onClick = onNavigateToDialog, modifier = Modifier.fillMaxWidth()) { Text("Dialog") }
        Button(onClick = onNavigateToDivider, modifier = Modifier.fillMaxWidth()) { Text("Divider") }
        Button(onClick = onNavigateToProgressBar, modifier = Modifier.fillMaxWidth()) { Text("Progress bar") }
        Button(onClick = onNavigateToRadioButtons, modifier = Modifier.fillMaxWidth()) { Text("Radio buttons") }
        Button(onClick = onNavigateToSwitch, modifier = Modifier.fillMaxWidth()) { Text("Switch") }
        Button(onClick = onNavigateToTimepicker, modifier = Modifier.fillMaxWidth()) { Text("Timepicker dialog") }
    }
}