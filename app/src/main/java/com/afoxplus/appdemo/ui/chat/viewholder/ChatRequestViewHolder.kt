package com.afoxplus.appdemo.ui.chat.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import com.afoxplus.appdemo.databinding.RowChatRequestBinding
import com.afoxplus.domain.entities.chat.Message

class ChatRequestViewHolder private constructor(private val bindingRequest: RowChatRequestBinding) :
    ChatViewHolder(bindingRequest.root) {

    override fun bind(message: Message) {
        bindingRequest.message = message
        bindingRequest.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): ChatRequestViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = RowChatRequestBinding.inflate(layoutInflater, parent, false)
            return ChatRequestViewHolder(binding)
        }
    }

}