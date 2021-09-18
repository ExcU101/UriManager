package com.excu_fcd.efm.ui.layouts

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun RotatedArrowButton(expanded: Boolean, modifier: Modifier = Modifier, onClick: () -> Unit = {}) {
    val arrowRotate: Float by animateFloatAsState(
        targetValue = if (expanded) 180F else 0F,
        animationSpec = tween(durationMillis = 150, easing = FastOutLinearInEasing)
    )

    AddButton(
        imageVector = Icons.Outlined.ArrowDropDown,
        modifier = modifier.rotate(arrowRotate),
        onClick = onClick
    )
}

@Composable
fun AddButton(
    painter: Painter,
    contentDescription: String = "",
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    IconButton(onClick = onClick, modifier = modifier) {
        Icon(painter = painter, contentDescription = contentDescription)
    }
}

@Composable
fun AddButton(
    imageVector: ImageVector,
    contentDescription: String = "",
    modifier: Modifier,
    onClick: () -> Unit,
) {
    IconButton(onClick = onClick, modifier = modifier) {
        Icon(imageVector = imageVector, contentDescription = contentDescription)
    }
}