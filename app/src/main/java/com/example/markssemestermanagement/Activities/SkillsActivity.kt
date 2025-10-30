package com.example.markssemestermanagement.Activities


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.markssemestermanagement.R
import com.example.markssemestermanagement.adapters.SkillAdapter
import com.example.markssemestermanagement.models.Skill
import com.google.android.material.floatingactionbutton.FloatingActionButton

class SkillsActivity : AppCompatActivity() {

    private lateinit var recyclerSkills: RecyclerView
    private lateinit var fabAddSkill: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skills)

        recyclerSkills = findViewById(R.id.recyclerSkills)
        fabAddSkill = findViewById(R.id.fabAddSkill)

        val skills = listOf(
            Skill("Java", 90),
            Skill("Kotlin", 75),
            Skill("Firebase", 60),
            Skill("Git & GitHub", 80)
        )

        recyclerSkills.layoutManager = LinearLayoutManager(this)
        recyclerSkills.adapter = SkillAdapter(skills)

        fabAddSkill.setOnClickListener {
            // TODO: Show dialog or new activity to add skill
        }
    }
}
