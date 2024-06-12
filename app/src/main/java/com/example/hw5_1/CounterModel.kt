package com.example.hw5_1

import android.widget.Toast

class CounterModel {

    private var count = 0


    fun inc(){
        count++

    }
    fun dec(){
        count--
    }
    fun getResult() = count


}