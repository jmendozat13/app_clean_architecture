package com.afoxplus.data.source.local.database.account

import com.afoxplus.data.source.local.core.LocalBaseDataSource
import com.afoxplus.domain.entities.account.User

interface IUserLocalDataSource: LocalBaseDataSource {
    suspend fun saveUserByName(name: String)
    suspend fun getUser(): User?
}