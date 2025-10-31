package com.example.markssemestermanagement.adapters

    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import android.widget.TextView
    import androidx.recyclerview.widget.RecyclerView
    import com.example.markssemestermanagement.R
    import com.example.markssemestermanagement.models.Achievement

    class AchievementAdapter(private val achievements: List<Achievement>) :
        RecyclerView.Adapter<AchievementAdapter.ViewHolder>() {

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val title: TextView = view.findViewById(R.id.tvAchievementTitle)
            val type: TextView = view.findViewById(R.id.tvAchievementType)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_achievement, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val achievement = achievements[position]
            holder.title.text = achievement.title
            holder.type.text = "Type: ${achievement.type}"
        }

        override fun getItemCount(): Int = achievements.size
    }
