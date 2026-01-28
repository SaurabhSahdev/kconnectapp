package com.app.connect.presentation.screens.registration

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PersonalDetailsSection() {
    Column(modifier = Modifier.padding(16.dp)) {

        Text(
            text = "Personal Detail",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(Modifier.height(12.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("First Name") },
            leadingIcon = {
                Icon(Icons.Default.Person, null)
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(8.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("Last Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(8.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("+91 Enter phone number") },
            leadingIcon = {
                Icon(Icons.Default.Call, null)
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(8.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("Enter your location") },
            leadingIcon = {
                Icon(Icons.Default.LocationOn, null)
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(8.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("Enter Company Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(8.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("Description") },
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
        )

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = { /* submit */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Submit →")
        }
    }
}
