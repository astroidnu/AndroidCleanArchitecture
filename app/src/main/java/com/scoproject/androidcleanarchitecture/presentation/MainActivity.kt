package com.scoproject.androidcleanarchitecture.presentation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.scoproject.androidcleanarchitecture.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)
    }
}
