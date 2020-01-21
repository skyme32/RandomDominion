package com.skyme32.randomdominion.factory

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.skyme32.randomdominion.R
import com.skyme32.randomdominion.bean.Card

class AdapterCustom(var context: Context, items: ArrayList<Card>) : BaseAdapter() {

    var items: ArrayList<Card>? = null

    init {
        this.items = items
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var holder:ViewHolder? = null
        var view:View? = convertView

        // See if the view have a information or NOT
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.listview_item, null)
            holder = ViewHolder(view)
            view.tag = holder
        }else {
            holder = view.tag as? ViewHolder
        }

        //Add all items with every ListView
        val item = getItem(position) as Card
        holder?.imageView?.setImageResource(item.drawableImageID)
        holder?.titleView?.text = item.title
        holder?.subtitleView?.text = item.action
        holder?.moneyView?.setImageResource(item.drawableImageIDcost)

        return view!!
    }

    override fun getItem(position: Int): Any {
        return items?.get(position)!!
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return items?.count()!!
    }


    private class ViewHolder(view: View) {
        var imageView: ImageView? = null
        var titleView: TextView? = null
        var subtitleView: TextView? = null
        var moneyView: ImageView? = null

        init {
            imageView = view.findViewById(R.id.image)
            titleView = view.findViewById(R.id.tvField)
            subtitleView = view.findViewById(R.id.tvAct)
            moneyView = view.findViewById(R.id.money)
        }
    }
}