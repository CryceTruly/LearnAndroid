package com.crycetruly.notekeeper;

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView;
import com.crycetruly.notekeeper.model.NoteInfo

class NoteRecyclerAdapter(public val  context: Context,private val notes:List<NoteInfo>):

     RecyclerView.Adapter<NoteRecyclerAdapter.ItemViewHolder>(){

      override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
          val layoutInflater= LayoutInflater.from(context)
          val view=layoutInflater.inflate(R.layout.item_note_list,parent,false)
          return ItemViewHolder(view)

         }

     override fun getItemCount() = notes.size

     override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
     val note=notes.get(position)
         holder.textcourse.text=note.text
         holder.titlecourse.text=note.title
         holder.notePosition=position



      }


    inner  class ItemViewHolder(itemView:View) :RecyclerView.ViewHolder(itemView){
         val textcourse=itemView.findViewById<TextView>(R.id.noteText)
         val titlecourse=itemView.findViewById<TextView>(R.id.noteTitle)
         val spinnercourse=itemView.findViewById<Spinner>(R.id.cousesSpinner)

         var notePosition=0


         init {
                itemView.setOnClickListener{
                    val intent=Intent(context,MainActivity::class.java)
                    intent.putExtra(POSITION,notePosition)
                    context.startActivity(intent)
                }
             }
             }

}
