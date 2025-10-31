package com.example.markssemestermanagement.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.markssemestermanagement.R
import com.example.markssemestermanagement.adapters.AchievementAdapter
import com.example.markssemestermanagement.models.Achievement
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.recyclerview.widget.RecyclerView

class AchievementActivity : AppCompatActivity() {

    private lateinit var recyclerAchievements: RecyclerView
    private lateinit var fabAddAchievement: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_achievements)

        recyclerAchievements = findViewById(R.id.recyclerAchievements)
        fabAddAchievement = findViewById(R.id.fabAddAchievement)

        val achievements = listOf(
            Achievement("Won Coding Competition", "Academic"),
            Achievement("Football Championship", "Sports"),
            Achievement("Volunteered at Tech Fest", "Other")
        )

        recyclerAchievements.layoutManager = LinearLayoutManager(this)
        recyclerAchievements.adapter = AchievementAdapter(achievements)

        fabAddAchievement.setOnClickListener {
            // TODO: Implement Add Achievement Dialog or Activity
        }
    }
}
