package com.afoxplus.appdemo.ui.chat.viewholder

import android.text.util.Linkify
import android.view.LayoutInflater
import android.view.ViewGroup
import com.afoxplus.appdemo.databinding.RowChatResponseBinding
import com.afoxplus.appdemo.ui.chat.adapter.ChatBotImageAdapter
import com.afoxplus.appdemo.ui.chat.adapter.ChatBotOptionAdapter
import com.afoxplus.appdemo.ui.chat.adapter.OnClickMessageListener
import com.afoxplus.domain.entities.account.User
import com.afoxplus.domain.entities.chat.Message
import me.saket.bettermovementmethod.BetterLinkMovementMethod

class ChatResponseViewHolder private constructor(
    private val bindingResponse: RowChatResponseBinding,
    private val onClickMessage: OnClickMessageListener,
    private val user: User
) : ChatViewHolder(bindingResponse.root) {

    private val adapterOptions: ChatBotOptionAdapter by lazy { ChatBotOptionAdapter() }
    private val adapterImages: ChatBotImageAdapter by lazy { ChatBotImageAdapter() }

    override fun bind(message: Message) {
        message.replaceUserName(user)
        bindingResponse.message = message
        Linkify.addLinks(
            bindingResponse.responseTextMessage,
            Linkify.PHONE_NUMBERS or Linkify.WEB_URLS
        )
        bindingResponse.responseTextMessage.movementMethod = BetterLinkMovementMethod.getInstance()
        bindingResponse.adapterOption = adapterOptions
        bindingResponse.adapterImage = adapterImages
        adapterOptions.setOnClickOptionListener { option ->
            onClickMessage.onClick(option)
        }
        adapterOptions.submitList(message.options)
        adapterImages.submitList(message.images)
        bindingResponse.executePendingBindings()
    }

    companion object {
        fun from(
            parent: ViewGroup,
            onClickMessage: OnClickMessageListener,
            user: User
        ): ChatResponseViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = RowChatResponseBinding.inflate(layoutInflater, parent, false)
            return ChatResponseViewHolder(binding, onClickMessage, user)
        }
    }
}

