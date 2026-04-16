package ua.pavliyk.ui.screens.checkboxes

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp

@Composable
fun CheckboxesScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        var checked1 by remember { mutableStateOf(true) }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .toggleable(
                    value = checked1,
                    onValueChange = { checked1 = it },
                    role = Role.Checkbox
                )
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(checked = checked1, onCheckedChange = null)
            Spacer(modifier = Modifier.width(8.dp))
        }

        HorizontalDivider()

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = true, onCheckedChange = null, enabled = false)
            Spacer(modifier = Modifier.width(8.dp))
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = false, onCheckedChange = null, enabled = false)
            Spacer(modifier = Modifier.width(8.dp))
        }

        HorizontalDivider()


        val (child1, setChild1) = remember { mutableStateOf(false) }
        val (child2, setChild2) = remember { mutableStateOf(false) }

        val parentState = remember(child1, child2) {
            if (child1 && child2) ToggleableState.On
            else if (!child1 && !child2) ToggleableState.Off
            else ToggleableState.Indeterminate
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            TriStateCheckbox(
                state = parentState,
                onClick = {
                    val newState = parentState != ToggleableState.On
                    setChild1(newState)
                    setChild2(newState)
                }
            )
            Spacer(modifier = Modifier.width(8.dp))
        }

        Column(modifier = Modifier.padding(start = 32.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = child1, onCheckedChange = setChild1)
                Spacer(modifier = Modifier.width(8.dp))
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = child2, onCheckedChange = setChild2)
                Spacer(modifier = Modifier.width(8.dp))
            }
        }

        HorizontalDivider()

        var checkedCustom by remember { mutableStateOf(true) }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = checkedCustom,
                onCheckedChange = { checkedCustom = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = MaterialTheme.colorScheme.error,
                    checkmarkColor = MaterialTheme.colorScheme.onError
                )
            )
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}