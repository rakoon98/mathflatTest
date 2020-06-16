package com.example.mathflat.ui.litmus

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.mathflat.databinding.ActivityLitmusBinding
import com.example.mathflat.R
import com.example.mathflat.ui.litmus.adapter.LitmusAdapter
import com.example.mathflat.ui.litmus.adapter.LitmusBtnInterace
import com.example.mathflat.util.VerificationMyAnswerHaveNull
import com.example.mathflat.viewmodel.litmus.LitmusViewmodel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class LitmusActivity : AppCompatActivity(), LifecycleOwner {

    lateinit var viewDataBinding: ActivityLitmusBinding
    private val layoutResourceId: Int = R.layout.activity_litmus

    private val litmusViewmodel : LitmusViewmodel by viewModel()
    private val litmusAdapter : LitmusAdapter by inject { parametersOf( enabledInterface ) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewDataBinding = DataBindingUtil.setContentView(this, layoutResourceId)
        attachViewInit()
    }

    private fun attachViewInit() {
        viewDataBinding.apply {
            lifecycleOwner = this@LitmusActivity
            viewmodel = litmusViewmodel

            litmusRecyclerView.apply { adapter = litmusAdapter }

            val getId = intent.getIntExtra("PieceDataId",-1)
            if(getId==-1){
                // id를 제대로 못가져와 default 를 가져왔으므로 안내를 하고 뒤로보내든지 한다.
                finish()
            } else {
                // id 가져옴
                litmusViewmodel.getPiecesContactId(getId)
            }

            finishView.setOnClickListener { finish() }
            showLitmusSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
                litmusAdapter.showAllLitmus(isChecked)
            }
            submitBtn.setOnClickListener {
                if( VerificationMyAnswerHaveNull(litmusAdapter.litmusItems) )
                litmusAdapter.submitLitmus()
            }

            executePendingBindings()
        }
    }

    private val enabledInterface = object : LitmusBtnInterace {
        override fun setEnabledSubmitBtn(enabled: Boolean) {
            viewDataBinding.submitBtn.isEnabled = enabled
            viewDataBinding.executePendingBindings()
        }

        override fun setResult(result: String) {
            viewDataBinding.run {
                submitBtn.visibility = View.GONE
                showLitmusResultTx.apply {
                    visibility = View.VISIBLE
                    text = result
                }
            }
        }
    }

}