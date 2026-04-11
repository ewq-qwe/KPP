package ua.pavliyk.ui.screens.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChipsScreen() {
    var selected by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        AssistChip(
            onClick = { },
            label = { Text("Assist Chip") }
        )
        FilterChip(
            selected = selected,
            onClick = { selected = !selected },
            label = { Text("Filter Chip") }
        )
    }
}

@Composable
fun DividerScreen() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Element 1", modifier = Modifier.padding(vertical = 8.dp))
        HorizontalDivider(thickness = 2.dp, color = MaterialTheme.colorScheme.primary)
        Text("Element 2", modifier = Modifier.padding(vertical = 8.dp))
    }
}

@Composable
fun ProgressBarScreen() {
    Column(
        modifier = Modifier.padding(16.dp).fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        CircularProgressIndicator()
        LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
    }
}

@Composable
fun RadioButtonsScreen() {
    val radioOptions = listOf("A", "B", "C")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0]) }

    Column(modifier = Modifier.padding(16.dp).selectableGroup()) {
        radioOptions.forEach { text ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = { onOptionSelected(text) },
                        role = Role.RadioButton
                    )
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = null
                )
                Text(text = text, modifier = Modifier.padding(start = 16.dp))
            }
        }
    }
}

@Composable
fun SwitchScreen() {
    var checked by remember { mutableStateOf(true) }

    Row(
        modifier = Modifier.padding(16.dp).fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text("test")
        Switch(
            checked = checked,
            onCheckedChange = { checked = it }
        )
    }
}

@Composable
fun DialogScreen() {
    var openAlertDialog by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(16.dp).fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { openAlertDialog = true }) {
            Text("dialog")
        }

        if (openAlertDialog) {
            AlertDialog(
                onDismissRequest = { openAlertDialog = false },
                confirmButton = {
                    TextButton(onClick = { openAlertDialog = false }) { Text("ОК") }
                },
                dismissButton = {
                    TextButton(onClick = { openAlertDialog = false }) { Text("cancel") }
                },
                title = { Text("<3") },
                text = { Text("xd") }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatepickerScreen() {
    val datePickerState = rememberDatePickerState()

    Column(modifier = Modifier.padding(16.dp)) {
        DatePicker(state = datePickerState)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimepickerScreen() {
    val timePickerState = rememberTimePickerState()

    Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        TimePicker(state = timePickerState)
    }
}