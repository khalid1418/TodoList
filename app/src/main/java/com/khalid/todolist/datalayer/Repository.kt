package com.khalid.todolist.datalayer

import com.khalid.todolist.datalayer.data.DataModel

interface Repository {
    suspend fun addTask(task:DataModel)

}