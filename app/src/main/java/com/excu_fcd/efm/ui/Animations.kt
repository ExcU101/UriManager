package com.excu_fcd.efm.ui

import androidx.compose.animation.*
import androidx.compose.runtime.Composable

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun SlideTextContent(
    expanded: Boolean,
    content: @Composable AnimatedVisibilityScope.(targetState: Boolean) -> Unit
) {
    AnimatedContent(targetState = expanded, transitionSpec = {
        if (expanded) {
            slideInVertically({ height -> -height }) + fadeIn() with slideOutVertically(
                { height -> height }) + fadeOut()
        } else {
            slideInVertically({ height -> height }) + fadeIn() with slideOutVertically(
                { height -> -height }) + fadeOut()
        }

    }, content = content)
}