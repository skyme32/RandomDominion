package com.skyme32.randomdominion.factory

import android.util.Log
import com.skyme32.randomdominion.bean.Card
import java.util.*

class RandomCards(cards: ArrayList<Card>?, numCards: Int) {

    private var cards: ArrayList<Card>? = null
    private var numCards: Int = 0

    init {
        this.cards = ArrayList()
        this.cards = cards
        this.numCards = numCards

    }


    /**
     *
     */
    fun getArrayPlayOfCards(): ArrayList<Card> {
        var arrayPlayCards: ArrayList<Card> = ArrayList()

        //function that create arraylist with 10 numbers
        val randomNumbers: List<Int> = randomToTenNumbers(this.cards!!.size)

        for (i in randomNumbers.indices) {
            arrayPlayCards.add(cards!![randomNumbers[i]])
            Log.d("RandomCard", "Index[" + i + "]: " + cards!![randomNumbers[i]].toString())
        }

        return arrayPlayCards;
    }

    /**
     * Function that create arraylist with 10 numbers
     */
    private fun randomToTenNumbers(size: Int): List<Int> {
        return (0 until size).shuffled().subList(0,numCards)
    }
}