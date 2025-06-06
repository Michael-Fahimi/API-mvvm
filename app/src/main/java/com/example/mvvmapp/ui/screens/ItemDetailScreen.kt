package com.example.mvvmapp.ui.screens



import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mvvmapp.viewmodel.ItemViewModel

@Composable
fun ItemDetailScreen(
    navController: NavHostController,
    viewModel: ItemViewModel
) {
    val selectedItem by viewModel.selectedItem.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        if (selectedItem == null) {
            CircularProgressIndicator(modifier = Modifier.align(androidx.compose.ui.Alignment.Center))
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = selectedItem!!.name,
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(
                    text = selectedItem!!.description,
                    style = MaterialTheme.typography.bodyLarge
                )
                Button(onClick = { navController.navigateUp() }) {
                    Text("Back")
                }
            }
        }
    }
}