package com.example.retrofit2.screens.second

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit2.R
import com.example.retrofit2.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: SecondAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel = ViewModelProvider(this).get(SecondViewModel::class.java)
        val v = inflater.inflate(R.layout.fragment_second, container, false)
        val binding = FragmentSecondBinding.bind(v)
        recyclerView = binding.rcViewSecond
        adapter = SecondAdapter()
        recyclerView.adapter = adapter
        viewModel.getBezNalMoney()
        viewModel.myMoneyList.observe(viewLifecycleOwner) { list ->
            list.body()?.let { adapter.updateAdapter(it) }
        }

        return v

    }

}