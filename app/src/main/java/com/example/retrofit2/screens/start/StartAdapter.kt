package com.example.retrofit2.screens.start

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit2.R
import com.example.retrofit2.databinding.ItemMoneyLayoutBinding
import com.example.retrofit2.model.nal.NalItem

class StartAdapter : RecyclerView.Adapter<StartAdapter.StartViewHolder>() {
    var adList = emptyList<NalItem>()

    class StartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemMoneyLayoutBinding.bind(itemView)
        fun setData(itemData: NalItem) {
            binding.itemTvName.text = itemData.ccy
            binding.itemTvBuy.text = itemData.buy
            binding.itemTvSale.text = itemData.sale

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_money_layout, parent, false)
        return StartViewHolder(view)
    }

    override fun onBindViewHolder(holder: StartViewHolder, position: Int) {
        val itemData = adList[position]
        holder.setData(itemData)
    }

    override fun getItemCount(): Int {
        return adList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateAdapter(newlist: List<NalItem>) {
        adList = newlist
        notifyDataSetChanged()

    }

}