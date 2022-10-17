package com.bytedance.labcv.demo.barrage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bytedance.labcv.demo.databinding.BarrageDisplayViewBinding
import com.bytedance.labcv.demo.viewmodels.BarrageListViewModel

class BarrageDisplay: Fragment() {

    private val viewmodel: BarrageListViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = BarrageDisplayViewBinding.inflate(inflater, container, false)
        val adapter = BarrageAdapter()
        binding.rvMsg.adapter = adapter
        subscribeUi(adapter)
        return binding.root
    }

    fun subscribeUi(adapter: BarrageAdapter){
        viewmodel.barrages.observe(viewLifecycleOwner) { barrages ->
            adapter.submitList(barrages)
        }
    }
}