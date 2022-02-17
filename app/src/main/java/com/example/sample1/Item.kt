package com.example.sample1

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Item {
    @SerializedName("dust")
    @Expose
    var dust: String? = null

    @SerializedName("NewsItem")
    @Expose
    var newsItem: List<NewsItem>? = null

    @SerializedName("sn")
    @Expose
    var sn: String? = null

    @SerializedName("tn")
    @Expose
    var tn: String? = null

    @SerializedName("sobj")
    @Expose
    var sobj: List<String>? = null

    @SerializedName("mfBGColor")
    @Expose
    var mfBGColor: String? = null

    @SerializedName("mfBGColorNightMode")
    @Expose
    var mfBGColorNightMode: String? = null

    @SerializedName("mfButtonColor")
    @Expose
    var mfButtonColor: String? = null

    @SerializedName("du")
    @Expose
    var du: String? = null
}