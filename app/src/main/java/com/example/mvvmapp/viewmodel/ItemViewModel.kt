package com.example.mvvmapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmapp.data.Item
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ItemViewModel : ViewModel() {
    private val _items = MutableStateFlow<List<Item>>(emptyList())
    val items: StateFlow<List<Item>> = _items

    private val _selectedItem = MutableStateFlow<Item?>(null)
    val selectedItem: StateFlow<Item?> = _selectedItem

    init {
        fetchItems()
    }

    private fun fetchItems() {
        viewModelScope.launch {
            delay(1000)
            val dummyItems = listOf(
                Item(1, "Item 1", "Description for item 1"),
                Item(2, "Item 2", "Description for item 2"),
                Item(3, "Item 3", "Description for item 3")
            )
            _items.value = dummyItems
        }
    }

    fun fetchItemDetails(itemId: Int) {
        viewModelScope.launch {
            delay(500)
            val item = _items.value.find { it.id == itemId }
            _selectedItem.value = item
        }
    }
}