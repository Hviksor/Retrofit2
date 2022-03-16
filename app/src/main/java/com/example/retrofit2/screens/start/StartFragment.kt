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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel = ViewModelProvider(this)[StartViewModel::class.java]
        val v = inflater.inflate(R.layout.fragment_start, container, false)
        val binding = FragmentStartBinding.bind(v)
        val adapter = StartAdapter()
        binding.rcViewStart.adapter = adapter
        viewModel.getMyNalCourse()
        viewModel.myNalCourse.observe(viewLifecycleOwner) { list ->
            list.body()?.let { adapter.updateAdapter(it) }
        }
        return v
    }

}