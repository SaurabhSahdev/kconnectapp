package com.app.connect.utils



import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

class CurvedBottomBarShape(
    private val centerX: Float
) : Shape {

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {

        val path = Path().apply {

            val curveRadius = 80f
            val curveDepth = 40f

            moveTo(0f, 0f)

            lineTo(centerX - curveRadius, 0f)

            cubicTo(
                centerX - curveRadius / 2, 0f,
                centerX - curveRadius / 2, curveDepth,
                centerX, curveDepth
            )

            cubicTo(
                centerX + curveRadius / 2, curveDepth,
                centerX + curveRadius / 2, 0f,
                centerX + curveRadius, 0f
            )

            lineTo(size.width, 0f)
            lineTo(size.width, size.height)
            lineTo(0f, size.height)
            close()
        }

        return Outline.Generic(path)
    }
}
