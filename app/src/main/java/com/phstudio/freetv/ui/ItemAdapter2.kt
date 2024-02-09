package com.phstudio.freetv.ui

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.phstudio.freetv.R
import com.squareup.picasso.Picasso

internal class ItemAdapter2(
    private val context: Context,
    private var itemList: ArrayList<Triple<String, String, String>>,
    private val listener: OnItemClickListener,
    private val longClickListener: OnItemLongClickListener
) :
    RecyclerView.Adapter<ItemAdapter2.MyViewHolder>() {
    private fun splitList(newsList: ArrayList<Triple<String, String, String>>): Triple<ArrayList<String>, ArrayList<String>, ArrayList<String>> {
        val stringList1 = ArrayList<String>()
        val intList = ArrayList<String>()
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
            .inflate(R.layout.item_button2, parent, false)
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

        loadInto(icon, holder.btItem)
    }
    private fun loadInto(url: String, button: Button) {
        try {
            Picasso.get().load(url)
                .resize(200, 200)
                .centerInside()
                .into(object : com.squareup.picasso.Target {
                    override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
                        bitmap?.let {
                            val drawable = BitmapDrawable(context.resources, it)
                            button.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null)
                        }
                    }

                    override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {
                        // Handle failed loading here
                    }

                    override fun onPrepareLoad(placeHolderDrawable: Drawable?) {
                        // Handle loading progress here
                    }
                })
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
    override fun getItemCount(): Int {
        return itemList.size
    }
}
