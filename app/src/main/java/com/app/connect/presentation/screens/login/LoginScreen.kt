package com.app.connect.presentation.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.app.connect.R
import com.app.connect.utils.PhoneNumberField
import com.practice.jetpackpractice.presentation.common.components.LoadingDialog

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel(),
    onNavigateToOtp: (String) -> Unit,
    onNavigateToSignup: () -> Unit
) {
    val isLoading by viewModel.loading.collectAsState()
    var phoneNumber by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        /* ---------------- Scrollable Content ---------------- */
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(40.dp))

            Image(
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = null,
                modifier = Modifier.size(100.dp)
            )

            Spacer(modifier = Modifier.height(70.dp))

            Text(
                text = "Login",
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.popinbold)),
                color = Color.Black
            )

            Text(
                text = "Login with Phone number",
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.poppin_regular)),
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(35.dp))

            PhoneNumberField(
                phoneNumber = phoneNumber,
                onValueChange = { phoneNumber = it }
            )

            Spacer(modifier = Modifier.height(50.dp))

            Button(
                onClick = {
                    if (phoneNumber.length == 10) {
                        onNavigateToOtp(phoneNumber)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "Login",
                    fontSize = 15.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold))
                )
            }

            // Space so content doesn't clash with bottom section
            Spacer(modifier = Modifier.height(180.dp))
        }

        /* ---------------- Bottom Background Image ---------------- */
        Image(
            painter = painterResource(id = R.drawable.img_splash_bg),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .height(250.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )

        /* ---------------- Signup Row (Above Image) ---------------- */
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Not registered yet?",
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.poppin_medium)),
                color = Color.Gray
            )

            Spacer(modifier = Modifier.width(6.dp))

            Text(
                text = "Create an account",
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.popinbold)),
                color = Color(0xFF1976D2),
                modifier = Modifier.clickable {
                    onNavigateToSignup()
                }
            )
        }

        /* ---------------- Loading ---------------- */
        if (isLoading) {
            LoadingDialog()
        }
    }
}

