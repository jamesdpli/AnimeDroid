package com.example.animedroid.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.animedroid.R
import com.example.animedroid.data.AnimeApi
import com.example.animedroid.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.animeListFragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        GlobalScope.launch {
            val myAnime = AnimeApi.animeService.getAnimeById("10")
            Log.d("Kola", myAnime.body().toString())
        }

        setContentView(view)
    }
}
