package com.afoxplus.data.source.local.database.music

import androidx.paging.PagingSource
import com.afoxplus.data.source.local.database.music.dao.TrackDao
import com.afoxplus.data.source.local.database.music.model.TrackModel
import com.afoxplus.domain.entities.music.Track
import javax.inject.Inject

class TrackLocalDataSource @Inject constructor(private val trackDao: TrackDao) :
    ITrackLocalDataSource {

    override suspend fun insertAll(tracks: List<Track>) {
        trackDao.insertAll(TrackModel.toTrackModelList(tracks))
    }

    override fun tracksByName(query: String): PagingSource<Int, TrackModel> =
        trackDao.tracksByName(query)

    override suspend fun clearTracks() {
        trackDao.clearTracks()
    }
}