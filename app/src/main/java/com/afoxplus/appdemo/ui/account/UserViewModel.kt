package com.afoxplus.appdemo.ui.account

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.afoxplus.appdemo.core.Event
import com.afoxplus.appdemo.ui.BaseViewModel
import com.afoxplus.domain.entities.account.User
import com.afoxplus.domain.usecases.account.UserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.inject

class UserViewModel : BaseViewModel() {

    private val userUseCase: UserUseCase by inject()

    private val mUser: MutableLiveData<User> by lazy { MutableLiveData<User>() }
    val user: LiveData<User> get() = mUser

    private val mOnUserCreateSuccess: MutableLiveData<Event<User>> by lazy { MutableLiveData<Event<User>>() }
    val onUserCreateSuccess: LiveData<Event<User>> get() = mOnUserCreateSuccess

    fun getUser() = viewModelScope.launch {
        val user = userUseCase.getUser()
        mUser.postValue(user)
    }

    fun saveUserByName(name: String) = viewModelScope.launch(Dispatchers.Main) {
        userUseCase.saveUserByName(name)
        userUseCase.getUser()?.let { user ->
            mOnUserCreateSuccess.value = Event(user)
        }

    }
}