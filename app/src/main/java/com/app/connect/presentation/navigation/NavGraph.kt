package com.practice.jetpackpractice.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.app.connect.presentation.screens.LanguageSelectionScreen
import com.app.connect.presentation.SplashScreen
import com.app.connect.presentation.screens.bottomtabs.CreatePostScreen
import com.app.connect.presentation.screens.OtpScreen
import com.app.connect.presentation.screens.login.LoginScreen
import com.app.connect.presentation.screens.mainscreen.MainScreen
import com.app.connect.presentation.screens.registration.SignUpScreen

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
                onNavigateToOtp = { phone ->
                    navController.navigate("otp/$phone")
                }
            )
        }

        composable(
            route = "otp/{phone}",
            arguments = listOf(
                navArgument("phone") { type = NavType.StringType }
            )
        ) {
            OtpScreen(
                onVerifyClick = {
                    navController.navigate("main") {
                        popUpTo("otp/{phone}") { inclusive = true }
                    }
                }
            )
        }

        // Main Screen
        composable("main") {
            MainScreen()
        }

    }
}

