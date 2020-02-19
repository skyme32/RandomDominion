package com.skyme32.randomdominion.ui.allcards

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.skyme32.randomdominion.MainActivity
import com.skyme32.randomdominion.bean.Card

class NotificationsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is notifications Fragment"
    }
    val text: LiveData<String> = _text


    private val _array = MutableLiveData<ArrayList<Card>>().apply {
        value =  MainActivity.allCcards
    }

    val array: LiveData<ArrayList<Card>> = _array
}