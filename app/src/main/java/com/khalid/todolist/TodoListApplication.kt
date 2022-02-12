package com.khalid.todolist

import android.app.Application
import com.khalid.todolist.datalayer.TasksRepository
import com.khalid.todolist.datalayer.data.TasksDataBase

class TodoListApplication: Application() {
    val database:TasksDataBase by lazy { TasksDataBase.getDataBase(this) }
    val repository by lazy { TasksRepository(database.taskDao()) }
}