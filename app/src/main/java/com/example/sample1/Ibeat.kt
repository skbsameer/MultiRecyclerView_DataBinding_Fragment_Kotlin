package com.example.sample1

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Ibeat {
    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("catids")
    @Expose
    var catids: String? = null

    @SerializedName("catname")
    @Expose
    var catname: String? = null

    @SerializedName("ibeaturl")
    @Expose
    var ibeaturl: String? = null
}