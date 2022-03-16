package com.example.retrofit2.screens.second

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.retrofit2.R
import com.example.retrofit2.databinding.FragmentRootBinding
import com.example.retrofit2.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel = ViewModelProvider(this)[SecondViewModel::class.java]
        val v = inflater.inflate(R.layout.fragment_second, container, false)
        val binding = FragmentSecondBinding.bind(v)
        val adapter = SecondAdapter()
        binding.rcViewSecond.adapter = adapter

        viewModel.getMyBezNalCourse()

        viewModel.myBezNalCourse.observe(viewLifecycleOwner) { list ->

            list.body()?.let { adapter.updateAdapter(it) }
        }
        return v
    }

}