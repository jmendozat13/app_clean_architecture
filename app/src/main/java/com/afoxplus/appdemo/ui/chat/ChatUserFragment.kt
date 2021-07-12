package com.afoxplus.appdemo.ui.chat

import android.view.View
import com.afoxplus.appdemo.databinding.FragmentChatUserBinding
import com.afoxplus.appdemo.ui.BaseFragment
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class ChatUserFragment : BaseFragment() {
    private lateinit var bindingChatUser: FragmentChatUserBinding
    private val chatViewModel: ChatBotViewModel by sharedViewModel()

    override fun getMainView(): View {
        bindingChatUser = FragmentChatUserBinding.inflate(layoutInflater)
        bindingChatUser.lifecycleOwner = viewLifecycleOwner
        bindingChatUser.viewModel = chatViewModel
        return bindingChatUser.root
    }

    override fun setUpView() {
        //Do nothing
    }

    override fun viewModelObserver() {
        //Do nothing
    }

}