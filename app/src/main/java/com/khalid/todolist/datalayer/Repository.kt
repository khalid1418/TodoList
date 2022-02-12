package com.khalid.todolist.datalayer

import androidx.lifecycle.LiveData
import com.khalid.todolist.datalayer.data.DataModel
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun addTask(task:DataModel)
    suspend fun getAllTasks():Flow<List<DataModel>?>?

}