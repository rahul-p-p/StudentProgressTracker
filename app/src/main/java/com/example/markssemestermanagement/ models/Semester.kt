package com.example.markssemestermanagement.model

data class Semester(
    val name: String,
    val subjects: MutableList<Subject> = mutableListOf()
) {
    fun calculateGPA(): Double {
        if (subjects.isEmpty()) return 0.0
        val total = subjects.sumOf { it.grade }
        return total / subjects.size
    }
}

