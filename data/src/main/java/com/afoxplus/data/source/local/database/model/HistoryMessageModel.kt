package com.afoxplus.data.source.local.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class HistoryMessageModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val messageType: String,
    val message: String,
    val dateTime: Date
)