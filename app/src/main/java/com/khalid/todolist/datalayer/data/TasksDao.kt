package com.khalid.todolist.datalayer.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TasksDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(taskLocalDataBase: DataModel)

    @Query("SELECT * FROM datamodel")
    fun getAllTask(): Flow<List<DataModel>?>?


}