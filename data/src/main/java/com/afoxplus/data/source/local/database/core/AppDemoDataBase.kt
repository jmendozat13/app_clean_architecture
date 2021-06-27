package com.afoxplus.data.source.local.database.core

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.afoxplus.data.source.local.database.chat.dao.MessageDao
import com.afoxplus.data.source.local.database.music.dao.TrackDao
import com.afoxplus.data.source.local.database.chat.model.MessageModel
import com.afoxplus.data.source.local.database.music.model.TrackModel


@Database(
    entities = [MessageModel::class, TrackModel::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(TypeConverts::class)
abstract class AppDemoDataBase : RoomDatabase() {

    abstract val messageDao: MessageDao
    abstract val trackDao: TrackDao

    companion object {
        fun getDatabase(
            context: Context,
            databaseName: String
        ): AppDemoDataBase = synchronized(this) {
            Room.databaseBuilder(
                context.applicationContext,
                AppDemoDataBase::class.java,
                databaseName
            )
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}