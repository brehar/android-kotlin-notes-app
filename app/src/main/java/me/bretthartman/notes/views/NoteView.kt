package me.bretthartman.notes.views

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import kotlinx.android.synthetic.main.item_note.view.*
import me.bretthartman.notes.models.Note

class NoteView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 1) :
    ConstraintLayout(context, attrs, defStyleAttr) {
    fun initView(note: Note) {
        descriptionView.text = note.description
    }
}
