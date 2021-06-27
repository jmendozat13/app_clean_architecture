package com.afoxplus.data.source.local.database.music.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.afoxplus.data.source.local.database.music.model.TrackModel

@Dao
interface TrackDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(tracks: List<TrackModel>)

    @Query("SELECT * FROM tracks WHERE name = :query ORDER BY indexInResponse ASC")
    fun tracksByName(query: String): PagingSource<Int, TrackModel>

    @Query("DELETE FROM tracks")
    fun clearTracks()
}