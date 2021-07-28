package com.afoxplus.appdemo.ui.chat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.afoxplus.appdemo.databinding.FragmentChatUserBinding
import com.afoxplus.appdemo.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChatUserFragment : BaseFragment() {
    private lateinit var bindingChatUser: FragmentChatUserBinding
    private val chatViewModel: ChatBotViewModel by activityViewModels()

    override fun getMainView(inflater: LayoutInflater, container: ViewGroup?): View {
        bindingChatUser = FragmentChatUserBinding.inflate(inflater, container, false)
        bindingChatUser.lifecycleOwner = viewLifecycleOwner
        bindingChatUser.viewModel = chatViewModel
        return bindingChatUser.root
    }

}