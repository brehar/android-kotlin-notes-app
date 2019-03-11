package me.bretthartman.notes.notes

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_note.view.*
import me.bretthartman.notes.R
import me.bretthartman.notes.foundations.BaseRecyclerAdapter
import me.bretthartman.notes.models.Note

class NoteAdapter(noteList: MutableList<Note> = mutableListOf()) : BaseRecyclerAdapter<Note>(noteList) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false))

    class ViewHolder(view: View) : BaseViewHolder<Note>(view) {
        override fun onBind(item: Note) {
            view.descriptionView.text = item.description
        }
    }
}
