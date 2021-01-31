package com.example.shoppinglist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductsListAdapter(private var products: MutableList<String>) :
    RecyclerView.Adapter<ProductsListAdapter.ViewHolder>() {


    var productsList= products

    fun addProduct(product: String){
        productsList.add(product)
        notifyDataSetChanged()
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
        viewHolder.textView.text = productsList[position]
    }


    override fun getItemCount() = productsList.size

}