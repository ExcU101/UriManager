package com.excu_fcd.efm.ui.layouts

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MenuItemLayout(item: MenuItem, smallPadding: Dp, onClick: () -> Unit) {
    DropdownMenuItem(onClick = onClick) {
        Icon(painter = item.icon, contentDescription = item.actionName)
        Spacer(modifier = Modifier.width(smallPadding))
        Text(text = item.actionName)
    }
}