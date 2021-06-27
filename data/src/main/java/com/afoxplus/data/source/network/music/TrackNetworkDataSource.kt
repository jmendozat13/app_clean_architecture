package com.afoxplus.data.source.network.music

import com.afoxplus.domain.entities.music.Track

class TrackNetworkDataSource : ITrackNetworkDataSource {
    override suspend fun search(
        query: String,
        mediaType: String,
        page: Int,
        itemsPerPage: Int
    ): List<Track> {
        TODO("Not yet implemented")
    }
}