package com.example.sample1

import com.bilingoal.recyclerviewdatabinding.Pn
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class NewsApp {
    @SerializedName("updl")
    @Expose
    var updl: String? = null

    @SerializedName("pn")
    @Expose
    var pn: Pn? = null

    @SerializedName("ibeat")
    @Expose
    var ibeat: Ibeat? = null

    @SerializedName("Item")
    @Expose
    var item: List<Item>? = null
}