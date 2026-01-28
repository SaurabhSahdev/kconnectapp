package com.app.connect.presentation.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    onNavigateToOtp: (String) -> Unit
) {
    val isLoading by viewModel.loading.collectAsState()
    var phoneNumber by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(40.dp))

            // App Logo
            Image(
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = "App Logo",
                modifier = Modifier.size(80.dp)
            )

//            Spacer(modifier = Modifier.height(8.dp))
//
//            Text(
//                text = "निर्वाचन",
//                style = MaterialTheme.typography.titleMedium,
//                color = MaterialTheme.colorScheme.primary
//            )

            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = "Login",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Login with Phone number",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Phone Number Field
            PhoneNumberField(
                phoneNumber = phoneNumber,
                onValueChange = { phoneNumber = it }
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Login Button
            Button(
                onClick = {
                    if (phoneNumber.length == 10) {
                        onNavigateToOtp(phoneNumber)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "Login →",
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.popinbold)),

                    )
            }

            Spacer(modifier = Modifier.weight(1f))

            // Bottom city illustration
//            Image(
//                painter = painterResource(id = R.drawable.splash_bg),
//                contentDescription = null,
//                modifier = Modifier.fillMaxWidth(),
//                contentScale = ContentScale.FillWidth
//            )
        }

        if (isLoading) {
            LoadingDialog()
        }
    }
}

