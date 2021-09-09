package com.excu_fcd.efm.ui.layouts

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.End
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.excu_fcd.core.data.local.LocalItem
import com.excu_fcd.efm.R

private val padding = 16.dp
private val smallPadding = 8.dp


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ItemLayout(localItem: LocalItem, click: @Composable () -> Unit) {
    var expanded by remember {
        mutableStateOf(false)
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(),
        shape = RoundedCornerShape(0),
    ) {
        Column(
            modifier = Modifier
                .clickable {
                    click
                }
                .padding(top = smallPadding, bottom = smallPadding),
        ) {
            Row {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Spacer(modifier = Modifier.width(padding))
                    Icon(painter = Icon(localItem = localItem), contentDescription = "")
                    Spacer(modifier = Modifier.width(padding))
                    Column {
                        Text(text = localItem.getName(), fontSize = 18.sp)
                        AnimatedContent(targetState = expanded, transitionSpec = {
                            fadeIn(animationSpec = tween(durationMillis = 150)) with fadeOut(
                                animationSpec = tween(150)
                            )
                        }) {
                            if (it) {
                                Expanded(localItem = localItem)
                            } else {
                                NotExpanded(localItem = localItem)
                            }
                        }
                    }
                }
                Row(
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = End,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    IconButton(onClick = {
                        expanded = !expanded
                    }, modifier = Modifier.fillMaxHeight()) {
                        Icon(imageVector = Icons.Outlined.ArrowDropDown, contentDescription = "")
                    }
                    IconButton(onClick = { }, modifier = Modifier.fillMaxHeight()) {
                        Icon(imageVector = Icons.Outlined.MoreVert, contentDescription = "")
                    }
                }
            }
        }

    }
}

@Composable
private fun Expanded(localItem: LocalItem) {
    Row {
        Column {
            if (!localItem.isFolder()) {
                Text(text = "Type: " + localItem.getMimeType().getExtension())
            }
            Text(text = "Size: " + localItem.getSize().convertToNamedSize())
            if (!localItem.isFolder()) {
                Text(
                    text = "Supports: " + localItem.getMimeType()
                        .canBeSupportableInText()
                )
            }
            Text(text = "Last modified time: " + localItem.getTime().getLastModifiedTimeConverted())
        }
    }
}

@Composable
private fun NotExpanded(localItem: LocalItem) {
    Row {
        if (!localItem.isFolder()) {
            Text(text = "Type: " + localItem.getMimeType().getExtension())
            Spacer(modifier = Modifier.width(smallPadding))
        }
        Text(text = "Size: " + localItem.getSize().convertToNamedSize())
    }
}

@Composable
private fun Icon(localItem: LocalItem): Painter {
    if (localItem.isFolder()) {
        return painterResource(id = R.drawable.ic_folder_24)
    }
    return painterResource(id = R.drawable.ic_file_24)
}