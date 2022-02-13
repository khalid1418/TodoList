package com.khalid.todolist.datalayer

import android.util.Log
import com.khalid.todolist.datalayer.data.DataModel
import com.khalid.todolist.datalayer.data.TasksDao
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow

class TasksRepository(private val taskDao: TasksDao?,
                      private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO):Repository {
    override suspend fun addTask(task: DataModel) {
        taskDao?.insert(task)
    }

    override suspend fun getAllTasks():Flow<List<DataModel>?>?  {
        return taskDao?.getAllTask()
    }


    }


