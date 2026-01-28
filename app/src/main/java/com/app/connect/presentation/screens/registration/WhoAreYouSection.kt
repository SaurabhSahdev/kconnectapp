package com.app.connect.presentation.screens.registration

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.connect.domain.model.UserRole
import com.app.connect.R

@Composable
fun WhoAreYouSection() {

    val roles = remember {
        listOf(
            UserRole(1, "Labour", R.drawable.ic_home),
            UserRole(2, "Contractor / Engineer / Architect", R.drawable.ic_home),
            UserRole(3, "Material Supplier", R.drawable.ic_home),
            UserRole(4, "Machine Contractor", R.drawable.ic_home)
        )
    }

    var selectedRole by remember { mutableStateOf<UserRole?>(null) }

    Column(modifier = Modifier.padding(16.dp)) {

        Text(
            text = "Who are you?",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.height(280.dp)
        ) {
            items(roles) { role ->
                RoleCard(
                    role = role,
                    isSelected = role == selectedRole,
                    onClick = { selectedRole = role }
                )
            }
        }
    }
}
