package study.rtvx.finalstudyappkypcov

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val itemList: List<ItemList>): RecyclerView.Adapter<Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val itemListView =LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return Holder(itemListView)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val itemListView=itemList[position]
        holder.bind(itemListView)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}