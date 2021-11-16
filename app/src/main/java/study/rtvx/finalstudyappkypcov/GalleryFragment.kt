package study.rtvx.finalstudyappkypcov

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GalleryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val itemList: List<ItemList> = listOf(
            ItemList(R.drawable.edible1,"Ягоды", "Berries"),
            ItemList(R.drawable.edible2,"Крыжовник", "Gooseberry"),
            ItemList(R.drawable.edible3,"Овощи", "Vegetables"),
            ItemList(R.drawable.edible4,"Овощи", "Vegetables"),
            ItemList(R.drawable.edible5,"Фисташки", "Pistachios"),
            ItemList(R.drawable.edible6,"Гретский орех", "Walnut"),
            ItemList(R.drawable.edible7,"Яйцо", "Egg"),
            ItemList(R.drawable.edible8,"Яйцо", "Cheese"),
            ItemList(R.drawable.edible9,"Яблоко", "Apple"),
            ItemList(R.drawable.edible10,"Манго", "Mango"),
            ItemList(R.drawable.inedible1,"Гайка", "Screw"),
            ItemList(R.drawable.inedible2,"Болт", "Bolt"),
            ItemList(R.drawable.inedible3,"Камень", "Stone"),
            ItemList(R.drawable.inedible4,"Золото", "Gold"),
            ItemList(R.drawable.inedible5,"Кружка", "Jar"),
            ItemList(R.drawable.inedible6,"Вилка", "Fork"),
            ItemList(R.drawable.inedible7,"Кресло", "Armchair"),
            ItemList(R.drawable.inedible8,"Мышка", "PC mouse"),
            ItemList(R.drawable.inedible9,"Кирпич", "Brick"),
            ItemList(R.drawable.inedible10,"Книга", "Book")
        )

        val view: View = inflater.inflate(R.layout.fragment_gallery, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = Adapter(itemList)
        recyclerView.addItemDecoration(DividerItemDecoration(context,DividerItemDecoration.VERTICAL))

        return view
    }
}