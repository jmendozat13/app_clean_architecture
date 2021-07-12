package com.afoxplus.appdemo.ui.chat.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.afoxplus.appdemo.databinding.RowChatOptionBinding
import com.afoxplus.domain.entities.chat.OptionMessage

class ChatBotOptionAdapter :
    ListAdapter<OptionMessage, ChatBotOptionAdapter.ViewHolder>(ChatBotOptionDiffCallback()) {

    private var onClickOptionListener: OnClickOptionListener = OnClickOptionListener {}

    fun setOnClickOptionListener(listener: OnClickOptionListener) {
        onClickOptionListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder.from(parent, onClickOptionListener)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(getItem(position))

    class ViewHolder private constructor(
        private val binding: RowChatOptionBinding,
        private val onClickOption: OnClickOptionListener
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: OptionMessage) {
            binding.optionMessage = item
            binding.onClickOption = onClickOption
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup, onClickOption: OnClickOptionListener): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RowChatOptionBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding, onClickOption)
            }
        }
    }
}

class ChatBotOptionDiffCallback : DiffUtil.ItemCallback<OptionMessage>() {
    override fun areItemsTheSame(oldItem: OptionMessage, newItem: OptionMessage): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: OptionMessage, newItem: OptionMessage): Boolean =
        oldItem == newItem
}

fun interface OnClickOptionListener {
    fun onClick(item: OptionMessage)
}