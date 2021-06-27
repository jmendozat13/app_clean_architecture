package com.afoxplus.data.source.local.database.chat.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.afoxplus.data.source.local.database.chat.model.MessageModel
import kotlinx.coroutines.flow.Flow

@Dao
interface MessageDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg messageModel: MessageModel)

    @Query("SELECT *FROM MessageModel ORDER BY dateTime ASC")
    fun historyMessages(): Flow<List<MessageModel>>

    @Query("DELETE FROM MessageModel WHERE type=:type")
    fun deleteMessage(type: String)
}