package com.dev_ankur.infoappmvvm.navigation


import DetailsScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Banner screen") {
        composable("Banner screen") {
            BannerScreen(navController = navController)
        }
        composable("Home screen") {
            HomeScreen(navController = navController)
        }

        composable(
            route = "Details screen/{id}/{name}/{gender}/{encodedAvatarUrl}/{species}/{status}",
            arguments = listOf(
                navArgument("id") { type = NavType.IntType },
                navArgument("name") { type = NavType.StringType },
                navArgument("gender") { type = NavType.StringType },
                navArgument("encodedAvatarUrl") { type = NavType.StringType },
                navArgument("species") { type = NavType.StringType },
                navArgument("status") { type = NavType.StringType },
            )
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id")
            val name = backStackEntry.arguments?.getString("name")
            val gender = backStackEntry.arguments?.getString("gender")
            val encodedAvatarUrl = backStackEntry.arguments?.getString("encodedAvatarUrl")
            val species = backStackEntry.arguments?.getString("species")
            val status = backStackEntry.arguments?.getString("status")



            if (id != null && name != null && gender != null && encodedAvatarUrl!=null && species!=null  && status!=null) {
                DetailsScreen(id = id, name = name, gender = gender,encodedAvatarUrl = encodedAvatarUrl,species = species, status = status)
            }
        }

    }
}




