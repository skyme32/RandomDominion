package com.skyme32.randomdominion.bean

import java.io.Serializable

class Card(
    title: String?,
    expansion: String?,
    drawableImageIDcost: Int,
    drawableImageID: Int,
    descriptions: String?,
    action: String?
) : Serializable {

    var title: String? = null
    var descriptions: String? = null
    var drawableImageID = 0
    var drawableImageIDcost = 0
    var expansion: String? = null
    var action: String? = null

    init {
        this.title = title
        this.expansion = expansion
        this.drawableImageIDcost = drawableImageIDcost
        this.drawableImageID = drawableImageID
        this.descriptions = descriptions
        this.action = action
    }

    override fun toString(): String {
        return "Card(title=$title, drawableImageID=$drawableImageID, drawableImageIDcost=$drawableImageIDcost, expansion=$expansion)"
    }


}