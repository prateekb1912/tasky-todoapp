package com.criclytica.tasky

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room

const val DB_NAME = "todo.db"
class TaskActivity : AppCompatActivity() {

    val db by lazy {
        Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            DB_NAME
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)
    }
}