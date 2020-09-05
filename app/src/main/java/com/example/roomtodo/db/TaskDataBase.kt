package com.example.roomtodo.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

private const val  DATA_BASE_NAME= "task_db"

@Database(entities = [Task::class], version = 1)
abstract class TaskDataBase : RoomDatabase() {

    abstract fun getTaskDao(): TaskDao

    companion object {

        @Volatile
        private var INSTANCE: TaskDataBase? = null

        fun getDataBase(context: Context): TaskDataBase {
            val tempInstance = INSTANCE
            if(tempInstance !=null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(context,
                    TaskDataBase::class.java,
                     DATA_BASE_NAME
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}