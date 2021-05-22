package com.genctasbasi.rxdogs.navigation

import androidx.navigation.NavController
import androidx.navigation.NavDirections

class NavigationManagerImpl : NavigationManager {

    private lateinit var navigationController: NavController

    override fun setNavigationController(navigationController: NavController) {
        this.navigationController = navigationController
    }

    override fun navigateTo(direction: NavDirections) {
        navigationController.navigate(direction)
    }
}