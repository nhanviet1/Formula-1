package com.example.formula1.data.model

import com.example.formula1.data.model.teamsearchitem.Parameters
import com.example.formula1.data.model.teamsearchitem.Response

data class TeamSearchResponse(
    val get: String?,
    val parameters: Parameters?,
    val response: List<Response>?,
    val results: Int?
)
