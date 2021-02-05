package com.example.shoppinglist

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.data.Product

class ProductsListAdapter( var products: MutableList<Product>) :
    RecyclerView.Adapter<ProductsListAdapter.ViewHolder>() {


    fun addProduct(){
        notifyDataSetChanged()
        Log.d("Log","Adapter addProduct() "+products.size.toString())
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var checkBoxBought: CheckBox= view.findViewById(R.id.checkBoxBought)
        val textView: TextView = view.findViewById(R.id.product_name)
        val buttonDelete: Button = view.findViewById(R.id.button_delete)

    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.products_list_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.textView.text = products[position].name
    }


    override fun getItemCount() = products.size

}