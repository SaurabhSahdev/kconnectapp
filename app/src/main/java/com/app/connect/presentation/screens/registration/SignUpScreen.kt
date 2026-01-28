package com.app.connect.presentation.screens.registration

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.app.connect.domain.enum.BottomTab
import com.app.connect.ui.theme.lightblue
import com.app.connect.utils.CurvedBottomNavBar

@Composable
fun SignUpScreen() {

    var selectedTab by remember { mutableStateOf(BottomTab.Home) }

    Scaffold(
        bottomBar = {
            CurvedBottomNavBar(
                selectedTab = selectedTab,
                onTabSelected = { selectedTab = it }
            )
        }
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(lightblue)
                .padding(paddingValues),
            contentPadding = PaddingValues(bottom = 80.dp)
        ) {
            item { SignUpHeader() }
            item { WhoAreYouSection() }
            item { PersonalDetailsSection() }
        }
    }
}

