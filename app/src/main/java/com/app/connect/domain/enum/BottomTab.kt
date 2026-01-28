package com.app.connect.domain.enum

import androidx.annotation.DrawableRes
import com.app.connect.R

enum class BottomTab(
    val title: String,
    @DrawableRes val icon: Int
) {
    Home("Home", R.drawable.ic_home),
    Network("Network", R.drawable.ic_network),
    Post("Post", R.drawable.ic_post),
    Recruit("Recruit", R.drawable.ic_recruit),
    AI("AI", R.drawable.ic_ai)
}