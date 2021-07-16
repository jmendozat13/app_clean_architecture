package com.afoxplus.domain.repository.account

import com.afoxplus.domain.repository.BaseRepository


interface IUserRepository: BaseRepository {
    suspend fun saveUserByName(username: String)
}