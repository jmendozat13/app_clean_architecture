package com.afoxplus.data.source.local.database.config

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.afoxplus.data.source.local.database.dao.HistoryMessageDao
import com.afoxplus.data.source.local.database.model.HistoryMessageModel
import kotlinx.coroutines.CoroutineScope


@Database(
    entities = [HistoryMessageModel::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(TypeConverts::class)
abstract class AppDemoDataBase : RoomDatabase() {

    abstract val historyMessageDao: HistoryMessageDao

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