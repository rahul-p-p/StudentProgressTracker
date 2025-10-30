package com.example.markssemestermanagement

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.markssemestermanagement.adapter.SemesterAdapter
import com.example.markssemestermanagement.model.Semester
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {

    companion object {
        // List to hold all semesters
        val semesters = mutableListOf<Semester>()
    }

    private lateinit var semesterAdapter: SemesterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewSemesters)
        val fab: FloatingActionButton = findViewById(R.id.fabAddSemester)

        // Initialize adapter
        semesterAdapter = SemesterAdapter(semesters)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = semesterAdapter

        // FAB click → open AddSemesterActivity
        fab.setOnClickListener {
            val intent = Intent(this, AddSemesterActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        // Refresh RecyclerView when returning from AddSemesterActivity
        semesterAdapter.notifyDataSetChanged()
    }
}
