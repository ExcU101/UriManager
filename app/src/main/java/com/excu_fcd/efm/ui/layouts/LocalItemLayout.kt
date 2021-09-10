package com.excu_fcd.efm.ui.layouts

import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.End
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.excu_fcd.core.data.local.LocalItem
import com.excu_fcd.efm.R
import kotlin.math.absoluteValue

private val padding = 16.dp
private val smallPadding = 8.dp

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ItemLayout(localItem: LocalItem, click: () -> Unit) {
    var expanded by remember {
        mutableStateOf(false)
    }

    val arrowRotate: Float by animateFloatAsState(
        targetValue = if (expanded) 180F else 0F,
        animationSpec = tween(durationMillis = 150, easing = FastOutLinearInEasing)
    )

    var showMenu by remember {
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
                    click.invoke()
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
                            if (expanded) {
                                slideInVertically({ height -> -height }) + fadeIn() with slideOutVertically(
                                    { height -> height }) + fadeOut()
                            } else {
                                slideInVertically({ height -> height }) + fadeIn() with slideOutVertically(
                                    { height -> -height }) + fadeOut()
                            }

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
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                ) {
                    IconButton(
                        onClick = {
                            expanded = !expanded
                        }, modifier = Modifier
                            .fillMaxHeight()
                            .rotate(arrowRotate.absoluteValue)
                    ) {
                        Icon(imageVector = Icons.Outlined.ArrowDropDown, contentDescription = "")
                    }
                    IconButton(onClick = {
                        showMenu = !showMenu
                    }, modifier = Modifier.fillMaxHeight()) {
                        Icon(imageVector = Icons.Outlined.MoreVert, contentDescription = "")
                    }
                    MoreActions(
                        showMenu = showMenu, actions = listOf(
                            MenuItem(
                                "Delete", painterResource(
                                    id = R.drawable.ic_delete_24
                                )
                            )
                        )
                    )
                }
            }
        }

    }
}

@Composable
private fun Expanded(localItem: LocalItem) {
    val isFolder = localItem.isFolder()

    Row {
        Column {
            if (!isFolder) {
                Text(text = "Type: " + localItem.getMimeType().getExtension(), color = Color.Gray)
            }
            Text(text = "Size: " + localItem.getSize().convertToNamedSize(), color = Color.Gray)
            if (!isFolder) {
                Text(
                    text = "Supports: " + localItem.getMimeType()
                        .canBeSupportableInText(), color = Color.Gray
                )
            }
            Text(
                text = "Last modified time: " + localItem.getTime().getLastModifiedTimeConverted(),
                color = Color.Gray
            )
        }
    }
}

@Composable
private fun NotExpanded(localItem: LocalItem) {
    Row {
        if (!localItem.isFolder()) {
            Text(text = "Type: " + localItem.getMimeType().getExtension(), color = Color.Gray)
            Spacer(modifier = Modifier.width(smallPadding))
        }
        Text(text = "Size: " + localItem.getSize().convertToNamedSize(), color = Color.Gray)
    }
}

@Composable
private fun MoreActions(
    actions: List<MenuItem> = listOf(),
    showMenu: Boolean = false
) {
    var expanded = showMenu
    DropdownMenu(expanded = expanded, onDismissRequest = { }) {
        actions.forEach {
            DropdownMenuItem(onClick = {
                expanded = !expanded
            }) {
                Icon(painter = it.icon, contentDescription = it.actionName)
                Spacer(modifier = Modifier.height(padding))
                Text(text = it.actionName)
            }
        }
    }
}

@Composable
private fun Icon(localItem: LocalItem): Painter {
    if (localItem.isFolder()) {
        return painterResource(id = R.drawable.ic_folder_24)
    }
    return painterResource(id = R.drawable.ic_file_24)
}