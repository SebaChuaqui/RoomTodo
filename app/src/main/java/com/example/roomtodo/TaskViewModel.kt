package com.example.roomtodo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.roomtodo.db.Task
import com.example.roomtodo.db.TaskDataBase
import kotlinx.coroutines.launch

class TaskViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: TaskRepository
    val allTask: LiveData<List<Task>>

    init {
        val taskDao = TaskDataBase.getDataBase(application).getTaskDao()
        repository = TaskRepository(taskDao)
        allTask = repository.listAllTask
    }

    fun insertTask(task: Task) = viewModelScope.launch {
        repository.insertTask(task)
    }

    fun deleteAllTask() = viewModelScope.launch {
        repository.deleteAll()
    }

}