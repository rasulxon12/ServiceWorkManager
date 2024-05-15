package uz.akra.service.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.akra.service.databinding.ItemRecViewBinding
import uz.akra.service.models.MyWorkerModel

class MyRvAdapter ( var list: ArrayList<MyWorkerModel> = ArrayList()) :
    RecyclerView.Adapter<MyRvAdapter.Vh>() {


    inner class Vh(val itemRvBinding: ItemRecViewBinding) : RecyclerView.ViewHolder(itemRvBinding.root) {

        fun onBind(myWorkerModel: MyWorkerModel, position: Int) {
            itemRvBinding.tvName.text = myWorkerModel.date

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRecViewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)
    }




}

