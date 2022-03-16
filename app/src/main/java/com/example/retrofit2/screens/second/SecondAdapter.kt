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
    private var listAd = emptyList<BeznalItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecondViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_money_layout, parent, false)
        return SecondViewHolder(view)
    }

    override fun onBindViewHolder(holder: SecondViewHolder, position: Int) {
        val item = listAd[position]
        holder.setData(item)
    }

    override fun getItemCount(): Int {
        return listAd.size
    }

    class SecondViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemMoneyLayoutBinding.bind(itemView)

        fun setData(item: BeznalItem) {
            binding.itemTvName.text = item.ccy
            binding.itemTvBuy.text = item.buy
            binding.itemTvSale.text = item.sale
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateAdapter(newList: List<BeznalItem>) {

        listAd = newList
        notifyDataSetChanged()
    }
}