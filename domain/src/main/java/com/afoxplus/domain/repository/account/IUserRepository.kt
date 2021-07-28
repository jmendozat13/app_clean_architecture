package com.afoxplus.domain.repository.account

import com.afoxplus.domain.entities.account.User


interface IUserRepository {
    suspend fun saveUserByName(username: String)
    suspend fun getUser(): User?
}