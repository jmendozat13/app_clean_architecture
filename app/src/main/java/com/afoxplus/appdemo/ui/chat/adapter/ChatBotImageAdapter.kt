package com.afoxplus.appdemo.ui.chat.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.afoxplus.appdemo.R
import com.afoxplus.appdemo.databinding.RowChatImageBinding
import com.afoxplus.domain.entities.chat.ImageMessage
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ChatBotImageAdapter :
    ListAdapter<ImageMessage, ChatBotImageAdapter.ViewHolder>(ChatBotImageDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder.from(parent)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(getItem(position))

    class ViewHolder private constructor(
        private val binding: RowChatImageBinding,
        private val context: Context
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ImageMessage) {
            val options: RequestOptions = RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.ic_placeholder)
                .error(R.drawable.ic_placeholder)
            Glide.with(context).load(item.image).apply(options).into(binding.image)
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RowChatImageBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding, parent.context)
            }
        }
    }
}

class ChatBotImageDiffCallback : DiffUtil.ItemCallback<ImageMessage>() {
    override fun areItemsTheSame(oldItem: ImageMessage, newItem: ImageMessage): Boolean =
        oldItem.image == newItem.image

    override fun areContentsTheSame(oldItem: ImageMessage, newItem: ImageMessage): Boolean =
        oldItem.image == newItem.image
}