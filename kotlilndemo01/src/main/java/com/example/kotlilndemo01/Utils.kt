package com.example.kotlilndemo01

import android.util.Log

fun utilLog(tag:String = "ddebug",msg:String){
    Log.d(tag,msg)
}
fun main() {
    Log.d("ddebug","test 123 abc")
}