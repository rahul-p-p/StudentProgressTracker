package com.example.markssemestermanagement.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.markssemestermanagement.R
import com.example.markssemestermanagement.models.Skill

class SkillAdapter(private val skills: List<Skill>) :
    RecyclerView.Adapter<SkillAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.tvSkillName)
        val progress: ProgressBar = view.findViewById(R.id.progressSkill)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_skill, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val skill = skills[position]
        holder.name.text = skill.name
        holder.progress.progress = skill.proficiency
    }

    override fun getItemCount(): Int = skills.size
}
