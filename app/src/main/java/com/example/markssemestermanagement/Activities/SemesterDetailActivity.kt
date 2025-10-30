package com.example.markssemestermanagement.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.markssemestermanagement.MainActivity
import com.example.markssemestermanagement.R
import com.example.markssemestermanagement.adapter.SubjectAdapter
import com.example.markssemestermanagement.model.Semester

class SemesterDetailActivity : AppCompatActivity() {

    private lateinit var recyclerViewSubjects: RecyclerView
    private lateinit var gpaText: TextView
    private lateinit var btnEdit: Button
    private lateinit var btnDelete: Button
    private lateinit var btnExportPDF: Button

    private lateinit var semester: Semester
    private lateinit var subjectAdapter: SubjectAdapter
    private var semesterIndex = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_semester_detail)

        recyclerViewSubjects = findViewById(R.id.recyclerViewSubjects)
        gpaText = findViewById(R.id.gpaText)
        btnEdit = findViewById(R.id.btnEdit)
        btnDelete = findViewById(R.id.btnDelete)
        btnExportPDF = findViewById(R.id.btnExportPDF)

        // Get semester index from intent
        semesterIndex = intent.getIntExtra("semesterIndex", -1)
        if (semesterIndex != -1) {
            semester = MainActivity.semesters[semesterIndex]
        } else finish()

        // Setup RecyclerView
        subjectAdapter = SubjectAdapter(semester.subjects)
        recyclerViewSubjects.layoutManager = LinearLayoutManager(this)
        recyclerViewSubjects.adapter = subjectAdapter

        // Show GPA
        gpaText.text = "GPA: %.2f".format(semester.calculateGPA())

        // Button listeners
        btnEdit.setOnClickListener {
            // TODO: Open AddSemesterActivity in edit mode
        }

        btnDelete.setOnClickListener {
            MainActivity.semesters.removeAt(semesterIndex)
            finish()
        }

        btnExportPDF.setOnClickListener {
            // TODO: Implement PDF export
        }
    }
}
