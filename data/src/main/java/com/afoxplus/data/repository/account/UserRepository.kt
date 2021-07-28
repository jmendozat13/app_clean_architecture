package com.afoxplus.data.repository.account

import com.afoxplus.data.source.local.database.account.IUserLocalDataSource
import com.afoxplus.domain.entities.account.User
import com.afoxplus.domain.repository.account.IUserRepository
import javax.inject.Inject

class UserRepository @Inject constructor(private val userLocalDataSource: IUserLocalDataSource) :
    IUserRepository {

    override suspend fun saveUserByName(username: String) =
        userLocalDataSource.saveUserByName(username)

    override suspend fun getUser(): User? = userLocalDataSource.getUser()

}