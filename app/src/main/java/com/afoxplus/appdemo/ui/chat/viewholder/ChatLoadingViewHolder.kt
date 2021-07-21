package com.afoxplus.appdemo.ui.chat.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import com.afoxplus.appdemo.databinding.RowChatLoadingBinding
import com.afoxplus.domain.entities.chat.Message

class ChatLoadingViewHolder private constructor(bindingLoading: RowChatLoadingBinding) :
    ChatViewHolder(bindingLoading.root) {

    override fun bind(message: Message) {
        //Do nothing
    }

    companion object {
        fun from(parent: ViewGroup): ChatLoadingViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = RowChatLoadingBinding.inflate(layoutInflater, parent, false)
            return ChatLoadingViewHolder(binding)
        }
    }

}