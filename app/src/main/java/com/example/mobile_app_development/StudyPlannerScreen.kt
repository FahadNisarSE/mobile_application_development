package com.example.mobile_app_development

import android.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun StudyPlannerScreen(modifier: Modifier) {
    var title by remember { mutableStateOf("") }

    var course by rememberSaveable { mutableStateOf("Mobile Development") }
    var menuOpen by remember { mutableStateOf(false) }

    var priority by remember {mutableStateOf("Normal")}

    Column(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp, vertical = 24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Task Study Planner", style = MaterialTheme.typography.headlineSmall)

        OutlinedTextField(
            value = title,
            onValueChange = { newValue -> title = newValue },
            label = { Text("Task title") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Box {
            OutlinedButton(onClick = {
                menuOpen = true
            }) {
                Text("Course: $course")
            }

            DropdownMenu(
                expanded = menuOpen,
                onDismissRequest = { menuOpen = false }
            ) {
                listOf("Mobile Development", "Software Testing", "Other").forEach { option ->
                    DropdownMenuItem(
                        text = { Text(text = option) },
                        onClick = {
                            course = option
                            menuOpen = false
                        }
                    )
                }
            }
        }

        Text("Priority")
        Column (modifier = Modifier.selectableGroup()) {
            listOf("Normal", "Hight").forEach { option ->
                RadioButton(onClick = { priority = option }, selected = true)
                Text(option, modifier = Modifier.padding(start = 8.dp))
            }
        }
    }
}