package com.bytedance.labcv.demo.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bytedance.labcv.demo.data.Barrage
import kotlinx.coroutines.flow.flatMapLatest

class BarrageListViewModel: ViewModel() {

    val barrages = MutableLiveData<ArrayList<Barrage>>()

    init  {
        val barrage: Barrage = Barrage(msg = "sssss")
        val list: ArrayList<Barrage> = ArrayList<Barrage>()
        list.add(barrage)
        barrages.value = list
    }

    fun receiveBarrage(){

    }
}