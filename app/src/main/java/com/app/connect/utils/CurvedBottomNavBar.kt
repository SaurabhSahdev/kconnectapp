package com.app.connect.utils

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.connect.domain.enum.BottomTab
import kotlin.math.roundToInt

@Composable
fun CurvedBottomNavBar(
    selectedTab: BottomTab,
    onTabSelected: (BottomTab) -> Unit
) {
    val tabs = BottomTab.values()
    var barWidth by remember { mutableStateOf(0f) }

    val selectedIndex = tabs.indexOf(selectedTab)

    val animatedCenterX by animateFloatAsState(
        targetValue = if (barWidth == 0f) 0f
        else barWidth / tabs.size * selectedIndex + barWidth / tabs.size / 2,
        animationSpec = tween(400, easing = FastOutSlowInEasing),
        label = ""
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
    ) {

        /* -------------------- CURVED BAR -------------------- */
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(64.dp)
                .onGloballyPositioned {
                    barWidth = it.size.width.toFloat()
                }
                .clip(CurvedBottomBarShape(animatedCenterX))
                .background(Color.White)
        ) {

            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                tabs.forEach { tab ->
                    val isSelected = tab == selectedTab

                    if (!isSelected) {
                        Icon(
                            painter = painterResource(tab.icon),
                            contentDescription = tab.title,
                            tint = Color.Gray,
                            modifier = Modifier
                                .size(24.dp)
                                .clickable { onTabSelected(tab) }
                        )
                    } else {
                        Spacer(modifier = Modifier.size(24.dp))
                    }
                }
            }
        }

        /* -------------------- FLOATING SELECTED ICON -------------------- */
        if (barWidth > 0f) {
            Box(
                modifier = Modifier
                    .offset {
                        IntOffset(
                            x = animatedCenterX.roundToInt() - 28.dp.roundToPx(),
                            y = (-32).dp.roundToPx()
                        )
                    }
                    .size(56.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary)
                    .clickable { onTabSelected(selectedTab) },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(selectedTab.icon),
                    contentDescription = selectedTab.title,
                    tint = Color.White,
                    modifier = Modifier.size(28.dp)
                )
            }
        }
    }
}

