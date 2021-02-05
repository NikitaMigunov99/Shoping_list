package com.example.shoppinglist

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import moxy.ktx.moxyPresenter
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.data.Product
import kotlinx.android.synthetic.main.activity_main.*
import moxy.MvpAppCompatActivity

class MainActivity : MvpAppCompatActivity(), MainView {


    lateinit var productsList: RecyclerView
    lateinit var editText: EditText


    private val presenter by moxyPresenter {MainPresenter(this, this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        productsList= findViewById(R.id.products_list)
        productsList.adapter= presenter.adapter
        editText= findViewById(R.id.editText)

        val buttonAdd= button_add
        buttonAdd.setOnClickListener {
            addProduct()
        }

    }

    override fun addProduct() {
        presenter.addProduct(editText.text.toString())
    }

    override fun onPause() {
        super.onPause()
        Log.d("Log","onPause size="+presenter.products.size.toString())
    }

}