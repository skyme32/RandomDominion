package com.skyme32.randomdominion.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.*
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.skyme32.randomdominion.R
import com.skyme32.randomdominion.ScrollingActivity
import com.skyme32.randomdominion.SettingsActivity
import com.skyme32.randomdominion.bean.Card
import com.skyme32.randomdominion.factory.AdapterCustom


class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private val CARD_ID = "CARD_ID"
    private var mLastClickTime: Long = 0
    private var pointPlaying: Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        var root: View? = inflater.inflate(R.layout.fragment_home, container, false)




            //Inflate the layout for this fragment
            val listView: ListView = root!!.findViewById(R.id.list_ramdom_view)

            homeViewModel.text.observe(this, Observer {
                Log.d("listview", "Size: " + it.count())
                Log.d("listview", "Cards: $it")


                val adapter = AdapterCustom(root!!.context, it)
                listView.adapter = adapter
                listView.onItemClickListener =
                    AdapterView.OnItemClickListener { parent, view, position, id ->

                        if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                        } else {
                            newIntent(this.context, it[position])
                        }

                        mLastClickTime = SystemClock.elapsedRealtime()
                    }
            })

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_play, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.filter_history ->{

                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


    private fun newIntent(context: Context?, card: Card) {
        val intent = Intent(context, ScrollingActivity::class.java)
        intent.putExtra(CARD_ID, card)
        startActivity(intent)
    }
}