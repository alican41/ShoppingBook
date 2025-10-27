package com.alica.shoppingbook.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alica.shoppingbook.model.Item

@Database(entities = [Item::class], version = 1)
abstract class ItemDatabase : RoomDatabase(){
    abstract fun itemDao() : ItemDao
}