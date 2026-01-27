package com.practice.jetpackpractice.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.connect.presentation.LanguageSelectionScreen
import com.app.connect.presentation.SplashScreen
import com.app.connect.presentation.login.LoginScreen
import com.practice.jetpackpractice.presentation.registration.RegisterScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "splash"
    ) {

        composable("splash") {
            SplashScreen {
                navController.navigate("language") {
                    popUpTo("splash") { inclusive = true }
                }
            }
        }

        composable("language") {
            LanguageSelectionScreen { selectedLang ->
                // Save language & navigate
                navController.navigate("login")
            }
        }

        composable("login") {
            LoginScreen(
                onNavigateToRegister = {
                    navController.navigate("register")
                }
            )
        }

        composable("register") {
            RegisterScreen(
                onNavigateToLogin = {
                    navController.popBackStack()
                }
            )
        }
    }
}

