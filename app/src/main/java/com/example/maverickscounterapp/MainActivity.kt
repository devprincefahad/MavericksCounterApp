package com.example.maverickscounterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.airbnb.mvrx.Mavericks

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Mavericks.initialize(this)
        setContentView(R.layout.activity_main)
    }
}