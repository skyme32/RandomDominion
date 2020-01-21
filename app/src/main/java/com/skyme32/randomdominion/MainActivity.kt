package com.skyme32.randomdominion

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.skyme32.randomdominion.bean.Card
import java.lang.Thread.sleep
import java.util.*

class MainActivity : AppCompatActivity() {

    companion object {
        var allCcards: ArrayList<Card>? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sleep(500)
        setTheme(R.style.AppTheme)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_play, R.id.navigation_category, R.id.navigation_all
            )
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        allCcards = onInstanceAll()
    }

    /**
     *
     */
    private fun onInstanceAll():ArrayList<Card> {
        var arrayCards: ArrayList<Card> = ArrayList<Card>()
        val title = resources.getStringArray(R.array.title)
        val desc = resources.getStringArray(R.array.desc)
        val cost = resources.getStringArray(R.array.cost)
        val image = resources.getStringArray(R.array.image)
        val action = resources.getStringArray(R.array.action)
        val exp = resources.getStringArray(R.array.expansion)

        for (y in title.indices) {
            var card:Card = Card(
                title[y],
                exp[y],
                resources.getIdentifier("money" + cost[y], "drawable", packageName),
                resources.getIdentifier(image[y], "drawable", packageName),
                desc[y],
                action[y]
            )

            arrayCards.add(card)
        }

        return arrayCards
    }


}
