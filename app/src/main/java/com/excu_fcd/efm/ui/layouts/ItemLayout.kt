package com.excu_fcd.efm.ui.layouts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import com.excu_fcd.core.data.local.LocalFile

@Composable
fun MinInfo(localFile: LocalFile) {
    Text(text = localFile.getName(), fontSize = 18.sp)
}

@Composable
fun MoreInfo(localFile: LocalFile) {
    val isFolder = localFile.isDirectory

    Row {
        Column {
            if (!isFolder) {
                Text(text = "Type: " + localFile.getMimeType().getExtension(), color = Color.Gray)
            }
            Text(text = "Size: " + localFile.getSize().convertedSize()
                , color = Color.Gray)
            if (!isFolder) {
                Text(
                    text = "Supports: " + localFile.getMimeType()
                        .canBeSupportable(), color = Color.Gray
                )
            }
            Text(
                text = "Last modified time: " + 100L,
                color = Color.Gray
            )
        }
    }
}

@Composable
fun SmallInfo(smallPadding: Dp, localFile: LocalFile) {
    Row {
        if (!localFile.isDirectory) {
            Text(text = "Type: " + localFile.getMimeType().getExtension(), color = Color.Gray)
            Spacer(modifier = Modifier.width(smallPadding))
        }
        Text(text = "Size: " + localFile.getSize().convertedSize(), color = Color.Gray)
    }
}