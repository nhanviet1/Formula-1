package com.example.formula1.data.model.driversearchitem

import com.google.gson.annotations.SerializedName

data class Response(
    val abbr: String?,
    val birthdate: String?,
    val birthplace: String?,
    @SerializedName("career_points")
    val careerPoints: String?,
    val country: Country?,
    @SerializedName("grands_prix_entered")
    val grandsPrixEntered: Int?,
    @SerializedName("highest_grid_position")
    val highestGridPosition: Int?,
    @SerializedName("highest_race_finish")
    val highestRaceFinish: HighestRaceFinish?,
    val id: Int?,
    val image: String?,
    val name: String?,
    val nationality: String?,
    val number: Int?,
    val podiums: Int?,
    val teams: List<Team>?,
    @SerializedName("world_championships")
    val worldChampionships: Int?
)
