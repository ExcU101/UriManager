package com.excu_fcd.efm.ui.recylcer.adapter

import androidx.recyclerview.widget.RecyclerView
import com.excu_fcd.core.data.Item
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

abstract class BicycleAdapter<T : Item, VH : RecyclerView.ViewHolder> :
    RecyclerView.Adapter<VH>() {

    private val list = mutableListOf<T>()

    private val differ: Differ<T> = Differ<T>()

    fun getItem(position: Int): T = list[position]

    internal fun addItem(item: T) {
        list.add(item)
    }

    fun addNewData(collection: Collection<T>) {

    }

    fun replaceData(collection: Collection<T>) {
        calcDiff(list, collection.toList())
        list.clear()
        list.addAll(collection)
        dispatch()
    }

    internal fun replaceData(array: Array<T>) {
        calcDiff(list, array.toList())
        list.clear()
        list.addAll(array)
        dispatch()
    }

    private fun dispatch() {
        differ.dispatch(this)
    }

    private fun calcDiff(oldList: List<T>, newList: List<T>) {
        CoroutineScope(IO).launch {
            differ.calcResult(oldList = oldList, newList = newList)
        }
    }

}