package com.example.mathflat.ui.main.dummy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.mathflat.R
import com.example.mathflat.databinding.FragmentDummyBinding

class DummyFragment2 : Fragment() {
    lateinit var viewDataBinding: FragmentDummyBinding
    var layoutResourceId: Int = R.layout.fragment_dummy

    companion object {
        var INSTANCE : DummyFragment2?= null
        fun getInstance() : DummyFragment2 {
            INSTANCE?.let {
                return it
            } ?: kotlin.run {
                INSTANCE = DummyFragment2()
                return INSTANCE as DummyFragment2
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewDataBinding = DataBindingUtil.inflate(inflater, layoutResourceId, container, false)
        return viewDataBinding.root
    }





}