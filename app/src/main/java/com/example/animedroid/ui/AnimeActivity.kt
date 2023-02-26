package com.example.animedroid.ui

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.animedroid.R
import com.example.animedroid.databinding.ActivityMainBinding
import dagger.android.support.DaggerAppCompatActivity

class AnimeActivity : DaggerAppCompatActivity() {

    private lateinit var navController: NavController

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.animeListFragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        setupActionBarWithNavController(
            navController = navController,
            configuration = AppBarConfiguration(navController.graph)
        )

        setContentView(view)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.animeListFragmentContainerView)
        return navController.navigateUp(AppBarConfiguration(navController.graph)) ||
            super.onSupportNavigateUp()
    }
}