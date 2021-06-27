package com.afoxplus.data.source.network.music

import com.afoxplus.data.source.network.core.NetworkBaseDataSource
import com.afoxplus.domain.entities.music.Track

interface ITrackNetworkDataSource : NetworkBaseDataSource {
    suspend fun search(query: String, mediaType: String, page: Int, itemsPerPage: Int): List<Track>
}