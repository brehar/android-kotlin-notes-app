package me.bretthartman.notes.foundations

import android.support.v7.widget.RecyclerView
import android.view.View

abstract class BaseRecyclerAdapter<T>(protected val itemList: MutableList<T> = mutableListOf()) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemCount(): Int = itemList.size

    @Suppress("UNCHECKED_CAST")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
        (holder as BaseViewHolder<T>).onBind(itemList[position])

    abstract class BaseViewHolder<E>(val view: View) : RecyclerView.ViewHolder(view) {
        abstract fun onBind(data: E)
    }
}
