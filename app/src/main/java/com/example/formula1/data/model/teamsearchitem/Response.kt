package com.example.formula1.data.model.teamsearchitem

import com.google.gson.annotations.SerializedName

data class Response(
    val base: String?,
    val chassis: String?,
    val director: String?,
    val engine: String?,
    @SerializedName("fastest_laps")
    val fastestLaps: Int?,
    @SerializedName("first_team_entry")
    val firstTeamEntry: Int?,
    @SerializedName("highest_race_finish")
    val highestRaceFinish: HighestRaceFinish?,
    val id: Int?,
    val logo: String?,
    val name: String?,
    @SerializedName("pole_positions")
    val polePositions: Int?,
    val president: String?,
    @SerializedName("technical_manager")
    val technicalManager: String?,
    val tyres: String?,
    @SerializedName("world_championships")
    val worldChampionships: Int?
)
