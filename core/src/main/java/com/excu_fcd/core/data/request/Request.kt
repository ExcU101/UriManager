package com.excu_fcd.core.data.request

import com.excu_fcd.core.data.Item
import com.excu_fcd.core.data.request.Request.Operation.Companion.EMPTY_TAG
import com.excu_fcd.core.dsl.RequestBuilderMarker
import com.excu_fcd.core.observer.Observer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Default
import kotlinx.coroutines.launch

abstract class Request<F, T>(
    private val list: List<F> = listOf(),
    private val operation: Operation<T>,
    private val observers: MutableList<Observer<Request<F, T>>> = mutableListOf(),
) {

    init {
        notifyOnInitedObservers()
    }

    private var status: Status = Status.WAITING
    private var progress = 0

    //While running, will notify observers
    internal fun notifyObservers() {
        observers.forEach {
            it.onSubscription(item = this)
        }
    }

    private fun notifyOnInitedObservers() {
        observers.forEach {
            it.onSubscribed(item = this)
        }
    }

    internal fun setStatus(status: Status) {
        this.status = status
    }

    fun getStatus() = status

    internal fun updateProgress(progress: Int) {
        if (getProgress() + progress > list.size) {
            this.progress = list.size
        } else {
            this.progress = getProgress() + progress
        }
    }

    fun getProgress() = progress

    private val metaDates = mutableListOf<T>()

    abstract fun getName(): String

    fun getItems(): List<F> = list

    fun getMetas(): List<T> = operation.getMetas()

    fun getOperation() = operation

    enum class Status {
        FAILURE,
        SUCCESS,
        RUNNING,
        WAITING
    }

    @RequestBuilderMarker
    class Builder<F : Item, T> {
        private val items = mutableListOf<F>()
        private val dates = mutableListOf<T>()
        private var mStorageType = Operation.StorageType.LOCAL
        private var observers = mutableListOf<Observer<Request<F, T>>>()
        private var mName: String = "Empty name"
        private var mOperationName: String = "Empty operation name"
        private val mRequest: Request<F, T>? = null
        private var mOperationTag = EMPTY_TAG

        //Request
        fun requestName(requestName: String = "Empty request name") {
            mName = requestName
        }

        fun observers(block: MutableList<Observer<Request<F, T>>>.() -> Unit) {
            observers.addAll(mutableListOf<Observer<Request<F, T>>>().apply(block))
        }

        fun items(block: MutableList<F>.() -> Unit) {
            items.addAll(mutableListOf<F>().apply(block))
        }

        //Operation
        fun operationName(operationName: String = "Empty operation name") {
            mOperationName = operationName
        }

        fun operationTag(operationTag: String) {
            mOperationTag = operationTag
        }

        fun storageType(storageType: Operation.StorageType = Operation.StorageType.LOCAL) {
            mStorageType = storageType
        }

        fun metaDates(block: MutableList<T>.() -> Unit) {
            CoroutineScope(Default).launch {
                dates.addAll(mutableListOf<T>().apply(block))
            }
        }

        //Build
        fun buildOperation() = object : Operation<T>(tag = mOperationTag, type = mStorageType) {
            override fun getName(): String {
                return mOperationName
            }
        }

        fun buildRequest(
            operation: Operation<T>,
        ) = object : Request<F, T>(list = items, operation = operation, observers = observers) {
            override fun getName(): String {
                return mName
            }
        }

        fun build() = buildRequest(operation = buildOperation())

        fun singleton(): Request<F, T> {
            return mRequest ?: build()
        }

    }

    abstract class Operation<T>(
        private val tag: String = EMPTY_TAG,
        private val type: StorageType,
    ) {

        companion object {
            const val EMPTY_TAG = "EMPTY_TAG"

            val EMPTY = object : Operation<Any>(type = StorageType.LOCAL) {
                override fun getName(): String {
                    return "EMPTY OPERATION"
                }

            }
        }

        abstract fun getName(): String

        fun getTag() = tag

        private val metaDates = mutableListOf<T>()

        fun getMetas(): List<T> = metaDates

        enum class StorageType {
            LOCAL,
            REMOTE
        }

    }

}