package com.example.slicing_motion.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.slicing_motion.R
import com.example.slicing_motion.ui.RouteHome
import com.example.slicing_motion.ui.RouteMarketPlace
import com.example.slicing_motion.ui.RouteOverlook
import com.example.slicing_motion.ui.RouteProfile

data class BottomNavItem(
    val label: String,
    val icon: Int,
    val route: Any
)

val bottomNavItems = listOf(
    BottomNavItem("Home", R.drawable.selected_home, RouteHome),
    BottomNavItem("Pantau Tanaman", R.drawable.overlook, RouteOverlook),
    BottomNavItem("Marketplace", R.drawable.marketplace, RouteMarketPlace),
    BottomNavItem("Profil", R.drawable.profile_circle, RouteProfile)
)
