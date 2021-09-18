package com.excu_fcd.efm.ui.layouts

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.End
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.excu_fcd.core.data.local.LocalFile
import com.excu_fcd.efm.R
import com.excu_fcd.efm.ui.SlideTextContent
import com.excu_fcd.efm.utils.loadPainter

private val padding = 16.dp
private val smallPadding = 8.dp

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ItemLayout(localItem: LocalFile, click: () -> Unit) {
    var expanded by remember {
        mutableStateOf(false)
    }

    var showMenu by remember {
        mutableStateOf(false)
    }

    Card(
        modifier = Modifier
            .fillMaxSize()
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
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1F)
                ) {
                    Spacer(modifier = Modifier.width(padding))
                    Icon(painter = checkIcon(localItem = localItem), contentDescription = "")
                    Spacer(modifier = Modifier.width(padding))
                    Column {
                        MinInfo(localItem = localItem)
                        SlideTextContent(expanded = expanded) {
                            if (it) MoreInfo(localItem = localItem) else SmallInfo(
                                smallPadding = smallPadding,
                                localItem = localItem
                            )
                        }
                    }
                }
                Row(
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = End,
                    modifier = Modifier
                        .weight(1F)
                        .fillMaxWidth()
                        .fillMaxHeight()
                ) {
                    RotatedArrowButton(
                        expanded = expanded,
                        modifier = Modifier
                            .fillMaxHeight()
                    ) {
                        expanded = !expanded
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
private fun MoreActions(
    actions: List<MenuItem> = listOf(),
    showMenu: Boolean = false,
) {
    var expanded = showMenu
    DropdownMenu(expanded = expanded, onDismissRequest = {
        expanded = !expanded
    }) {
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
private fun checkIcon(localItem: LocalFile): Painter {
    if (localItem.isDirectory) {
        return loadPainter(id = R.drawable.ic_folder_24)
    }
    return loadPainter(id = R.drawable.ic_file_24)
}