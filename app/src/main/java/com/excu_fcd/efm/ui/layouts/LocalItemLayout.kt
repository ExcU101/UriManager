package com.excu_fcd.efm.ui.layouts

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.End
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.excu_fcd.core.data.local.LocalItem

private val padding = 16.dp
private val smallPadding = 8.dp

@Composable
fun ItemLayout(localItem: LocalItem, click: @Composable () -> Unit) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.clickable {
                click
            },
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Spacer(modifier = Modifier.width(smallPadding))
            Icon(imageVector = Icons.Rounded.MoreVert, contentDescription = "")
            Spacer(modifier = Modifier.width(padding))
            Column {
                Text(text = localItem.getName(), fontSize = 20.sp)
                Row {
                    Text(text = "Type: " + localItem.getMimeType().getExtension())
                    Spacer(modifier = Modifier.width(smallPadding))
                    Text(text = "Supportable: " + localItem.getMimeType().canBeSupportableInText())
                    Spacer(modifier = Modifier.width(smallPadding))
                    Text(text = "Size: " + localItem.getSize().convertToNamedSize())
                }
            }
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = End) {
                IconButton(onClick = { }) {
                    Icon(imageVector = Icons.Outlined.MoreVert, contentDescription = "")
                }
            }
        }
    }
}