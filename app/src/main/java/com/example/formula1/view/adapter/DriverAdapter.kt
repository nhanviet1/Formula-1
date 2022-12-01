package com.example.formula1.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.formula1.data.model.driverstanding.Response
import com.example.formula1.databinding.ItemDriverStandingBinding
import com.example.formula1.utils.NONE
import com.example.formula1.utils.base.BaseAdapter
import com.example.formula1.utils.base.BaseViewHolder
import com.example.formula1.utils.loadCoverImage

class DriverAdapter(private val onclickItem: (Response) -> Unit) :
    BaseAdapter<Response, ItemDriverStandingBinding, DriverAdapter.DriverViewHolder>(
        Response.diffUtil
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DriverViewHolder {
        val binding =
            ItemDriverStandingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DriverViewHolder(binding, onclickItem)
    }

    class DriverViewHolder(
        private val itemBinding: ItemDriverStandingBinding, onclickItem: (Response) -> Unit
    ) : BaseViewHolder<Response, ItemDriverStandingBinding>(itemBinding, onclickItem) {
        override fun onBindData(data: Response) {
            super.onBindData(data)
            itemBinding.textPosition.text = data.position.toString()
            itemBinding.textDriverName.text = data.driver?.name
            if (data.points.isNullOrEmpty()) {
                itemBinding.textScore.text = NONE.toString()
            } else {
                itemBinding.textScore.text = data.points
            }
            itemBinding.textTeamName.text = data.team?.name
            val context = itemBinding.root.context
            context.loadCoverImage(data.driver?.image as String, itemBinding.imgDriver)
        }
    }
}
