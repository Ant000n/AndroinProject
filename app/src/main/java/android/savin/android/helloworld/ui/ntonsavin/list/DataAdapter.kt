package android.savin.android.helloworld.ui.ntonsavin.list

import android.savin.android.helloworld.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_data.view.*

class DataAdapter() : RecyclerView.Adapter<DataViewHolder>() {

    val list = arrayListOf<Data>()



//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
//
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_data,parent)
//        return DataViewHolder(view)
//    }
//
//    override fun getItemCount() = list.size
//    }
//
//    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
//
//        val item = list[position]
//        holder.bind(item)
//       }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_data,parent)
       return DataViewHolder(view)    }

    override fun getItemCount() = list.size
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)    }

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private val textId = itemView.item_id
        private val textTitle = itemView.item_title

        fun bund(data: Data) {
            textId.text = data.id.toString()
            textTitle.text = data.title
    }
}