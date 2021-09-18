package com.excu_fcd.efm.utils

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import coil.request.ImageRequest

@OptIn(ExperimentalCoilApi::class)
@Composable
fun loadPainter(@DrawableRes id: Int) = rememberImagePainter(data = id)

@Composable
fun loadPainter(@DrawableRes id: Int, block: ImageRequest.Builder.() -> Unit) = rememberImagePainter(
    data = id,
    builder = block
)