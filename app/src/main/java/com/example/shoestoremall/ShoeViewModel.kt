package com.example.shoestoremall

import com.example.shoestoremall.data.ShoeData

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class ShoeViewModel : ViewModel() {
    private val _shoeList = MutableLiveData<MutableList<ShoeData>>(mutableListOf())
    val shoeList: LiveData<MutableList<ShoeData>> get() = _shoeList

    private val _currentShoe = MutableLiveData<ShoeData>()
    val currentShoe: LiveData<ShoeData> get() = _currentShoe

//    val shoeSizeStr: LiveData<String> = Transformations.map(_currentShoe) { it.size.toString() }
    init {
        _currentShoe.value = ShoeData("",  "", "")
    }

    fun addShoe(shoe: ShoeData) {
        _shoeList.value?.add(shoe)
        _shoeList.value = _shoeList.value
    }
/*
    fun clearCurrentShoe() {
        _currentShoe.value = ShoeData("", 0.0, "", "")
    }
*/
}