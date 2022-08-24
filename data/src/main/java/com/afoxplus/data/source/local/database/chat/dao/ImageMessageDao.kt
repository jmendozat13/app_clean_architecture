package com.afoxplus.data.source.local.database.chat.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.afoxplus.data.source.local.database.chat.model.ImageMessageModel

@Dao
interface ImageMessageDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg optionsMessage: ImageMessageModel)
}