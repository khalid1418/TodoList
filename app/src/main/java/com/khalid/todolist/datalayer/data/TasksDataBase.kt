package com.khalid.todolist.datalayer.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [DataModel::class] , version = 1 , exportSchema = false)
abstract class TasksDataBase:RoomDatabase() {
    abstract fun taskDao():TasksDao


    companion object{
        @Volatile
        private var INSTANCE:TasksDataBase? = null
        fun getDataBase(context: Context):TasksDataBase{
            return INSTANCE?: synchronized(this){
                val instance= Room.databaseBuilder(
                    context.applicationContext , TasksDataBase::class.java , "task_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE=instance
                return instance
            }
        }
    }
}