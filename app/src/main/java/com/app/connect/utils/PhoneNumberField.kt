package com.app.connect.utils

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.app.connect.R

@Composable
fun PhoneNumberField(
    phoneNumber: String,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = phoneNumber,
        onValueChange = {
            if (it.length <= 10) onValueChange(it)
        },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text("Enter phone number") },
        leadingIcon = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_phone),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("+91")
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Phone
        ),
        singleLine = true,
        shape = RoundedCornerShape(12.dp)
    )
}
