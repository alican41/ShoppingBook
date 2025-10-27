package com.alica.shoppingbook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
// Box ve Scaffold importları kaldırıldı
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.LaunchedEffect // <- YENİ IMPORT
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.alica.shoppingbook.screens.AddItemScreen
import com.alica.shoppingbook.screens.DetailScreen
import com.alica.shoppingbook.screens.ItemList
import com.alica.shoppingbook.ui.theme.ShoppingBookTheme
import com.alica.shoppingbook.viewmodel.ItemViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: ItemViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            ShoppingBookTheme {
                // Scaffold ve Box buradan kaldırıldı. Her ekran kendi Scaffold'unu yönetecek.
                NavHost(
                    modifier = Modifier.fillMaxSize(), // NavHost'un tam ekranı kaplaması sağlandı
                    navController = navController,
                    startDestination = "list_screen"
                ) {
                    composable("list_screen") {
                        // LaunchedEffect eklendi
                        LaunchedEffect(Unit) {
                            viewModel.getItemList()
                        }
                        val itemList by remember {
                            viewModel.itemList
                        }
                        ItemList(itemList = itemList, navController = navController)
                    }

                    composable("add_item_screen") {
                        // HATA BURADAYDI: AddItemScreen'e navController eklendi
                        AddItemScreen(navController = navController) { item ->
                            viewModel.saveItem(item)
                            navController.popBackStack() // Geri dön
                        }
                    }

                    composable(
                        "details_screen/{itemId}",
                        arguments = listOf(
                            navArgument("itemId") {
                                type = NavType.StringType
                            }
                        )
                    ) {
                        val itemIdString = remember {
                            it.arguments?.getString("itemId")
                        }

                        // LaunchedEffect eklendi
                        LaunchedEffect(itemIdString) {
                            viewModel.getItem(itemIdString?.toIntOrNull() ?: 0)
                        }

                        val selectedItem by remember {
                            viewModel.selectedItem
                        }

                        // HATA BURADAYDI: DetailScreen'e navController eklendi
                        DetailScreen(
                            item = selectedItem,
                            navController = navController
                        ) {
                            viewModel.deleteItem(selectedItem)
                            navController.popBackStack() // Geri dön
                        }
                    }
                }
            }
        }
    }
}