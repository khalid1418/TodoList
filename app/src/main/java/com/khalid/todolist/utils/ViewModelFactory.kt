package com.khalid.todolist.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.khalid.todolist.addtasks.AddViewModel
import com.khalid.todolist.datalayer.TasksRepository
import com.khalid.todolist.detailtask.DetailViewModel
import com.khalid.todolist.edittasks.EditTasksViewModel
import com.khalid.todolist.mainpage.TasksViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(val repository: TasksRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(AddViewModel::class.java) -> {

                @Suppress("UNCHECKED_CAST")

                return AddViewModel(repository) as T
            }
            modelClass.isAssignableFrom(TasksViewModel::class.java) -> {
                @Suppress("UNCHECKED_CAST")
                return TasksViewModel(repository) as T
            }
            modelClass.isAssignableFrom(EditTasksViewModel::class.java)->{
                @Suppress("UNCHECKED_CAST")
                return EditTasksViewModel(repository) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java)->{
                @Suppress("UNCHECKED_CAST")
                return DetailViewModel(repository) as T
            }

        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}