package study.rtvx.finalstudyappkypcov

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    @SuppressLint("UseCompatLoadingForDrawables")
    fun bind(itemList: ItemList) {
        val imgListView: ImageView = itemView.findViewById(R.id.img_list)
        imgListView.setImageDrawable(itemView.context.getDrawable(itemList.imgItem))
        val rusText: TextView = itemView.findViewById(R.id.list_ru)
        rusText.text = itemList.rusItem
        val engText: TextView = itemView.findViewById(R.id.list_eng)
        engText.text = itemList.engItem
    }


}