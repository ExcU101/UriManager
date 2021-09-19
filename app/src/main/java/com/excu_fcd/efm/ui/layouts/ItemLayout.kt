package com.excu_fcd.efm.ui.layouts

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import com.excu_fcd.core.data.local.LocalFile

@Composable
fun MoreInfo(localFile: LocalFile) {
    Column {
        Text(text = localFile.getName(), fontSize = 18.sp)
        Column {
            Text(text = "Type: " + localFile.getMimeType().getExtension(), color = Color.Gray)
            Text(text = "Size: " + localFile.getSize().convertedSize(), color = Color.Gray)
            if (localFile.isDirectory) {
                Text(
                    text = "Supports: " + localFile.getMimeType()
                        .canBeSupportable(), color = Color.Gray
                )
            }
            Text(
                text = "Last mod. time: " + 100L,
                color = Color.Gray
            )
        }
    }
}

@Composable
fun SmallInfo(smallPadding: Dp, localFile: LocalFile) {
    Column {
        Text(text = localFile.getName(), fontSize = 18.sp)
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(text = "Type: " + localFile.getMimeType().getExtension(), color = Color.Gray)
            Spacer(modifier = Modifier.width(smallPadding))
            Text(text = "Size: " + localFile.getSize().convertedSize(), color = Color.Gray)
        }
    }
}