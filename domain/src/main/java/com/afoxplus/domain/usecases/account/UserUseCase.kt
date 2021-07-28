package com.afoxplus.domain.usecases.account

import com.afoxplus.domain.entities.account.User
import com.afoxplus.domain.repository.account.IUserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserUseCase @Inject constructor(private val userRepository: IUserRepository) {

    suspend fun saveUserByName(username: String) = withContext(Dispatchers.IO) {
        userRepository.saveUserByName(username)
    }

    suspend fun getUser(): User? = withContext(Dispatchers.IO) {
        userRepository.getUser()
    }
}