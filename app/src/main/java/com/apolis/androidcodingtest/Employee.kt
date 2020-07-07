package com.apolis.androidcodingtest

import java.io.Serializable

data class Employee(
    var id: Long,
    var name: String,
    var email: String,
    var mobile: String
):Serializable{
    companion object{}
}