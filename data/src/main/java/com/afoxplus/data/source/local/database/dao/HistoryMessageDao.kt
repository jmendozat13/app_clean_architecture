package com.afoxplus.data.source.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.afoxplus.data.source.local.database.model.HistoryMessageModel

@Dao
interface HistoryMessageDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(historyMessageModel: HistoryMessageModel)
}