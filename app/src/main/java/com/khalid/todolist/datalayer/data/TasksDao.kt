package com.khalid.todolist.datalayer.data

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TasksDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(taskLocalDataBase: DataModel)

    @Query("SELECT * FROM datamodel")
    fun getAllTask(): Flow<List<DataModel>?>?

@Update
suspend fun update(taskLocalDataBase: DataModel)

@Delete
suspend fun delete(taskLocalDataBase: DataModel)
}