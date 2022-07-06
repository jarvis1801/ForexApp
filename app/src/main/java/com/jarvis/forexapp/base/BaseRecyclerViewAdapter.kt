package com.jarvis.forexapp.base

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerViewAdapter : RecyclerView.Adapter<BaseViewHolder>() {
    private var dataList = arrayListOf<Any>()

    override fun getItemCount(): Int = dataList.size

    fun submitList(newDataList: ArrayList<Any>) {
        val diffResult = DiffUtil.calculateDiff(DiffCallback(dataList, newDataList))
        diffResult.dispatchUpdatesTo(this)
        dataList = newDataList
    }
}

class DiffCallback(private val oldDataList: ArrayList<Any>, private val newDataList: ArrayList<Any>) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldDataList.size

    override fun getNewListSize(): Int = newDataList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldDataList[oldItemPosition]
        val newItem = newDataList[newItemPosition]

        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return areItemsTheSame(oldItemPosition, newItemPosition)
    }

}