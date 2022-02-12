package com.khalid.todolist.datalayer.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
@Dao
interface TasksDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(taskLocalDataBase: DataModel)

//    @Query("SELECT * FROM datamodel")
//    fun getAllTask(): LiveData<List<DataModel>>
}