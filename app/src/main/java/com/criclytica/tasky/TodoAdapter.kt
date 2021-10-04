package com.criclytica.tasky

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_task.*
import kotlinx.android.synthetic.main.item_todo.view.*
import java.text.SimpleDateFormat
import java.util.*

class TodoAdapter(val list = List<ToDoModel>):RecyclerView.Adapter<TodoAdapter.TodoViewHolder>(){
    class TodoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bind(toDoModel: ToDoModel) {
            with(itemView) {
                val colors = resources.getIntArray(R.array.color_arr)
                val rand_col = colors[Random().nextInt(colors.size)]

                viewColorTag.setBackgroundColor(rand_col)
                txtShowTitle.text = toDoModel.title
                txtShowTask.text = toDoModel.description
                txtShowCategory.text = toDoModel.category

                updateTime(toDoModel.time)
                updateDate(toDoModel.date)
            }
        }

        private fun updateTime(time: Long) {
            val format = "h:mm a"

            val sdf = SimpleDateFormat(format)
            itemView.txtShowTime.text = sdf.format(Date(time))
        }

        private fun updateDate(date: Long) {
            val format = "EEE, d MMM yyyy"

            val sdf = SimpleDateFormat(format)
            itemView.txtShowDate.text = sdf.format(Date(date))
        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.item_todo, parent, false))
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

}