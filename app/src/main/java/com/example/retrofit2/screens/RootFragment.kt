package com.example.retrofit2.screens

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.example.retrofit2.R
import com.example.retrofit2.ViewPagerAdapter
import com.example.retrofit2.databinding.FragmentRootBinding
import com.google.android.material.tabs.TabLayoutMediator

class RootFragment : Fragment() {
    lateinit var adapter: ViewPagerAdapter
    var ctx: Context? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        ctx = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_root, container, false)
        val binding = FragmentRootBinding.bind(view)
        adapter = ViewPagerAdapter(ctx as FragmentActivity)
        binding.apply {
            viewPager.adapter = adapter
            tabLayout.tabIconTint = null
            TabLayoutMediator(tabLayout, viewPager) { tab, pos ->
                when (pos) {
                    0 -> {
                        tab.setIcon(R.drawable.ic_baseline_attach_money_24)
                    }
                    1 -> {
                        tab.setIcon(R.drawable.ic_baseline_monetization_on_24)
                    }
                }

            }.attach()
        }

        return view

    }

}