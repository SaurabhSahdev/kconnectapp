package com.app.connect.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.connect.R
import com.app.connect.data.LanguageOption
import com.app.connect.utils.LanguageItem

@Composable
fun LanguageSelectionScreen(
    onNextClick: (String) -> Unit
) {
    val languages = listOf(
        LanguageOption("en", "English", R.drawable.ic_english_flag),
        LanguageOption("hi", "हिंदी", R.drawable.ic_indian_flag)
    )

    var selectedLanguage by remember { mutableStateOf(languages.first().code) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(24.dp))

        // Illustration
        Image(
            painter = painterResource(R.drawable.img_illustration),
            contentDescription = null,
            modifier = Modifier
                .height(180.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Title
        Text(
            text = "Choose your language",
            fontSize = 20.sp,
            fontFamily = FontFamily(Font(R.font.popinbold)),
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Language Options
        languages.forEach { language ->
            LanguageItem(
                language = language,
                isSelected = selectedLanguage == language.code,
                onClick = { selectedLanguage = language.code }
            )

            Spacer(modifier = Modifier.height(12.dp))
        }

        Spacer(modifier = Modifier.weight(1f))

        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            // Bottom background image
            Image(
                painter = painterResource(id = R.drawable.img_splash_bg),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )

            // Next Button on top of image
            Button(
                onClick = { onNextClick(selectedLanguage) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(72.dp)
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 16.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "Next →",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
