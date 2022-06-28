package com.afoxplus.domain.usecases.account

import com.afoxplus.domain.entities.account.User
import com.afoxplus.domain.repository.account.IUserRepository
import com.afoxplus.domain.usecases.BaseUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.inject

class UserUseCase(private val dispatcher: CoroutineDispatcher = Dispatchers.IO) : BaseUseCase() {

    private val userRepository: IUserRepository by inject()

    suspend fun saveUserByName(username: String) = withContext(dispatcher) {
        val user = userRepository.saveNetworkUser(User(name = username))
        userRepository.saveLocalUser(user)
    }

    suspend fun getUser(): User? = withContext(dispatcher) {
        userRepository.getUser()
    }
}