package com.afoxplus.data.source.local.database.account

import com.afoxplus.data.source.local.core.LocalBaseDataSource

interface IUserLocalDataSource: LocalBaseDataSource {
    suspend fun saveUserByName(name: String)
}