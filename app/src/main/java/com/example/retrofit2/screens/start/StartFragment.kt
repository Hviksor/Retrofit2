package com.example.retrofit2.screens.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.retrofit2.R
import com.example.retrofit2.databinding.FragmentStartBinding

class StartFragment : Fragment() {
    lateinit var adapter: StartAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel = ViewModelProvider(this)[StartViewModel::class.java]
        val view = inflater.inflate(R.layout.fragment_start, container, false)
        val binding = FragmentStartBinding.bind(view)
        adapter = StartAdapter()
        binding.rcViewStart.adapter = adapter
        viewModel.getNalMoney()
        viewModel.myMoneyList.observe(viewLifecycleOwner){list->
            list.body()?.let { adapter.updateAdapter(it) }
        }
        return view
    }

}