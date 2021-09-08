package com.excu_fcd.efm.ui.recylcer.adapter

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.excu_fcd.core.data.Item
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class Differ<T : Item> {

    private var result: DiffUtil.DiffResult? = null

    fun <VH: RecyclerView.ViewHolder> dispatch(adapter: RecyclerView.Adapter<VH>) {
        result?.dispatchUpdatesTo(adapter)
    }

    suspend fun calcResult(
        oldList: List<T>,
        newList: List<T>,
        coroutineContext: CoroutineContext = IO
    ) = withContext(context = coroutineContext) {
        val differ = object : DiffUtil.Callback() {

            override fun getNewListSize(): Int = newList.size

            override fun getOldListSize(): Int = oldList.size

            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return oldList[oldItemPosition].getId() == newList[newItemPosition].getId()
            }

            override fun areContentsTheSame(
                oldItemPosition: Int,
                newItemPosition: Int
            ): Boolean {
                return oldList[oldItemPosition].getName() == newList[newItemPosition].getName()
            }
        }

        return@withContext DiffUtil.calculateDiff(differ).also {
            result = it
        }
    }

}