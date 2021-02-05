package com.example.shoppinglist


import android.content.Context
import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.example.shoppinglist.data.Product
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class MainPresenter(lifecycleOwner: LifecycleOwner, context: Context): MvpPresenter<MainView>() {

    var products= mutableListOf<Product>()
    var adapter= ProductsListAdapter(products)
    var repository= Repository(context)
    var isDataLoaded= false
    //var data: LiveData<List<Product>>?=null
    val mLifecycleOwner: LifecycleOwner

    init {
        mLifecycleOwner= lifecycleOwner
    }

    fun addProduct(name: String){
        val product= Product(name)
        products.add(product)
        adapter.notifyDataSetChanged()
        repository.addProduct(product)
        Log.d("Log","MainPresenter addProduct "+products.size.toString())
    }

    override fun onFirstViewAttach(){
        super.onFirstViewAttach()
        getLocalData()
        Log.d("onFirstViewAttach","onFirstViewAttach "+products.size.toString())
    }

    private fun getLocalData() {

        if (!isDataLoaded) {
            val data = repository.getData()
            data!!.observe(mLifecycleOwner, Observer { list ->
                products.addAll(list)
                adapter.notifyDataSetChanged()
            })


            Log.d("Debug", "Repository getData() Size ")
        }
    }
}
