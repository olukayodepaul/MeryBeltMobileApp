package com.example.merybeltmobileapp.ui.console.home_data.console_dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Banks(
    @SerializedName("status")
    @Expose
    val status: String? = "",
    @SerializedName("data")
    @Expose
    val data: List<BankList> =  emptyList()
){
    data class BankList(
        @SerializedName("url")
        @Expose
        val url: String? = "",
        @SerializedName("name")
        @Expose
        val name: String = "",
        @SerializedName("code")
        @Expose
        val code: String = ""
    )
}