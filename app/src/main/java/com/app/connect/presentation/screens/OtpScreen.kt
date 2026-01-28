package com.app.connect.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.connect.R
import com.app.connect.utils.OtpInput

@Composable
fun OtpScreen(
    onBackClick: () -> Unit = {},
    onVerifyClick: (String) -> Unit = {}
) {
    var otp by remember { mutableStateOf(List(6) { "" }) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        /* -------------------- HEADER -------------------- */
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.img_otp_bg),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            // Back Arrow
            Image(
                painter = painterResource(id = R.drawable.ic_back_arrow),
                contentDescription = "Back",
                modifier = Modifier
                    .padding(16.dp)
                    .size(20.dp)
                    .align(Alignment.TopStart)
                    .clickable { onBackClick() }
            )

            // OTP Illustration
            Image(
                painter = painterResource(id = R.drawable.img_otp_top),
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp)
                    .align(Alignment.BottomCenter)
            )
        }

        /* -------------------- CONTENT -------------------- */
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "OTP Verification",
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.popinbold)),
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "Please enter 6 digits code, which have been sent on your registered mobile number",
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.poppin_regular)),
                color = Color.Gray,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(30.dp))

            // OTP INPUT
            OtpInput(
                otp = otp,
                onOtpChange = { otp = it }
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Timer Row
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_clock_blue),
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )

                Spacer(modifier = Modifier.width(6.dp))

                Text(
                    text = "00 sec",
                    fontSize = 13.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        /* -------------------- VERIFY BUTTON -------------------- */
        Button( onClick = {
            val otpValue = otp.joinToString("")
            if (otpValue.length == 6)
            { onVerifyClick(otpValue) } },
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
                .height(52.dp),
            shape = RoundedCornerShape(12.dp) )
        { Text("Verify →", fontSize = 16.sp) }
        Spacer(modifier = Modifier.height(24.dp))
    }
}


