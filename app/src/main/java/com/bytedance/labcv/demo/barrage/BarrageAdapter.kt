package com.bytedance.labcv.demo.barrage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bytedance.labcv.demo.data.Barrage
import com.bytedance.labcv.demo.databinding.ListItemBarrageMsgBinding

class BarrageAdapter : ListAdapter<Barrage, RecyclerView.ViewHolder>(BarrageDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val binding = ListItemBarrageMsgBinding.inflate(inflater, parent, false)
        return BarrageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val barrage = getItem(position)
        (holder as BarrageViewHolder).bind(barrage)
    }

    class BarrageViewHolder(binding: ListItemBarrageMsgBinding) : RecyclerView.ViewHolder(binding.root) {
        var tvMsg = binding.tvMsgContent
        fun bind(barrage: Barrage){
            tvMsg.text = barrage.msg
        }
    }

}

private class BarrageDiffCallback : DiffUtil.ItemCallback<Barrage>() {

    override fun areItemsTheSame(oldItem: Barrage, newItem: Barrage): Boolean {
        return oldItem.msg == newItem.msg
    }

    override fun areContentsTheSame(oldItem: Barrage, newItem: Barrage): Boolean {
        return oldItem == newItem
    }
}