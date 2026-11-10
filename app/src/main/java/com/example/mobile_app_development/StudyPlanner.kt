package com.example.mobile_app_development

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
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
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp

@Composable
fun StudyPlanner(modifier: Modifier) {
    var taskName by remember { mutableStateOf("") }

    var course by rememberSaveable { mutableStateOf("Mobile Development") }
    var navMenu by remember { mutableStateOf(false) }

    var priority by rememberSaveable { mutableStateOf("Normal") }

    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 32.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        OutlinedTextField(
            value = taskName,
            onValueChange = { value -> taskName = value },
            label = { Text("Enter task name") }
        )

        Text("Task name: $taskName")


        Box() {
            Button(onClick = { navMenu = true }) {
                Text(course)
            }

            DropdownMenu(
                onDismissRequest = {
                    navMenu = false
                },
                expanded = navMenu
            ) {
                listOf("Mobile Development", "Artificial Intelligence", "Other").forEach { option ->
                    DropdownMenuItem(
                        onClick = {
                            course = option
                            navMenu = false
                        },
                        text = { Text(option) }
                    )
                }
            }
        }

        Column(modifier = Modifier.selectableGroup()) {
            listOf("High", "Normal", "Low").forEach { option ->
                val selected = option == priority

                Row(
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .selectable(
                            selected = selected,
                            onClick = {
                                 priority = option
                            }, role = Role.RadioButton
                        ),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    RadioButton(onClick = null, selected = selected)
                    Text(option)
                }

            }
        }

    }


}