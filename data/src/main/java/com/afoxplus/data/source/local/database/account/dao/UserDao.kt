package com.afoxplus.data.source.local.database.account.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.afoxplus.data.source.local.database.account.model.UserModel

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserModel)

    @Query("SELECT *FROM user LIMIT 1")
    fun getUser(): UserModel
}