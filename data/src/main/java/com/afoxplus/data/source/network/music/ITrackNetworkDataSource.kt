package com.afoxplus.data.source.network.music

import com.afoxplus.domain.entities.music.Track

interface ITrackNetworkDataSource {
    suspend fun search(query: String, mediaType: String, page: Int, itemsPerPage: Int): List<Track>
}