package com.example.mvvmapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mvvmapp.ui.screens.ItemDetailScreen
import com.example.mvvmapp.ui.screens.ItemListScreen
import com.example.mvvmapp.ui.theme.MvvmappTheme
import com.example.mvvmapp.viewmodel.ItemViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ItemViewModel()
        enableEdgeToEdge()
        setContent {
            MvvmappTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppNavigation(viewModel)

                }
            }
        }
    }
}

@Composable
fun AppNavigation(viewModel: ItemViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "itemList") {
        composable("itemList") {
            ItemListScreen(navController, viewModel)
        }
        composable("itemDetail/{itemId}") { backStackEntry ->
            ItemDetailScreen(navController, viewModel)
        }
    }
}