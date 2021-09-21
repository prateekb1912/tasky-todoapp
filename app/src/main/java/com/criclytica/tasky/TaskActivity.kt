package com.criclytica.tasky

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_task.*
import java.util.*

const val DB_NAME = "todo.db"
class TaskActivity : AppCompatActivity() {

    lateinit var calendar: Calendar
    lateinit var dateSetListener:DatePickerDialog.OnDateSetListener

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

        dateEdt.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.dateEdt -> {
                setListener()
            }
        }
    }

    private fun setListener() {
        calendar = Calendar.getInstance()
        dateSetListener = DatePickerDialog.OnDateSetListener{ datePicker: DatePicker, year: Int, month: Int, day: Int ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, day)
        }

        val datePickerDialog
    }
}