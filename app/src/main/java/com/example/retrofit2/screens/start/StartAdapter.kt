package com.example.retrofit2.screens.start

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit2.R
import com.example.retrofit2.databinding.ItemMoneyLayoutBinding
import com.example.retrofit2.model.nal.Nal
import com.example.retrofit2.model.nal.NalItem

class StartAdapter : RecyclerView.Adapter<StartAdapter.StartViewHolder>() {
    private var listAd = emptyList<NalItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StartViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_money_layout, parent, false)
        return StartViewHolder(view)
    }
    override fun onBindViewHolder(holder: StartViewHolder, position: Int) {
        val item = listAd[position]
        holder.setData(item)
    }
    override fun getItemCount(): Int {
        return listAd.size
    }
    class StartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemMoneyLayoutBinding.bind(itemView)

        fun setData(item: NalItem) {
            binding.itemTvName.text = item.ccy
            binding.itemTvBuy.text = item.buy
            binding.itemTvSale.text = item.sale
        }
    }
    @SuppressLint("NotifyDataSetChanged")
    fun updateAdapter(newList: List<NalItem>) {
        listAd = newList
        notifyDataSetChanged()
    }
}