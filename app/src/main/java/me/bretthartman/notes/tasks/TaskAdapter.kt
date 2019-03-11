package me.bretthartman.notes.tasks

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_task.view.*
import me.bretthartman.notes.R
import me.bretthartman.notes.foundations.BaseRecyclerAdapter
import me.bretthartman.notes.models.Task

class TaskAdapter(taskList: MutableList<Task> = mutableListOf()) : BaseRecyclerAdapter<Task>(taskList) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false))

    class ViewHolder(view: View) : BaseViewHolder<Task>(view) {
        override fun onBind(item: Task) {
            view.titleView.text = item.title
        }
    }
}
