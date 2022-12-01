package com.example.formula1.utils.base

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseViewHolder<T, VB : ViewBinding>(
    private val binding: VB, click: (T) -> Unit = { _ -> }
) : RecyclerView.ViewHolder(binding.root) {

    private var itemData: T? = null

    init {
        itemView.setOnClickListener {
            itemData?.let {
                click(it)
            }
        }
    }

    open fun onBindData(data: T) {
        itemData = data
    }
}
