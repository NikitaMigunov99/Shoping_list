package com.example.shoppinglist

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import com.example.shoppinglist.data.AppDataBase
import com.example.shoppinglist.data.Product
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch


class Repository(context: Context) {

    var appDataBase: AppDataBase?= null
    var data: MutableLiveData<List<Product>> = MutableLiveData()

    init {
        appDataBase= AppDataBase.getInstance(context)
    }

    fun addProduct( product: Product) {
        CoroutineScope(IO).launch {
            appDataBase!!.productDao().insertProduct(product)
        }
    }

    fun getData() : LiveData<List<Product>>? {
        CoroutineScope(IO).launch {
            data.postValue(appDataBase!!.productDao().getAllProducts())
            Log.d("onFirstViewAttach","getData() Repository ")
        }

        return data
    }
}