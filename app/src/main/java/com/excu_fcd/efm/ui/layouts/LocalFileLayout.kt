package com.excu_fcd.efm.ui.layouts

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.End
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.RoundedCornersTransformation
import com.excu_fcd.core.data.local.LocalFile
import com.excu_fcd.efm.R
import com.excu_fcd.efm.ui.SlideTextContent
import com.excu_fcd.efm.utils.loadPainter

private val padding = 16.dp
private val smallPadding = 8.dp


@OptIn(ExperimentalAnimationApi::class, ExperimentalMaterialApi::class,
    coil.annotation.ExperimentalCoilApi::class)
@Composable
fun ItemLayout(localFile: LocalFile, click: () -> Unit) {
    val actionList = listOf(
        MenuItem(icon = rememberImagePainter(data = R.drawable.ic_delete_24),
            actionName = "Delete"),
        MenuItem(icon = rememberImagePainter(data = R.drawable.ic_edit_24), actionName = "Rename"),
        MenuItem(icon = rememberImagePainter(data = R.drawable.ic_copy_24), actionName = "Copy"),
        MenuItem(icon = rememberImagePainter(data = R.drawable.ic_paste_24), actionName = "Paste"),
    )

    var expanded by remember {
        mutableStateOf(false)
    }

    var showMenu by remember {
        mutableStateOf(false)
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .animateContentSize(),
        shape = RoundedCornerShape(0),
        onClick = click
    ) {
        Column(
            modifier = Modifier
                .padding(top = smallPadding, bottom = smallPadding),
        ) {
            Row {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(2F)
                ) {
                    Spacer(modifier = Modifier.width(padding))
                    Icon(painter = checkIcon(localItem = localFile), contentDescription = "", tint = Color.Black)
                    Spacer(modifier = Modifier.width(padding))
                    Column {
                        SlideTextContent(expanded = expanded) {
                            if (it) MoreInfo(localFile = localFile) else SmallInfo(
                                smallPadding = smallPadding,
                                localFile = localFile
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
                        showMenu = true
                    }, modifier = Modifier.fillMaxHeight()) {
                        Icon(imageVector = Icons.Outlined.MoreVert,
                            contentDescription = "",
                            tint = Color.Black)
                        DropdownMenu(
                            expanded = showMenu,
                            onDismissRequest = { showMenu = false },
                            modifier = Modifier.requiredWidth(240.dp)) {
                            actionList.forEach {
                                MenuItemLayout(item = it, smallPadding = smallPadding) {
                                    showMenu = false
                                }
                            }

                        }
                    }
                }
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