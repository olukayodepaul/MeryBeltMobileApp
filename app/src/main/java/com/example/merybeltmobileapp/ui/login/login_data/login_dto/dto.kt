package com.example.merybeltmobileapp.ui.login.login_data.login_dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class LoginCredential(
    @SerializedName("login")
    @Expose
    val login: String,
    @SerializedName("loginPasswordMD5")
    @Expose
    val loginPasswordMD5: String
)

data class LoginResponse(
    @SerializedName("errorStatusCode")
    @Expose
    val errorStatusCode: Int,
    @SerializedName("customerId")
    @Expose
    val customerId: Int,
    @SerializedName("shopName")
    @Expose
    val shopName: String,
    @SerializedName("shopAddress")
    @Expose
    val shopAddress: String,
    @SerializedName("errorMessage")
    @Expose
    val errorMessage: String,
    @SerializedName("balance")
    @Expose
    val balance: Balance,
)

data class Balance(
    @SerializedName("balance")
    @Expose
    val balance: Float,
    @SerializedName("loanAmount")
    @Expose
    val loanAmount: Float,
    @SerializedName("cashierLoanAmount")
    @Expose
    val cashierLoanAmount: Float,
    @SerializedName("instantBetSettlementBalance")
    @Expose
    val instantBetSettlementBalance: Float
)

