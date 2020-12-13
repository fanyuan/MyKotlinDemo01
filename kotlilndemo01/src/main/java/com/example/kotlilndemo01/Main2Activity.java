package com.example.kotlilndemo01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    public void skip(View v){
        startActivity(new Intent(this, Kotlin01Activity.class));
    }
    public void debug(View v){
        for(int i = 0; i < 10; i++){

            int value = i;
            Log.d("ddebug","value = " + value);
            if(i==9){
                nextValue(i);
            }
        }
    }
    private void nextValue(int value){
        Log.d("ddebug","next value = " + value);
    }

}
