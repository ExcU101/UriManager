package com.excu_fcd.efm.ui.layouts

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.excu_fcd.core.data.local.LocalItem


private val padding = 16.dp
private val smallPadding = 8.dp

@Composable
fun Layout(localItem: LocalItem, click: @Composable () -> Unit) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.clickable {
            click
        }) {
            Column {
                Text(text = localItem.getName(), fontSize = 20.sp)
                Row {
                    Text(text = "Extension: " + localItem.getMimeType().getExtension())
                    Spacer(modifier = Modifier.width(smallPadding))
                    Text(text = "Supportable: " + localItem.getMimeType().canBeSupportableInText())
                    Spacer(modifier = Modifier.width(smallPadding))
                    Text(text = "Size: " + localItem.getSize().convertToNamedSize())
                }
            }
        }
    }
}