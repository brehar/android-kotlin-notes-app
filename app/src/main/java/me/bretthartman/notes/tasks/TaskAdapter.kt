package me.bretthartman.notes.tasks

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.bretthartman.notes.R
import me.bretthartman.notes.foundations.BaseRecyclerAdapter
import me.bretthartman.notes.models.Task
import me.bretthartman.notes.views.TaskView

class TaskAdapter(taskList: MutableList<Task> = mutableListOf()) : BaseRecyclerAdapter<Task>(taskList) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false))

    class ViewHolder(view: View) : BaseViewHolder<Task>(view) {
        override fun onBind(data: Task) = (view as TaskView).initView(data)
    }
}
