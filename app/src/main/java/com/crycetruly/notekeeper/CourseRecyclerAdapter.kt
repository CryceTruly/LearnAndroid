package com.crycetruly.notekeeper;

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView;
import com.crycetruly.notekeeper.model.CourseInfo
import com.crycetruly.notekeeper.model.NoteInfo

class CourseRecyclerAdapter(public val  context: Context, private val courses:List<CourseInfo>):

     RecyclerView.Adapter<CourseRecyclerAdapter.ItemViewHolder>(){

      override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
          val layoutInflater= LayoutInflater.from(context)
          val view=layoutInflater.inflate(R.layout.item_course_list,parent,false)
          return ItemViewHolder(view)

         }

     override fun getItemCount() = courses.size

     override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
     val note=courses.get(position)
         holder.titlecourse.text=note.title
         holder.notePosition=position



      }


    inner  class ItemViewHolder(itemView:View) :RecyclerView.ViewHolder(itemView){

         val titlecourse=itemView.findViewById<TextView>(R.id.title)

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
