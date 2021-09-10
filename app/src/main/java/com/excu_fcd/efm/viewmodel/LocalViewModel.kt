package com.excu_fcd.efm.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.excu_fcd.core.data.local.LocalItem
import com.excu_fcd.core.provider.LocalProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class LocalViewModel constructor(private val localProvider: LocalProvider) : ViewModel() {

    private val data = mutableStateOf(listOf<LocalItem>())

    init {
        viewModelScope.launch {
            data.value = localProvider.provideSdcardList()
        }
    }

    fun getData() = data

}