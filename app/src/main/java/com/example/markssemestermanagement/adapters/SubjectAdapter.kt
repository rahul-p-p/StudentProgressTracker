package com.example.markssemestermanagement.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.markssemestermanagement.R
import com.example.markssemestermanagement.model.Subject

class SubjectAdapter(private val subjects: List<Subject>) :
    RecyclerView.Adapter<SubjectAdapter.SubjectViewHolder>() {

    class SubjectViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val subjectName: TextView = itemView.findViewById(R.id.subjectName)
        val subjectGrade: TextView = itemView.findViewById(R.id.subjectGrade)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_subject, parent, false)
        return SubjectViewHolder(view)
    }

    override fun onBindViewHolder(holder: SubjectViewHolder, position: Int) {
        val subject = subjects[position]
        holder.subjectName.text = subject.name
        holder.subjectGrade.text = subject.grade.toString()
    }

    override fun getItemCount(): Int = subjects.size
}
