package com.criclytica.tasky

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TodoDao {

    // To insert a new task in our database
    @Insert()
    suspend fun insertTask(toDoModel: ToDoModel): Long

    // To select all unfinished tasks from the database
    @Query("Select * From ToDoModel Where isDone != -1")
    fun getTasks(): LiveData<List<ToDoModel>>

    // To mark a selected task as finished
    @Query("Update ToDoModel Set isDone = 1 Where id=:uid")
    fun finishTask(uid:Long)

    // To delete any selected task
    @Query("Delete From ToDoModel Where id=:uid")
    fun deleteTask(uid: Long)
}