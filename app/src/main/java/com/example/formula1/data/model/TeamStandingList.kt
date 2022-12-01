package com.example.formula1.data.model

import com.example.formula1.data.model.teamstanding.Parameters
import com.example.formula1.data.model.teamstanding.Response

data class TeamStandingList(
    val get: String?,
    val parameters: Parameters?,
    val response: List<Response>?,
    val results: Int?
)
