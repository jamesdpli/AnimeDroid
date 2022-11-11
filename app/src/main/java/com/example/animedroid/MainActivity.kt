package com.example.animedroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.animedroid.data.AnimeApi
import com.example.animedroid.data.AnimesRepository
import com.example.animedroid.data.RemoteAnimesDataSource
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    val repository =  AnimesRepository(RemoteAnimesDataSource(AnimeApi))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch {
            val pop = repository.getAnimes()
            Log.d("HelpMe", pop.body().toString())
        }


    }
}