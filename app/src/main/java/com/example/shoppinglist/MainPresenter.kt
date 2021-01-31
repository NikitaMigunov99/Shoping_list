package com.example.shoppinglist


import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class MainPresenter(): MvpPresenter<MainView>() {

    var products= mutableListOf<String>()


    fun addProduct(product: String){
        products.add(product)
    }

}