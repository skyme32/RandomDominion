package com.skyme32.randomdominion.ui.notifications

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.skyme32.randomdominion.R
import com.skyme32.randomdominion.ScrollingActivity
import com.skyme32.randomdominion.bean.Card
import com.skyme32.randomdominion.factory.AdapterCustom
import com.skyme32.randomdominion.ui.home.HomeViewModel

class NotificationsFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel
    private val CARD_ID = "CARD_ID"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        notificationsViewModel = ViewModelProviders.of(this).get(NotificationsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val listView: ListView = root.findViewById(R.id.list_ramdom_view)

        notificationsViewModel.array.observe(this, Observer {
            Log.d("listview[All]", "Size: " + it.count())
            Log.d("listview[All]", "Cards: $it")

            val adapter = AdapterCustom(root.context, it)
            listView.adapter = adapter
            listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
                newIntent(view.context, it[position])
                Log.d("listview", "Cards: $parent $id")
            }
        })

        return root
    }

    private fun newIntent(context: Context?, card: Card) {
        val intent = Intent(context, ScrollingActivity::class.java)
        intent.putExtra(CARD_ID, card)
        startActivity(intent)
    }
}


