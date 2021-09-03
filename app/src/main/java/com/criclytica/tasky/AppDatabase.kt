package com.criclytica.tasky

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ToDoModel::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

}