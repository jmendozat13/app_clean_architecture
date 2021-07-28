package com.afoxplus.data.source.local.database.music

import androidx.paging.PagingSource
import com.afoxplus.data.source.local.database.music.model.TrackModel
import com.afoxplus.domain.entities.music.Track

interface ITrackLocalDataSource  {

    suspend fun insertAll(tracks: List<Track>)
    fun tracksByName(query: String): PagingSource<Int, TrackModel>
    suspend fun clearTracks()
}