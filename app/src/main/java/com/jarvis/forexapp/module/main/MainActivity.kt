package com.jarvis.forexapp.module.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jarvis.forexapp.R
import com.jarvis.forexapp.base.BaseActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}