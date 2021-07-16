package com.afoxplus.data.repository.account

import com.afoxplus.data.source.local.database.account.IUserLocalDataSource
import com.afoxplus.domain.repository.account.IUserRepository
import org.koin.core.inject

class UserRepository: IUserRepository {

    private val userLocalDataSource: IUserLocalDataSource by inject()

    override suspend fun saveUserByName(username: String) = userLocalDataSource.saveUserByName(username)
}