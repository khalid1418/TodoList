package com.khalid.todolist.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.khalid.todolist.addtasks.AddViewModel
import com.khalid.todolist.datalayer.TasksRepository
import java.lang.IllegalArgumentException

class ViewModelFactory(val repository: TasksRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(AddViewModel::class.java) -> {

                @Suppress("UNCHECKED_CAST")

                return AddViewModel(repository) as T
            }
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}