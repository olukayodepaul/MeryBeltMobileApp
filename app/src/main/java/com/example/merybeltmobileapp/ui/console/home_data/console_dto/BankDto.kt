package com.example.merybeltmobileapp.ui.console.home_data.console_dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

//BankList(1)
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

//CustValid(2): Request as body data
data class CustomerValidation(
    @SerializedName("bankCode")
    @Expose
    val bankCode: String? = "",
    @SerializedName("accountNumber")
    @Expose
    val accountNumber: String = ""
)

//CustValid(3): Response data
data class CustValidStatus(
    @SerializedName("status")
    @Expose
    val status: Boolean? = null,
    @SerializedName("data")
    @Expose
    val data: CustomerValidBodyData? = null
){
    data class CustomerValidBodyData(
        @SerializedName("bankCode")
        @Expose
        val bankCode: String? = "",
        @SerializedName("accountName")
        @Expose
        val accountName: String = "",
        @SerializedName("accountNumber")
        @Expose
        val accountNumber: String = "",
        @SerializedName("walletBalance")
        @Expose
        val walletBalance: String = "",
        @SerializedName("amountCharged")
        @Expose
        val amountCharged: String = ""
    )
}

//Trans(4) : Request as body Data user ->CustValid(3) data
data class TransferFundReq(
    @SerializedName("amount")
    @Expose
    val amount: Double? = 0.0,
    @SerializedName("stan")
    @Expose
    val stan: String = "",
    @SerializedName("pin")
    @Expose
    val pin: String = "",
    @SerializedName("accountNumber")
    @Expose
    val accountNumber: String = "",
    @SerializedName("bankCode") //from CustValid(3) bank code
    @Expose
    val bankCode: String = "",
    @SerializedName("type")
    @Expose
    val type: String = "",
)

//Trans(5): Response
data class TransferFundRes(
    @SerializedName("status")
    @Expose
    val status: Boolean? = null,
    @SerializedName("data")
    @Expose
    val data: TransferFundResBodyData? = null
){
    data class TransferFundResBodyData(
        @SerializedName("responseCode")
        @Expose
        val responseCode: String? = "",
        @SerializedName("description")
        @Expose
        val description: String = "",
    )
}


//Network Mgt(6) get session_id Request
data class NetworkMgtReq(
    val serialNumber: String? = null,
    val stan: String? = null,
    val onlyAccountInfo: Boolean? = null
)

//Network Mgt(7) get session_id Response
data class NetworkMgtRes(
    @SerializedName("status")
    @Expose
    val status: Boolean? = null,
    @SerializedName("data")
    @Expose
    val data: NetworkMgtResBodyData? = null
){
    data class NetworkMgtResBodyData(
        @SerializedName("sessionId")
        @Expose
        val sessionId: String? = "",
        @SerializedName("terminalId")
        @Expose
        val terminalId: String = "",
        @SerializedName("merchantId")
        @Expose
        val merchantId: String = "",
    )
}



