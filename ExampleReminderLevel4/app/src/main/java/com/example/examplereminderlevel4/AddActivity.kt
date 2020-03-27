package com.example.examplereminderlevel4

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add.*

const val EXTRA_REMINDER = "EXTRA_REMINDER"

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        setSupportActionBar(tbAdd)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // Enable up button

        initViews()
    }


    private fun initViews() { fabSave.setOnClickListener{ onSaveClick() } }


    private fun onSaveClick() {
        if (etReminder.text.toString().isNotBlank()) {
            val reminder = Reminder(etReminder.text.toString())
            val resultIntent = Intent()

            resultIntent.putExtra(EXTRA_REMINDER, reminder)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()

        } else Toast.makeText(this,"The reminder cannot be empty", Toast.LENGTH_SHORT).show()
    }
}
