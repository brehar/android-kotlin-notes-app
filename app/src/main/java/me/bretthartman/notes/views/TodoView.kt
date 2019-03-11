package me.bretthartman.notes.views

import android.content.Context
import android.graphics.Paint
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import kotlinx.android.synthetic.main.view_todo.view.*
import me.bretthartman.notes.models.Todo

class TodoView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 1) :
    ConstraintLayout(context, attrs, defStyleAttr) {
    fun initView(todo: Todo) {
        descriptionView.text = todo.description
        completeCheckBox.isChecked = todo.isComplete

        if (todo.isComplete) createStrikeThru()

        setUpCheckStateListener()
    }

    private fun setUpCheckStateListener() {
        completeCheckBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) createStrikeThru()
            else removeStrikeThru()
        }
    }

    private fun createStrikeThru() {
        descriptionView.apply {
            paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }
    }

    private fun removeStrikeThru() {
        descriptionView.apply {
            paintFlags = paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
    }
}
