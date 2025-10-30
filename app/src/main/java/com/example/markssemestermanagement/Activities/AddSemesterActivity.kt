package com.example.markssemestermanagement

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.markssemestermanagement.adapter.SubjectAdapter
import com.example.markssemestermanagement.model.Semester
import com.example.markssemestermanagement.model.Subject
import com.google.android.material.textfield.TextInputEditText

class AddSemesterActivity : AppCompatActivity() {

    private lateinit var etSemesterName: TextInputEditText
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SubjectAdapter
    private val subjects = mutableListOf<Subject>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_semester)

        etSemesterName = findViewById(R.id.editSemesterName)
        recyclerView = findViewById(R.id.recyclerViewSubjects)

        // Initialize SubjectAdapter and RecyclerView
        adapter = SubjectAdapter(subjects)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        // Add new subject
        findViewById<Button>(R.id.btnAddSubject).setOnClickListener {
            subjects.add(Subject("New Subject", 0.0))
            adapter.notifyItemInserted(subjects.size - 1)
        }

        // Save semester
        findViewById<Button>(R.id.btnSaveSemester).setOnClickListener {
            val name = etSemesterName.text.toString()
            if (name.isNotEmpty()) {
                MainActivity.semesters.add(Semester(name, subjects.toMutableList()))
                finish() // close activity and go back to MainActivity
            }
        }
    }
}
