package com.afoxplus.domain.repository.account

import com.afoxplus.domain.entities.account.User
import com.afoxplus.domain.repository.BaseRepository


interface IUserRepository : BaseRepository {
    suspend fun saveNetworkUser(user: User): User
    suspend fun saveLocalUser(user: User)
    suspend fun getUser(): User?
}