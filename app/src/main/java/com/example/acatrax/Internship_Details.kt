package com.example.acatrax

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Internship_Details : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_internship_details)

        showInternshipPopup()
    }

    private fun showInternshipPopup() {
        val dialogView = layoutInflater.inflate(R.layout.activity_internship_details, null)

        val internshipNameEditText = dialogView.findViewById<EditText>(R.id.editTextInternshipName)
        val roleEditText = dialogView.findViewById<EditText>(R.id.editTextRole)
        val dateEditText = dialogView.findViewById<EditText>(R.id.editTextDate)
        val durationEditText = dialogView.findViewById<EditText>(R.id.editTextDuration)
        val mentorEditText = dialogView.findViewById<EditText>(R.id.editTextMentor)
        val workDescriptionEditText = dialogView.findViewById<EditText>(R.id.editTextWorkDescription)
        val uploadButton = dialogView.findViewById<Button>(R.id.buttonUpload)
        val saveButton = dialogView.findViewById<Button>(R.id.buttonSave)

        val dialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .setCancelable(true)
            .create()

        uploadButton.setOnClickListener {
            Toast.makeText(this, "Upload button clicked", Toast.LENGTH_SHORT).show()
            // TODO: Implement file/image picker
        }

        saveButton.setOnClickListener {
            val name = internshipNameEditText.text.toString()
            val role = roleEditText.text.toString()
            val date = dateEditText.text.toString()
            val duration = durationEditText.text.toString()
            val mentor = mentorEditText.text.toString()
            val description = workDescriptionEditText.text.toString()

            Toast.makeText(this, "Saved: $name - $role", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }

        dialog.show()
    }
}
