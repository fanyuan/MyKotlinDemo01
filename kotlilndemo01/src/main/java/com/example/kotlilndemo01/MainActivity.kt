package com.example.kotlilndemo01
import android.content.Intent
import com.example.kotlilndemo01.R



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun skip2Java(v: View){
        startActivity(Intent(this,Main2Activity::class.java))
    }
    fun coroutineActivity(v:View){
        startActivity(Intent(this,CoroutineActivity::class.java))
    }
}
