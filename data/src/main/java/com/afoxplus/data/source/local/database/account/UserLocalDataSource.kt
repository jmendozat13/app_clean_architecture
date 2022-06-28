package com.afoxplus.data.source.local.database.account

import com.afoxplus.data.source.local.database.account.dao.UserDao
import com.afoxplus.data.source.local.database.account.model.UserModel
import com.afoxplus.domain.entities.account.User
import org.koin.core.inject

class UserLocalDataSource : IUserLocalDataSource {
    private val userDao: UserDao by inject()


    override suspend fun saveUser(user: User) {
        userDao.insertUser(UserModel(user.name, user.userExternalId))
    }

    override suspend fun getUser(): User? {
        return userDao.getUser()?.toUser()
    }
}