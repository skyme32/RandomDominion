package com.skyme32.randomdominion.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.skyme32.randomdominion.MainActivity
import com.skyme32.randomdominion.bean.Card
import com.skyme32.randomdominion.factory.RandomCards

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<ArrayList<Card>>().apply {
        var randomCards = RandomCards(MainActivity.allCcards, MainActivity.numCards)
        value =  randomCards.getArrayPlayOfCards()
    }

    val text: LiveData<ArrayList<Card>> = _text
}