package com.khalid.todolist.edittasks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.khalid.todolist.datalayer.TasksRepository
import com.khalid.todolist.datalayer.data.DataModel
import kotlinx.coroutines.launch

class EditTasksViewModel(val repository: TasksRepository):ViewModel() {





    fun editTasks(dataModel: DataModel){
        viewModelScope.launch {
            repository.editTask(dataModel)
        }
    }
    private fun getEditTaskEntry(
        title: String,
        description: String,
        date: String,
        id: Int
    ): DataModel {
        return DataModel(
            title = title,
            description = description,
            datetask = date,
            id = id
        )

    }

    fun editNewProduct(

        title: String,
        description: String,
        date: String,
        id: Int
    ) {
        val newTask = getEditTaskEntry(title, description, date , id)
        editTasks(newTask)

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