package com.example.formula1.data.model.circuitsearchitem

import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName

data class Response(
    val capacity: Int?,
    @SerializedName("first_grand_prix")
    val firstGrandPrix: Int?,
    val id: Int?,
    val image: String?,
    @SerializedName("lap_record")
    val lapRecord: LapRecord?,
    val competition: Competition,
    val laps: Int?,
    val length: String?,
    val name: String?,
    val opened: Int?,
    @SerializedName("race_distance")
    val raceDistance: String?
) {
    companion object {

        val diffUtil = object : DiffUtil.ItemCallback<Response>() {
            override fun areItemsTheSame(oldItem: Response, newItem: Response) = false

            override fun areContentsTheSame(oldItem: Response, newItem: Response) =
                oldItem == newItem
        }
    }
}
