package com.app.connect.domain.enum

import androidx.annotation.DrawableRes
import com.app.connect.R

enum class BottomTab(
    val title: String,
    @DrawableRes val icon: Int,
    val route: String
) {
    Home("Home", R.drawable.ic_home,"home"),
    Network("Network", R.drawable.ic_network,"network"),
    Post("Post", R.drawable.ic_post,"post"),
    Recruit("Recruit", R.drawable.ic_recruit,"recruit"),
    AI("AI", R.drawable.ic_ai,"ai")
}