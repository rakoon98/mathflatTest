package com.example.mathflat.ui.main

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mathflat.R
import com.example.mathflat.databinding.ActivityMainBinding
import com.example.mathflat.model.data.viewPagerTitles
import com.example.mathflat.ui.main.dummy.DummyFragment
import com.example.mathflat.ui.main.dummy.DummyFragment2
import com.example.mathflat.ui.main.dummy.DummyFragment3
import com.example.mathflat.ui.main.dummy.ErrorFragment
import com.example.mathflat.ui.main.learning.LearningFragment
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    lateinit var viewDataBinding: ActivityMainBinding
    private val layoutResourceId: Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewDataBinding = DataBindingUtil.setContentView(this, layoutResourceId)
        attachViewInit()
    }

    private fun attachViewInit() {
        viewDataBinding.apply {
            viewPagerFree.apply {
                adapter = ViewPagerAdapter(this@MainActivity)
                tabLayout.setTabTextColors(Color.WHITE, Color.WHITE)
                TabLayoutMediator(tabLayout, viewPagerFree) { tab, position ->
                    tab.text = viewPagerTitles[position]
                }.attach()
            }
        }
    }

    private inner class ViewPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> DummyFragment.getInstance()
                1 -> DummyFragment2.getInstance()
                2 -> LearningFragment.getInstance()
                3 -> DummyFragment3.getInstance()
                else -> {
                    ErrorFragment.getInstance()
                }
            }
        }

        override fun getItemCount(): Int = 4
    }

}
