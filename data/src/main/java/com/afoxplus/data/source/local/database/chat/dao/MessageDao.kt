package com.afoxplus.data.source.local.database.chat.dao

import androidx.room.*
import com.afoxplus.data.source.local.database.chat.model.MessageModel
import com.afoxplus.data.source.local.database.chat.model.MessageWithOptionsAndImageModel
import kotlinx.coroutines.flow.Flow

@Dao
interface MessageDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg messages: MessageModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOneMessage(message: MessageModel): Long

    @Query("SELECT *FROM messages ORDER BY dateTime ASC")
    fun historyMessages(): Flow<List<MessageModel>>

    @Query("DELETE FROM messages WHERE type=:type")
    fun deleteMessage(type: String)

    @Transaction
    @Query("SELECT *FROM messages ORDER BY dateTime ASC")
    fun readMessage(): Flow<List<MessageWithOptionsAndImageModel>>
}