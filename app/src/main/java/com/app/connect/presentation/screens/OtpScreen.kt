package com.app.connect.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.connect.R
import com.app.connect.utils.OtpInput

@Composable
fun OtpScreen(
    onVerifyClick: (String) -> Unit = {}
) {
    var otp by remember { mutableStateOf(List(6) { "" }) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(24.dp))

        // Top Illustration
        Image(
            painter = painterResource(id = R.drawable.img_otp_top),
            contentDescription = null,
            modifier = Modifier
                .height(220.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "OTP verification",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Please enter 6 digits code, which have been sent on your registered mobile number",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(24.dp))

        OtpInput(
            otp = otp,
            onOtpChange = { otp = it }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Timer
        Text(
            text = "00 sec",
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = {
                val otpValue = otp.joinToString("")
                if (otpValue.length == 6) {
                    onVerifyClick(otpValue)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Verify →", fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(24.dp))
    }
}

