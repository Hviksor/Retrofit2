package com.example.retrofit2.screens.second

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit2.R
import com.example.retrofit2.databinding.ItemMoneyLayoutBinding
import com.example.retrofit2.model.beznal.BeznalItem
import com.example.retrofit2.model.nal.NalItem
import com.example.retrofit2.screens.start.StartAdapter

class SecondAdapter : RecyclerView.Adapter<SecondAdapter.SecondViewHolder>() {
    var adList = emptyList<BeznalItem>()

    class SecondViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemMoneyLayoutBinding.bind(itemView)
        fun setData(itemData: BeznalItem) {
            binding.itemTvName.text = itemData.ccy
            binding.itemTvBuy.text = itemData.buy
            binding.itemTvSale.text = itemData.sale

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecondViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_money_layout, parent, false)
        return SecondViewHolder(view)
    }

    override fun onBindViewHolder(holder: SecondViewHolder, position: Int) {
        val itemData = adList[position]
        holder.setData(itemData)
    }

    override fun getItemCount(): Int {
        return adList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateAdapter(newlist: List<BeznalItem>) {
        Log.e("koko", "koko$newlist")
        adList = newlist
        notifyDataSetChanged()

    }

}