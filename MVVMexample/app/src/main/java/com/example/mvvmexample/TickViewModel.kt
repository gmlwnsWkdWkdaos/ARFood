package com.example.mvvmexample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class TickViewModel : ViewModel() {
    val tickNumber : MutableLiveData<Int> by lazy {
        MutableLiveData<Int>(0)
    }

    fun tick() {
        tickNumber.value = (tickNumber.value ?: + 1 )//ticknumber의 value를 바꾸겠다
                                                    // ?: -> 엘비스 operator : null이라면 0을 넣겠다

    }
}