package com.khalid.todolist.addtasks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.khalid.todolist.datalayer.TasksRepository
import com.khalid.todolist.datalayer.data.DataModel
import kotlinx.coroutines.launch

class AddViewModel(private val repository: TasksRepository) : ViewModel() {


    fun insert(tasks: DataModel) {
        viewModelScope.launch {
            repository.addTask(tasks)
        }
    }


    private fun getNewTaskEntry(
        title: String,
        description: String,
        date: String,
    ): DataModel {
        return DataModel(
            title = title,
            description = description,
            datetask = date
        )

    }

    fun addNewProduct(
        title: String,
        description: String,
        date: String,
    ) {
        val newTask = getNewTaskEntry(title, description, date)
        insert(newTask)

    }

    fun isEntryValid(
        title: String,
        description: String,
        date: String,
    ): Boolean {
        if (title.isBlank() || description.isBlank() || date.isBlank()) {
            return false
        }
        return true
    }
}