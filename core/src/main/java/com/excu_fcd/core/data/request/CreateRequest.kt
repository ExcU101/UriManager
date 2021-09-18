package com.excu_fcd.core.data.request

import com.excu_fcd.core.data.local.LocalFile
import com.excu_fcd.core.dsl.tag

class CreateRequest<T>(
    list: List<LocalFile>,
) : Request<LocalFile, T>(
    list = list,
    operation = object : Request.Operation<T>(tag = tag(0), type = StorageType.LOCAL) {
        override fun getName(): String {
            return "Create"
        }
    }
) {

    override fun getName(): String {
        return "Create request"
    }

}