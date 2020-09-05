package com.example.roomtodo

import com.example.roomtodo.db.Task
import com.example.roomtodo.db.TaskDao

class TaskRepository(private val mTaskDao: TaskDao) {

    val listAllTask: List<Task> = mTaskDao.getAllTaskFromDb()

    fun insertTask(mTask: Task){
       mTaskDao.insertOneTask(mTask)
    }

}