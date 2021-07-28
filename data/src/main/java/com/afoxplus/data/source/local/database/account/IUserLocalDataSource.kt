package com.afoxplus.data.source.local.database.account

import com.afoxplus.domain.entities.account.User

interface IUserLocalDataSource {
    suspend fun saveUserByName(name: String)
    suspend fun getUser(): User?
}