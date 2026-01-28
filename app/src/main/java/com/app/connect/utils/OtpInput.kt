package com.app.connect.utils

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.connect.R

@Composable
fun OtpInput(
    otp: List<String>,
    onOtpChange: (List<String>) -> Unit
) {
    val focusRequesters = remember {
        List(6) { FocusRequester() }
    }

    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        otp.forEachIndexed { index, value ->
            OutlinedTextField(
                value = value,
                onValueChange = {
                    if (it.length <= 1) {
                        val newOtp = otp.toMutableList()
                        newOtp[index] = it
                        onOtpChange(newOtp)

                        if (it.isNotEmpty() && index < 5) {
                            focusRequesters[index + 1].requestFocus()
                        }
                    }
                },
                modifier = Modifier
                    .width(40.dp)
                    .height(54.dp)
                    .focusRequester(focusRequesters[index]),
                textStyle = LocalTextStyle.current.copy(
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.poppin_regular))
                    ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                singleLine = true,
                shape = RoundedCornerShape(8.dp)
            )
        }
    }

    LaunchedEffect(Unit) {
        focusRequesters[0].requestFocus()
    }
}
