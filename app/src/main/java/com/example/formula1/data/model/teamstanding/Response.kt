package com.example.formula1.data.model.teamstanding

import androidx.recyclerview.widget.DiffUtil
import com.example.formula1.data.model.driverstanding.Team


data class Response(
    val points: String?,
    val position: Int?,
    val season: Int?,
    val team: Team?
) {
    companion object {

        val diffUtil = object : DiffUtil.ItemCallback<Response>() {
            override fun areItemsTheSame(oldItem: Response, newItem: Response) =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: Response, newItem: Response) =
                oldItem == newItem
        }
    }
}
