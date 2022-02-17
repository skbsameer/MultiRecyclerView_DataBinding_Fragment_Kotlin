package com.example.sample1

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Banner {
    @SerializedName("header")
    @Expose
    var header: String? = null

    @SerializedName("desc")
    @Expose
    var desc: String? = null

    @SerializedName("link")
    @Expose
    var link: String? = null
}