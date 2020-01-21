package com.skyme32.randomdominion

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.skyme32.randomdominion.bean.Card
import kotlinx.android.synthetic.main.activity_scrolling.*


class ScrollingActivity : AppCompatActivity() {

    private val CARD_ID = "CARD_ID"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)
        setSupportActionBar(toolbar)

        val card: Card? = intent.extras!!.getSerializable("CARD_ID") as Card?

        //
        val image: ImageView = findViewById(R.id.image_paralax)
        image.setImageResource(card?.drawableImageID!!)

        // Description of the card
        val txtViewDesc:TextView = findViewById(R.id.txtViewDesc)
        txtViewDesc?.text = card?.descriptions

        // Action/Points cards
        val cardViewAct:CardView = findViewById(R.id.cardAction)
        val textViewAct:TextView = findViewById(R.id.txtViewDesc2)

        //CardView action
        textViewAct?.text = card?.action

        /**
         *
         * <item>Victoria</item>
         * <item>Acción</item>
         * <item>Ataque</item>
         */
        when (card?.action) {
            "Victoria" -> cardViewAct.setBackgroundResource(R.color.actBackgroung)
            "Acción" -> cardViewAct.setBackgroundResource(R.color.inActive)
            "Ataque" -> cardViewAct.setBackgroundResource(R.color.actBackAtack)
            else -> { }
        }


        // Create the icon fab, only exist for view
        fab.setImageResource(card?.drawableImageIDcost!!)

        // Create the toolbar Scrolling
        supportActionBar?.title = card?.title
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


}
