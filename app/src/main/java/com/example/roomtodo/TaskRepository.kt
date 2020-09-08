package com.example.roomtodo

import androidx.lifecycle.LiveData
import com.example.roomtodo.db.Task
import com.example.roomtodo.db.TaskDao

class TaskRepository(private val mTaskDao: TaskDao) {

    // Este value va a contener todos los datos de la BBDD
    val listAllTask: LiveData<List<Task>> = mTaskDao.getAllTaskFromDb()

    // Esta funcion va a insertar la info
    suspend fun insertTask(mTask: Task){
       mTaskDao.insertOneTask(mTask)
    }

    // Esta funcion delete all

    suspend fun deleteAll(){
        mTaskDao.deleteAllTask()
    }

}