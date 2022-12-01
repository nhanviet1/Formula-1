package com.example.formula1.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.formula1.data.model.teamstanding.Response
import com.example.formula1.databinding.ItemTeamStandingBinding
import com.example.formula1.utils.NONE
import com.example.formula1.utils.base.BaseAdapter
import com.example.formula1.utils.base.BaseViewHolder
import com.example.formula1.utils.loadCoverImage

class TeamAdapter(private val onclickItem: (Response) -> Unit) :
    BaseAdapter<Response, ItemTeamStandingBinding, TeamAdapter.TeamViewHolder>(
        Response.diffUtil
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val binding =
            ItemTeamStandingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TeamViewHolder(binding, onclickItem)
    }

    class TeamViewHolder(
        private val itemBinding: ItemTeamStandingBinding, onclickItem: (Response) -> Unit
    ) : BaseViewHolder<Response, ItemTeamStandingBinding>(itemBinding, onclickItem) {
        override fun onBindData(data: Response) {
            super.onBindData(data)
            itemBinding.textPosition.text = data.position.toString()
            itemBinding.textTeamName.text = data.team?.name
            if (data.points.isNullOrEmpty()) {
                itemBinding.textScore.text = NONE.toString()
            } else {
                itemBinding.textScore.text = data.points
            }
            itemBinding.textTeamName.text = data.team?.name
            val context = itemBinding.root.context
            context.loadCoverImage(data.team?.logo as String, itemBinding.imgLogo)
        }
    }
}
