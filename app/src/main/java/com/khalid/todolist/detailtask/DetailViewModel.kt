package com.khalid.todolist.detailtask

import android.util.Log
import androidx.lifecycle.*
import com.khalid.todolist.datalayer.TasksRepository
import com.khalid.todolist.datalayer.data.DataModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class DetailViewModel(val repository: TasksRepository) : ViewModel() {

    fun completeTasks(tasks:DataModel){
        viewModelScope.launch {
            repository.completeTasks(tasks)
        }
    }

}