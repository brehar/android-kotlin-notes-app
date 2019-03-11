package me.bretthartman.notes.views

import android.content.Context
import android.graphics.Paint
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.LayoutInflater
import kotlinx.android.synthetic.main.item_task.view.*
import me.bretthartman.notes.R
import me.bretthartman.notes.models.Task

class TaskView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 1) :
    ConstraintLayout(context, attrs, defStyleAttr) {
    private lateinit var task: Task

    fun initView(task: Task) {
        this.task = task
        titleView.text = task.title

        task.todos.forEach { todo ->
            val todoView =
                (LayoutInflater.from(context).inflate(R.layout.view_todo, todoContainer, false) as TodoView).apply {
                    initView(todo) {
                        if (isTaskComplete()) createStrikeThru()
                        else removeStrikeThru()
                    }
                }

            todoContainer.addView(todoView)
        }
    }

    private fun isTaskComplete(): Boolean = task.todos.none { !it.isComplete }

    private fun createStrikeThru() {
        titleView.apply {
            paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }
    }

    private fun removeStrikeThru() {
        titleView.apply {
            paintFlags = paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
    }
}
