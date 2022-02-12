package com.khalid.todolist.datalayer

import android.util.Log
import com.khalid.todolist.datalayer.data.DataModel
import com.khalid.todolist.datalayer.data.TasksDao
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class TasksRepository(private val taskDao: TasksDao?,
                      private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO):Repository {
    override suspend fun addTask(task: DataModel) {
        taskDao?.insert(task)
        Log.e("TAG", "addTask: ${task.id} & ${task.title}", )
    }
}