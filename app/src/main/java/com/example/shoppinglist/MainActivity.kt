package com.example.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import moxy.ktx.moxyPresenter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import moxy.MvpAppCompatActivity

class MainActivity : MvpAppCompatActivity(), MainView {


    lateinit var productsList: RecyclerView
    lateinit var adapter:ProductsListAdapter
    lateinit var editText: EditText




    private val presenter by moxyPresenter {MainPresenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        adapter= ProductsListAdapter(presenter.products)
        productsList= findViewById(R.id.products_list)

        productsList.adapter= adapter

        editText= findViewById(R.id.editText)

        val buttonAdd= button_add
        buttonAdd.setOnClickListener {
            addProduct()
        }

    }

    override fun addProduct() {
        presenter.addProduct(editText.text.toString())
        adapter.addProduct(editText.text.toString())
    }


}