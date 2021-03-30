package com.afoxplus.domain.entities.music

import java.util.*

data class Track(
    val id: Long,
    val name: String,
    val wrapperType: String,
    val kind: String,
    val censoredName: String,
    val viewUrl: String,
    val artworkUrl30: String,
    val artworkUrl60: String,
    val artworkUrl100: String,
    val price: Double,
    val releaseDate: Date,
    val count: Int,
    val number: Int,
    val timeMillis: Int,
    val primaryGenreName: String,
    val artist: Artist? = null,
    val collection: Collection? = null
)
