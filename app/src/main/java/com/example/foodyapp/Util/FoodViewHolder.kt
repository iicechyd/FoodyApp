package com.example.foodyapp.Util

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodyapp.R
import com.bumptech.glide.Glide

class FoodViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val imageView = view.findViewById<ImageView>(R.id.ivHouse)
    private val imageViewActionButton = view.findViewById<ImageView>(R.id.ivActionBtn)
    private val textViewHouseDetail = view.findViewById<TextView>(R.id.tvHouseDetail)
    private val textViewPrice = view.findViewById<TextView>(R.id.tvPriceTag)
    private val textViewType = view.findViewById<TextView>(R.id.tvFoodType)

    private val context = view.context

    fun bind(foodItem: FoodItem) {
//        imageView.setImageResource(houseItem.imageId)
        Glide.with(context).load(foodItem.image_url).into(imageView);
        textViewHouseDetail.text = foodItem.location
        textViewPrice.text = foodItem.price
        textViewType.text = foodItem.type

        imageViewActionButton.setOnClickListener {
            var clickedData = GlobalBox.savedFoodListItem.first {
                it.location == foodItem.location
            }
            GlobalBox.selectedFoodItem = clickedData
            GlobalBox.savedBottomNavigation?.setItemSelected(R.id.mapPage)
        }
    }
}