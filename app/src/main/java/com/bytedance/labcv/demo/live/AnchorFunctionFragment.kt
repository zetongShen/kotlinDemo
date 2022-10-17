package com.bytedance.labcv.demo.live

import android.app.ProgressDialog.show
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.bytedance.labcv.demo.R
import com.bytedance.labcv.demo.barrage.BarrageAdapter
import com.bytedance.labcv.demo.barrage.BarrageDisplay
import com.bytedance.labcv.demo.barrage.BarrageSendFragment
import com.bytedance.labcv.demo.databinding.AnchorFunctionViewBinding
import com.bytedance.labcv.demo.viewmodels.AnchorFunViewModel
import com.bytedance.labcv.demo.viewmodels.BarrageSendViewModel

class AnchorFunctionFragment: Fragment() {

    private lateinit var binding: AnchorFunctionViewBinding
    private val model: AnchorFunViewModel by viewModels()
    private val barsendModel: BarrageSendViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = AnchorFunctionViewBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //展示弹幕输入组件
//        model.isClickBarrageBtn.observe(viewLifecycleOwner) {
//            fragmentManager?.let { it1 -> BarrageSendFragment().show(it1, "loos") }
//        }

        binding.tvBarrage.setOnClickListener {
            Log.e("ssssssdswew", "到底点积累没")
            fragmentManager?.let { it1 -> BarrageSendFragment().show(it1, "lll") }
        }

        initExtensionView()

//        barsendModel.
    }

    private fun initExtensionView(){
        initBarrage()
        initGift()
    }

    private fun initBarrage(){
        //TODO 要显示弹幕啦
        childFragmentManager.beginTransaction().replace(R.id.fl_barrage_show, BarrageDisplay()).commit()

    }

    private fun initGift(){

    }

}