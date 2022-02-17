package com.example.sample1

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class NewsItem {
    @SerializedName("big")
    @Expose
    var big: String? = null

    @SerializedName("hl")
    @Expose
    var hl: String? = null

    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("da")
    @Expose
    var da: String? = null

    @SerializedName("upd")
    @Expose
    var upd: String? = null

    @SerializedName("syn")
    @Expose
    var syn: String? = null

    @SerializedName("im")
    @Expose
    var im: String? = null

    @SerializedName("wu")
    @Expose
    var wu: String? = null

    @SerializedName("ga")
    @Expose
    var ga: String? = null

    @SerializedName("sv")
    @Expose
    var sv: String? = null

    @SerializedName("ssu")
    @Expose
    var ssu: String? = null

    @SerializedName("vdu")
    @Expose
    var vdu: String? = null

    @SerializedName("w")
    @Expose
    var w: String? = null

    @SerializedName("h")
    @Expose
    var h: String? = null

    @SerializedName("isAdaptive")
    @Expose
    var isAdaptive: String? = null

    @SerializedName("banners")
    @Expose
    var banners: List<Banner>? = null

    @SerializedName("minRead")
    @Expose
    var minRead: String? = null

    @SerializedName("isPrime")
    @Expose
    var isPrime: String? = null
}