package com.example.slicing_motion.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.slicing_motion.ui.MainScreen
import com.example.slicing_motion.ui.editProfil.EditProfilScreen
import com.example.slicing_motion.ui.statuspesanan.StatusPesananScreen
import com.example.slicing_motion.ui.lamantanaman.LamanTamanScreen
import com.example.slicing_motion.ui.login.LoginScreen
import com.example.slicing_motion.ui.onboarding.*
import com.example.slicing_motion.ui.personalization.Personalization1
import com.example.slicing_motion.ui.personalization.Personalization2
import com.example.slicing_motion.ui.personalization.Personalization3
import com.example.slicing_motion.ui.register.RegisterScreen
import kotlinx.coroutines.delay
import kotlinx.serialization.Serializable

@Serializable object RouteOnboarding1
@Serializable object RouteOnboarding2
@Serializable object RouteOnboarding3
@Serializable object RouteLogin
@Serializable object RouteRegister

@Serializable object RoutePersonalization1
@Serializable object RoutePersonalization2
@Serializable object RoutePersonalization3
@Serializable object RouteMainScreen
@Serializable object RouteHomeScreen
@Serializable object  RoutePlantDetailScreen

@Serializable object RouteEditScreen
@Serializable object RouteOrderTrackScreen


@Composable
fun AppNavigation(){
    val navController = rememberNavController();

    NavHost(navController = navController, startDestination = RouteOnboarding1){
        composable<RouteOnboarding1> {
            LaunchedEffect(Unit) {
                delay(2000)
                navController.navigate(RouteOnboarding2){
                    popUpTo<RouteOnboarding1> {inclusive=true}
                }
            }

            onboarding1()
        }
        composable<RouteOnboarding2>{
                onboarding2(
                    onNextClick = {navController.navigate(RouteOnboarding3)},
                    onSkipClick = {
                        navController.navigate(RouteLogin){
                            popUpTo(RouteOnboarding1){inclusive=true}
                        }
                    }
                )
        }
        composable<RouteOnboarding3> {
            onboarding3(
                onFinishClick = {
                    navController.navigate(RouteLogin){
                        popUpTo(RouteOnboarding1){inclusive=true}
                    }
                },
                onSkipClick = {
                    navController.navigate(RouteLogin){
                        popUpTo(RouteOnboarding1){inclusive=true}
                    }
                },
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        composable<RouteLogin>{
            LoginScreen(
                onRegisterClick = {navController.navigate(RouteRegister)},
                onSubmitClick = {
                    navController.navigate(RoutePersonalization1){
                        popUpTo(RouteLogin){inclusive=true}
                    }
                }
            )
        }

        composable<RouteRegister>{
            RegisterScreen(
                onBackClick = {navController.popBackStack()},
                onLoginClick = {navController.navigate(RouteLogin)}
            )
        }

        composable<RoutePersonalization1> {
            Personalization1(
                onNextClick = {navController.navigate(RoutePersonalization2)},
                onSkipClick = {navController.navigate(RouteMainScreen){
                    popUpTo(RoutePersonalization1){inclusive=true}
                } },
                onBackClick = {navController.popBackStack()}
            )
        }

        composable<RoutePersonalization2> {
            Personalization2(
                onNextClick = {navController.navigate(RoutePersonalization3)},
                onSkipClick = {navController.navigate(RouteMainScreen){
                    popUpTo(RoutePersonalization2){inclusive=true}
                } },
                onBackClick = {navController.popBackStack()}
            )
        }

        composable<RoutePersonalization3> {
            Personalization3(
                onNextClick = {navController.navigate(RouteMainScreen){
                    popUpTo(RoutePersonalization3){inclusive=true}
                }},
                onSkipClick = {navController.navigate(RouteMainScreen){
                    popUpTo(RoutePersonalization3){inclusive=true}
                }},
                onBackClick = {navController.popBackStack()}
            )
        }

        composable<RouteMainScreen> {
            MainScreen(
                onNavigateToDetail = {navController.navigate(RoutePlantDetailScreen)},
                onEditingPage = {navController.navigate(RouteEditScreen)}
            )
        }

        composable<RoutePlantDetailScreen>{
            LamanTamanScreen(
                onBackClick = {navController.popBackStack()}
            )
        }

        composable<RouteEditScreen> { EditProfilScreen(
            onBackClick = {navController.popBackStack()},
            onCheckingOrder = {navController.navigate(RouteOrderTrackScreen)}

        ) }

        composable<RouteOrderTrackScreen> { StatusPesananScreen() }
    }
}