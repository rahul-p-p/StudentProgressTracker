package com.example.markssemestermanagement.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.markssemestermanagement.R
import com.example.markssemestermanagement.activities.SemesterDetailActivity
import com.example.markssemestermanagement.model.Semester

class SemesterAdapter(private val semesters: MutableList<Semester>) :
    RecyclerView.Adapter<SemesterAdapter.SemesterViewHolder>() {

    class SemesterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val semesterName: TextView = itemView.findViewById(R.id.semesterName)
        val gpa: TextView = itemView.findViewById(R.id.gpa)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SemesterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_semester, parent, false)
        return SemesterViewHolder(view)
    }

    override fun onBindViewHolder(holder: SemesterViewHolder, position: Int) {
        val semester = semesters[position]
        holder.semesterName.text = semester.name
        holder.gpa.text = "GPA: %.2f".format(semester.calculateGPA())

        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, SemesterDetailActivity::class.java)
            intent.putExtra("semesterIndex", position)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = semesters.size
}
