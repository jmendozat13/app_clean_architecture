package com.afoxplus.data.source.local.database.account

import com.afoxplus.data.source.local.database.account.dao.UserDao
import com.afoxplus.data.source.local.database.account.model.UserModel
import com.afoxplus.domain.entities.account.User
import javax.inject.Inject

class UserLocalDataSource @Inject constructor(private val userDao: UserDao) : IUserLocalDataSource {

    override suspend fun saveUserByName(name: String) {
        userDao.insertUser(UserModel(name))
    }

    override suspend fun getUser(): User? {
        return userDao.getUser()?.toUser()
    }
}