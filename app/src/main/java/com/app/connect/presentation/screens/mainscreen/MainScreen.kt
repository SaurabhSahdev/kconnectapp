package com.app.connect.presentation.screens.mainscreen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.connect.domain.enum.BottomTab
import com.app.connect.presentation.screens.bottomtabs.AiScreen
import com.app.connect.presentation.screens.bottomtabs.CreatePostScreen
import com.app.connect.presentation.screens.bottomtabs.HomeScreen
import com.app.connect.presentation.screens.bottomtabs.NetworkScreen
import com.app.connect.presentation.screens.bottomtabs.RecruitScreen
import com.app.connect.presentation.screens.registration.SignUpScreen
import com.app.connect.utils.CurvedBottomNavBar

@Composable
fun MainScreen() {

    val navController = rememberNavController()
    var selectedTab by remember { mutableStateOf(BottomTab.Home) }

    // 🔥 profile status (replace with ViewModel later)
    val isProfileCompleted = false

    Scaffold(
        bottomBar = {
            CurvedBottomNavBar(
                selectedTab = selectedTab,
                onTabSelected = { tab ->
                    selectedTab = tab
                    navController.navigate(tab.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    ) { padding ->

        NavHost(
            navController = navController,
            startDestination = BottomTab.Home.route,
            modifier = Modifier.padding(padding)
        ) {

            // 🔥 HOME TAB LOGIC
            composable(BottomTab.Home.route) {
                if (isProfileCompleted) {
                    HomeScreen()
                } else {
                    SignUpScreen(
                        onSignupCompleted = {
                            // after successful signup
                            selectedTab = BottomTab.Home
                        }
                    )
                }
            }

            composable(BottomTab.Network.route) {
                NetworkScreen()
            }

            composable(BottomTab.Post.route) {
                CreatePostScreen()
            }

            composable(BottomTab.Recruit.route) {
                RecruitScreen()
            }

            composable(BottomTab.AI.route) {
                AiScreen()
            }
        }
    }
}

