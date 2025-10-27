package com.alica.shoppingbook.viewmodel

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.alica.shoppingbook.model.Item
import com.alica.shoppingbook.roomdb.ItemDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ItemViewModel(application: Application) : AndroidViewModel(application) {

    private val db = Room.databaseBuilder(
        getApplication(),
        ItemDatabase::class.java, "Items"
    ).build()

    private val itemDao = db.itemDao()

    val itemList = mutableStateOf<List<Item>>(listOf())
    val selectedItem = mutableStateOf<Item>(Item("", "", "", ByteArray(1)))
    val isLoading = mutableStateOf(false) // YENİ

    fun getItemList() {
        viewModelScope.launch(Dispatchers.IO) {
            isLoading.value = true
            itemList.value = itemDao.getItemWithNameAndId()
            isLoading.value = false
        }
    }

    fun getItem(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            isLoading.value = true
            val item = itemDao.getItemById(id)
            item?.let {
                selectedItem.value = it
            }
            isLoading.value = false
        }
    }

    fun saveItem(item: Item) {
        viewModelScope.launch(Dispatchers.IO) {
            itemDao.insert(item)
        }
    }

    fun deleteItem(item: Item) {
        viewModelScope.launch(Dispatchers.IO) {
            itemDao.delete(item)
        }
    }
}