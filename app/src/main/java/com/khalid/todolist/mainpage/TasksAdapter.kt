package com.khalid.todolist.mainpage

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.khalid.todolist.R
import com.khalid.todolist.databinding.FragmentTasksBinding
import com.khalid.todolist.databinding.MyListBinding
import com.khalid.todolist.datalayer.data.DataModel

class TasksAdapter(private val onItemClicked:(DataModel) -> Unit) :
ListAdapter<DataModel, TasksAdapter.TasksViewHolder>(DiffCallback) {


    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<DataModel>() {
            override fun areItemsTheSame(
                oldItem: DataModel,
                newItem: DataModel
            ): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(
                oldItem: DataModel,
                newItem: DataModel
            ): Boolean {
                return oldItem.id == newItem.id

            }

        }
    }

    class TasksViewHolder(private val binding: MyListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(dataModel: DataModel) {
            binding.apply {
                title.text = dataModel.title
                description.text = dataModel.description
                date.text = dataModel.datetask

                Log.e("TAG", "bind:${dataModel.title} ")

            }

        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TasksViewHolder {
        return TasksViewHolder(
            MyListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: TasksViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current)
        Log.e("TAG", "onBindViewHolder: ${current.title}", )
        holder.itemView.setOnClickListener{
            onItemClicked(current)
        }

    }
}
