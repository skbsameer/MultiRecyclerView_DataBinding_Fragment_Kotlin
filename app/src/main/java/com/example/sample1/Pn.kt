package com.bilingoal.recyclerviewdatabinding

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Pn {
    @SerializedName("tp")
    @Expose
    var tp: String? = null

    @SerializedName("pno")
    @Expose
    var pno: String? = null
}