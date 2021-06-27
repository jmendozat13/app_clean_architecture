package com.afoxplus.data.source.network.music.response

import com.google.gson.annotations.SerializedName

data class TunesResponse(
    @SerializedName("resultCount") val resultCount: Int? = null,
    @SerializedName("results") val results: List<TrackResponse>? = null
)