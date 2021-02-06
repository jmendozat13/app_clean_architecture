package com.afoxplus.data.source.local.database.config

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.afoxplus.data.source.local.database.dao.MessageDao
import com.afoxplus.data.source.local.database.model.MessageModel


@Database(
    entities = [MessageModel::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(TypeConverts::class)
abstract class AppDemoDataBase : RoomDatabase() {

    abstract val messageDao: MessageDao

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