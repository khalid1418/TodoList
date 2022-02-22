package com.khalid.todolist.mainpage

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.khalid.todolist.datalayer.TasksRepository
import com.khalid.todolist.datalayer.data.DataModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TasksViewModel(private val repository: TasksRepository):ViewModel() {

    val _allTasks= MutableStateFlow<List<DataModel>?>(emptyList())
    val allTasks:StateFlow<List<DataModel>?> = _allTasks.asStateFlow()
    val allTasksLiveData = allTasks.asLiveData()



    init {
        getAllTasks()
    }


    fun getAllTasks(){
        viewModelScope.launch {
            repository.getAllTasks()?.collect{ tasks ->
                _allTasks.update { tasks }
            }
        }
    }



}