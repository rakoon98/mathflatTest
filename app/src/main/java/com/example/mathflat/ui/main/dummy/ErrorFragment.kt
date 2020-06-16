package com.example.mathflat.ui.main.dummy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.mathflat.R
import com.example.mathflat.databinding.FragmentDummyBinding

class ErrorFragment : Fragment() {
    lateinit var viewDataBinding: FragmentDummyBinding
    var layoutResourceId: Int = R.layout.fragment_dummy

    companion object {
        var INSTANCE : ErrorFragment?= null
        fun getInstance() : ErrorFragment {
            INSTANCE?.let {
                return it
            } ?: kotlin.run {
                INSTANCE = ErrorFragment()
                return INSTANCE as ErrorFragment
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewDataBinding = DataBindingUtil.inflate(inflater, layoutResourceId, container, false)
        viewDataBinding.dummyTx.text = "에러"
        return viewDataBinding.root
    }





}