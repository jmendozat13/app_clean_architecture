package com.afoxplus.appdemo.ui.chat

import android.view.View
import com.afoxplus.appdemo.databinding.FragmentChatBinding
import com.afoxplus.appdemo.ui.BaseFragment
import com.afoxplus.appdemo.ui.chat.adapter.ChatBotAdapter
import com.afoxplus.domain.entities.chat.OptionMessage
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class ChatFragment : BaseFragment() {
    private lateinit var bindingChat: FragmentChatBinding
    private val viewModel: ChatBotViewModel by sharedViewModel()

    private val adapter: ChatBotAdapter by lazy { ChatBotAdapter() }

    override fun getMainView(): View {
        bindingChat = FragmentChatBinding.inflate(layoutInflater)
        bindingChat.lifecycleOwner = viewLifecycleOwner
        bindingChat.adapter = adapter
        bindingChat.viewModel = viewModel
        return bindingChat.root
    }

    override fun setUpView() {
        adapter.setOnClickMessageListener(::onClickMessage)
    }

    override fun viewModelObserver() {
        viewModel.allMessages.observe(this) {
            adapter.submitList(it)
            bindingChat.recycler.scrollToPosition(it.size - 1)
        }
    }

    private fun onClickMessage(option: OptionMessage) {
        viewModel.sendOption(option)
    }

}