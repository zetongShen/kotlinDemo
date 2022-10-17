package com.bytedance.labcv.demo.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AnchorFunViewModel: ViewModel() {

    var isClickBarrageBtn = MutableLiveData<Boolean>(false)


    fun onClickBarrageBtn () {
        isClickBarrageBtn.value = true
    }


    var isCloseLive = MutableLiveData<Boolean>(false)
    fun onClose () {
        isCloseLive.value = true
    }

}