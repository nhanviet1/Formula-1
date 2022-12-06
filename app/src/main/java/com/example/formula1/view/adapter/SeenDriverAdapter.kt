package com.example.formula1.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.formula1.data.model.driverstanding.Driver
import com.example.formula1.databinding.ItemDriverStandingBinding
import com.example.formula1.utils.base.BaseAdapter
import com.example.formula1.utils.base.BaseViewHolder
import com.example.formula1.utils.gone
import com.example.formula1.utils.loadCoverImage

class SeenDriverAdapter(private val onclickItem: (Driver) -> Unit) :
    BaseAdapter<Driver, ItemDriverStandingBinding, SeenDriverAdapter.DriverViewHolder>(
        Driver.diffUtil
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DriverViewHolder {
        val binding =
            ItemDriverStandingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DriverViewHolder(binding, onclickItem)
    }

    class DriverViewHolder(
        private val itemBinding: ItemDriverStandingBinding, onclickItem: (Driver) -> Unit
    ) : BaseViewHolder<Driver, ItemDriverStandingBinding>(itemBinding, onclickItem) {
        override fun onBindData(data: Driver) {
            super.onBindData(data)
            itemBinding.textPosition.text = data.number.toString()
            itemBinding.textDriverName.text = data.name
            itemBinding.textScore.gone()
            itemBinding.textTeamName.text = data.nameTag
            val context = itemBinding.root.context
            context.loadCoverImage(data.image.toString(), itemBinding.imgDriver)
        }
    }
}
