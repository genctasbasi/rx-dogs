package com.genctasbasi.rxdogs.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.genctasbasi.rxdogs.R
import com.genctasbasi.rxdogs.navigation.NavigationManager
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val navigationManager: NavigationManager by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // set navigation component
        navigationManager.setNavigationController(
            Navigation.findNavController(
                this,
                R.id.navigation_host
            )
        )
    }
}