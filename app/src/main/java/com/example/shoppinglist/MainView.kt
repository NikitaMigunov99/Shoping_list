package com.example.shoppinglist


import moxy.MvpView
import moxy.viewstate.strategy.AddToEndStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndStrategy ::class)
interface MainView: MvpView{
    fun addProduct()

}