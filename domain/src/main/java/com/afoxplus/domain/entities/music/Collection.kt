package com.afoxplus.domain.entities.music

data class Collection(
    val id: Int,
    val name: String,
    val censoredName: String,
    val viewUrl: String,
    val price: Double,
    val explicitness: String,
    val artist: Artist,
    val tracks: List<Track> = emptyList()
)
