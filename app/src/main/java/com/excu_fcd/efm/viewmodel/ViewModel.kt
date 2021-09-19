package com.excu_fcd.efm.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.excu_fcd.core.data.local.LocalFile
import com.excu_fcd.core.provider.local.LocalProvider
import kotlinx.coroutines.launch

class ViewModel : ViewModel() {

    private val files = mutableStateListOf<LocalFile>()

    private val data = MutableLiveData<SnapshotStateList<LocalFile>>()

    fun getData() = data

    init {
        viewModelScope.launch {
            files.addAll(LocalProvider<String>().provideSdcardList())
            data.value = files
        }
    }

}