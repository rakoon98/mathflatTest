package com.example.mathflat.ui.main.learning

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import com.example.mathflat.R
import com.example.mathflat.databinding.FragmentLearningBinding
import com.example.mathflat.ui.main.learning.adapter.LearningAdapter
import com.example.mathflat.viewmodel.learning.LearningViewmodel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class LearningFragment : Fragment(),LifecycleOwner {
    lateinit var viewDataBinding: FragmentLearningBinding
    var layoutResourceId: Int = R.layout.fragment_learning

    val learningViewmodel : LearningViewmodel by viewModel()
    val learningAdapter : LearningAdapter by inject()

    companion object {
        var INSTANCE : LearningFragment ?= null

        fun getInstance() : LearningFragment {
            INSTANCE?.let {
                return it
            } ?: kotlin.run {
                INSTANCE = LearningFragment()
                return INSTANCE as LearningFragment
            }
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = DataBindingUtil.inflate(inflater, layoutResourceId, container, false)

        viewDataBinding.apply {
            lifecycleOwner = this@LearningFragment
            viewmodel = learningViewmodel
            learningViewmodel.getPieces()

            learningRecyclerView.apply { adapter = learningAdapter }

            executePendingBindings()
        }

        return viewDataBinding.root
    }

}