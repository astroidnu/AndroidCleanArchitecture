package com.scoproject.androidcleanarchitecture.external

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup

abstract class AbstractAdapter<ITEM> constructor(protected var itemList: List<ITEM>
                                                 , private val layoutResId: Int)
    : RecyclerView.Adapter<AbstractAdapter.Holder>() {

    init {
        update(itemList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = parent inflate layoutResId
        val viewHolder = Holder(view)
        val itemView = viewHolder.itemView
        itemView.tag = viewHolder
        itemView.setOnClickListener {
            val adapterPositon = viewHolder.adapterPosition
            if (adapterPositon != RecyclerView.NO_POSITION) {
                onItemClick(itemView, adapterPositon)
            }
        }

        return viewHolder
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = itemList[position]
        if (holder != null) {
            holder.itemView.bind(item)
        }
    }

    override fun onViewRecycled(holder: Holder) {
        super.onViewRecycled(holder)
        if (holder != null) {
            onViewRecycled(holder.itemView)
        }
    }

    fun update(items: List<ITEM>) {
        updateAdapterWithDiffResult(calculateDiff(items))
    }

    private fun updateAdapterWithDiffResult(result: DiffUtil.DiffResult) {
        result.dispatchUpdatesTo(this)
    }

    private fun calculateDiff(newItems: List<ITEM>): DiffUtil.DiffResult {
        return DiffUtil.calculateDiff(DiffUtilCallback(itemList, newItems))
    }

    fun add(item: ITEM) {
        itemList.toMutableList().add(item)
        notifyItemInserted(itemList.size)
    }

    fun remove(position: Int) {
        itemList.toMutableList().removeAt(position)
        notifyItemRemoved(position)
    }

    protected open fun View.bind(item: ITEM) {}

    protected open fun onViewRecycled(itemView: View) {}

    protected open fun onItemClick(itemView: View, position: Int) {}

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView)
}