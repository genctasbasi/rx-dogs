package com.genctasbasi.rxdogs.navigation

import androidx.navigation.NavController
import androidx.navigation.NavDirections

interface NavigationManager {
    fun setNavigationController(navigationController: NavController)
    fun navigateTo(direction: NavDirections)
}