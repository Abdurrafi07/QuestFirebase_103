package com.example.p9cloudfirebase.ui.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.p9cloudfirebase.ui.View.DestinasiDetail
import com.example.p9cloudfirebase.ui.View.DetailScreen
import com.example.p9cloudfirebase.ui.View.HomeScreen
import com.example.p9cloudfirebase.ui.View.InsertMhsView

@Composable
fun PengelolaHalaman(
    modifier: Modifier,
    navController: NavHostController = rememberNavController()
){
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = Modifier
    ) {
        composable(DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = {
                    navController.navigate(DestinasiInsert.route)
                },
                onDetailClick = { nim ->
                    if (nim.isNotEmpty()){
                        navController.navigate("${DestinasiDetail.route}/$nim")
                    }
                }
            )
        }

        composable(DestinasiInsert.route) {
            InsertMhsView(
                onBack = { navController.popBackStack() },
                onNavigasi = {
                    navController.navigate(DestinasiHome.route)
                }
            )
        }

        composable(
            route = "${DestinasiDetail.route}/{nim}",
            arguments = listOf(navArgument("nim") { type = NavType.StringType })
        ) { backStackEntry ->
            val nim = backStackEntry.arguments?.getString("nim") ?: ""
            DetailScreen(
                nim = nim,
                onBack = {
                    navController.navigate(DestinasiHome.route) {
                        popUpTo(DestinasiHome.route) {
                            inclusive = true
                        }
                    }
                },
                onClick = {
                    navController.navigate("${DestinasiDetail.route}/$nim")
                }
            )
        }
    }
}