package com.phstudio.freetv.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.phstudio.freetv.R

internal class ItemAdapter(
    private var itemList: ArrayList<Triple<String, Int, String>>,
    private val listener: OnItemClickListener,
    private val longClickListener: OnItemLongClickListener
) :
    RecyclerView.Adapter<ItemAdapter.MyViewHolder>() {
    private fun splitList(newsList: ArrayList<Triple<String, Int, String>>): Triple<ArrayList<String>, ArrayList<Int>, ArrayList<String>> {
        val stringList1 = ArrayList<String>()
        val intList = ArrayList<Int>()
        val stringList2 = ArrayList<String>()

        for (pair in newsList) {
            stringList1.add(pair.first)
            intList.add(pair.second)
            stringList2.add(pair.third)
        }
        return Triple(stringList1, intList, stringList2)
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    interface OnItemLongClickListener {
        fun onItemLongClick(position: Int): Boolean
    }

    internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var btItem: Button = view.findViewById(R.id.btItem)

        init {
            btItem.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

        init {
            btItem.setOnLongClickListener {
                longClickListener.onItemLongClick(position)
                true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_button, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            listener.onItemClick(position)
        }

        holder.itemView.setOnLongClickListener {
            longClickListener.onItemLongClick(position)
        }
        val (stringList1, intList, _) = splitList(itemList)

        val text = stringList1[position]
        val icon = intList[position]
        holder.btItem.text = text
        holder.btItem.isFocusable = true
        holder.btItem.isClickable = true

        holder.btItem.setCompoundDrawablesWithIntrinsicBounds(icon, 0, 0, 0)

    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}
