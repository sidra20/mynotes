package com.mynotess21.core.models

data class Products(
    var id:String?=null,
    var name:String,
    var price:Int,
    var qty:Int,
    var img:String?=null
){
//    fun toMap() : Map<String,Any?>{
//        return mapOf(
//            "id" to id,
//            "productname" to name,
//            "price" to price,
//            "quantity" to qty,
//            "image" to img
//        )
//    }
}
