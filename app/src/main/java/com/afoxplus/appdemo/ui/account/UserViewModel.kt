package com.afoxplus.appdemo.ui.account

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.afoxplus.appdemo.ui.BaseViewModel
import com.afoxplus.domain.entities.account.User
import com.afoxplus.domain.usecases.account.UserUseCase
import kotlinx.coroutines.launch
import org.koin.core.inject

class UserViewModel: BaseViewModel() {

    private val userUseCase: UserUseCase by inject()

    private val mUser: MutableLiveData<User> by lazy { MutableLiveData<User>() }
    val user: LiveData<User> get() = mUser

    fun getUser() = viewModelScope.launch {
        val user = userUseCase.getUser()
        mUser.postValue(user)
    }

    fun saveUserByName(name: String) = viewModelScope.launch {
        userUseCase.saveUserByName(name)
    }
}