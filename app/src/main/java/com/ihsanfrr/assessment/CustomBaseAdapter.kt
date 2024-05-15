package com.ihsanfrr.assessment

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomBaseAdapter(
    context: Context,
    private val foodNames: Array<String>,
    private val countries: Array<String>,
    private val images: IntArray
) : BaseAdapter() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun getCount(): Int {
        return foodNames.size
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = inflater.inflate(R.layout.activity_custom_list_view, parent, false)

        val textName: TextView = view.findViewById(R.id.foodName)
        val countryName: TextView = view.findViewById(R.id.countryName)
        val image: ImageView = view.findViewById(R.id.foodImage)

        textName.text = foodNames[position]
        countryName.text = countries[position]
        image.setImageResource(images[position])

        return view
    }
}

