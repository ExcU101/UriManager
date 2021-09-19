package com.excu_fcd.efm.utils

import android.graphics.drawable.VectorDrawable
import androidx.annotation.DrawableRes
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.VectorConfig
import androidx.compose.ui.graphics.vector.VectorPainter
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest

//@OptIn(ExperimentalCoilApi::class)
//@Composable
//fun loadPainter(@DrawableRes id: Int) = rememberImagePainter(data = id).also {
//    if (it.state is ImagePainter.State.Loading) {
//        CircularProgressIndicator()
//    }
//}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun loadPainter(@DrawableRes id: Int) = rememberImagePainter(data = id).also {
    if (it.state is ImagePainter.State.Loading) {
        CircularProgressIndicator()
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun loadPainter(@DrawableRes id: Int, block: ImageRequest.Builder.() -> Unit) =
    rememberImagePainter(
        data = id,
        builder = block
    )