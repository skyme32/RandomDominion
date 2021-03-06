package com.skyme32.randomdominion

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.preference.PreferenceManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.skyme32.randomdominion.bean.Card
import java.lang.Thread.sleep
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private var sharedPref: SharedPreferences? = null

    companion object {
        var allCcards: ArrayList<Card>? = null
        var tipyCards: ArrayList<Card>? = null
        var numCards: Int = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sleep(500)
        setTheme(R.style.AppTheme_NoActionBar)
        setContentView(R.layout.activity_main)

        // Create all instance of records
        allCcards = onInstanceAll()
        sharedPref = PreferenceManager.getDefaultSharedPreferences(this)
        numCards = sharedPref?.getString("ncartas",resources.getString(R.string.default_numCards))?.toInt()!!

        // Create all navigataion and actionbar
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)


        val toolbar: Toolbar = findViewById(R.id.toolbar2)
        toolbar.setTitleTextAppearance(this,R.style.TextTitleApp)
        setSupportActionBar(toolbar)

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_play, R.id.navigation_category, R.id.navigation_all
            )
        )

        //Add fragments navigation
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

    }

    override fun onResume() {
        super.onResume()
        numCards = sharedPref?.getString("ncartas",resources.getString(R.string.default_numCards))?.toInt()!!
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings ->{
                val intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


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
