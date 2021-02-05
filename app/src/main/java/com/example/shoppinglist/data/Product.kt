package com.example.shoppinglist.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class Product (@PrimaryKey
                    @ColumnInfo(name = "name") var name: String
                    /*,@ColumnInfo(name = "price") var price: Int*/)
