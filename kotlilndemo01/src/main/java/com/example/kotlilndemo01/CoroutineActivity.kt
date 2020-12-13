package com.example.kotlilndemo01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.coroutines.*
import java.util.*

class CoroutineActivity : AppCompatActivity() {
    val TAG = "ddebug"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine)
        //runBlockingTest(null)
    }
    fun runBlockingTest(v: View?){
        Log.e(TAG, "主线程：${mainLooper.thread.id}")
        runBlocking()
        Log.e(TAG, "协程执行结束")
    }
    fun runBlocking() = runBlocking{
        repeat(6){
            Log.d(TAG,"协程执行$it 线程id：${Thread.currentThread().id}")
            delay(300)
        }

    }
    fun job(v:View?){
        Log.e(TAG, "主线程id：${mainLooper.thread.id}")
        val job = GlobalScope.launch {
            delay(3000)
            Log.e(TAG, "协程执行结束 -- 线程id：${Thread.currentThread().id}")
        }
        Log.e(TAG, "主线程执行结束")
    }
    fun suspend(v:View){
        log("---suspend---")
        GlobalScope.launch {
            var token = getToken()
            val userInfo = getUserInfo(token)
            setUserInfo(userInfo)
        }
        repeat(8){
            log("主线程执行$it")
        }
    }

    private fun setUserInfo(userInfo:String){
        log("setUserInfo userInfo = $userInfo")
    }
    private suspend fun getToken():String{
        log("---getToken---")
        delay(2000)
        return "token"
    }
    suspend fun getUserInfo(token:String):String{
        log("---getUserInfo---")
        delay(1000)
        return token + "userInfo"
    }
    fun async(v:View){
        log("主线程id：${mainLooper.thread.id}")
        GlobalScope.launch {
            val value1 = GlobalScope.async {
                getResult1()
            }
            var value2 = GlobalScope.async {
                getResult2()
            }
            log("线程id：${Thread.currentThread().id}")
            log("value1 = ${value1.await()}---value2 = ${value2.await()}")
        }

    }
    suspend fun getResult1():Int{
        delay(1000)
        return Random().nextInt()
    }
    private suspend fun getResult2():String{
        delay(2000)
        return "abcdefg"
    }
    private fun log(msg:String){
        Log.d("ddebug",msg)
    }

}
