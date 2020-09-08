package com.example.roomtodo.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.roomtodo.db.Task

@Dao
interface TaskDao {

    // insertar un objeto en la tabla utilizando suspend en Coroutines
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOneTask(mTask: Task)

    //insertar multiples objetos Task en la tabla
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMultipleTask(mListTask: List<Task>)

    @Update
    fun updateOneTask(mTask: Task)

    @Delete
    fun deleteOneTask(mTask: Task)

    @Query("SELECT * FROM table_task")
    fun getAllTaskFromDb(): LiveData<List<Task>>

    @Query("SELECT * FROM table_task WHERE id=:mId")
    fun getOneTaskByID(mId: Int): Task

    @Query("DELETE FROM table_task")
    suspend fun deleteAllTask()



}