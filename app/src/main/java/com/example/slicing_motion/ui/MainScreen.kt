package com.example.slicing_motion.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.slicing_motion.ui.navigation.bottomNavItems
import androidx.navigation.compose.NavHost // USE THIS
import androidx.navigation.compose.composable
import com.example.slicing_motion.ui.homepage.HomePageScreen
import com.example.slicing_motion.ui.marketplace.MarketplaceScreen
import com.example.slicing_motion.ui.pantautanaman.PantauTanamanScreen
import com.example.slicing_motion.ui.profil.ProfilScreen
import kotlinx.serialization.Serializable

@Serializable object RouteHome
@Serializable object RouteOverlook
@Serializable object RouteMarketPlace
@Serializable object RouteProfile

@Composable
@Preview
fun MainScreen(
    onNavigateToDetail: () -> Unit = {},
    onEditingPage: () -> Unit = {},
    onCheckingOrder: () -> Unit = {}
){
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination

    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = Color.White,
            ){
                bottomNavItems.forEach{item ->
                    val isSelected = currentRoute?.hasRoute(item.route::class) == true

                    NavigationBarItem(
                        selected = isSelected,
                        onClick = {
                            navController.navigate(item.route){
                                popUpTo(navController.graph.startDestinationId){
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = Color.Transparent
                        ),
                        icon = {
                            Icon(
                                painter = painterResource(id = item.icon),
                                contentDescription = null,
                                modifier = Modifier.size(24.dp),
                                tint = if (isSelected) Color(0xFF179778) else Color.LightGray
                            )
                        },
                        label = {
                            Text(
                                text = item.label,
                                maxLines = 1,
                                overflow = TextOverflow.Visible,
                                softWrap = false,
                                style = MaterialTheme.typography.labelSmall.copy(fontSize = 10.sp),
                                color = if (isSelected) Color(0xFF179778) else Color.LightGray
                            )
                        }
                    )
                }
            }
        }
    ) {
        innerPadding ->
        NavHost(
            navController = navController,
            startDestination = RouteHome,
            modifier = Modifier.padding(innerPadding)
        ){
            composable<RouteHome> { HomePageScreen(
                onClickCard = onNavigateToDetail
            ) }
            composable<RouteOverlook> { PantauTanamanScreen() }
            composable<RouteMarketPlace> { MarketplaceScreen() }
            composable<RouteProfile> { ProfilScreen(
                onEditClick = onEditingPage,
                onCheckOrder =  onCheckingOrder
            ) }



        }
    }

}