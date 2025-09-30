package com.example.quizapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : Activity() {

    private lateinit var tvQuestion: TextView
    private lateinit var btnTrue: Button
    private lateinit var btnFalse: Button

    // Lista de preguntas: Pair(pregunta, respuestaCorrecta)
    private val questions = listOf(
        Pair("¿Android Studio es un IDE para desarrollar aplicaciones Android?", true),
        Pair("¿Kotlin es un lenguaje que se puede usar en Android?", true),
        Pair("¿Un Activity puede ejecutarse sin manifest?", false),
        Pair("¿Toast muestra mensajes emergentes en pantalla?", true),
        Pair("¿Todas las apps Android son proyectos web?", false)
    )

    private var currentIndex = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvQuestion = findViewById(R.id.tvQuestion)
        btnTrue = findViewById(R.id.btnTrue)
        btnFalse = findViewById(R.id.btnFalse)

        // Mostrar la primera pregunta
        showQuestion()

        btnTrue.setOnClickListener {
            checkAnswer(true)
        }

        btnFalse.setOnClickListener {
            checkAnswer(false)
        }
    }

    private fun showQuestion() {
        if (currentIndex < questions.size) {
            val (text, _) = questions[currentIndex]
            tvQuestion.text = text
        } else {
            finishQuiz()
        }
    }

    private fun checkAnswer(userAnswer: Boolean) {
        if (currentIndex >= questions.size) return

        val correct = questions[currentIndex].second
        if (userAnswer == correct) {
            score += 1
            Toast.makeText(this, getString(R.string.toast_correct), Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, getString(R.string.toast_incorrect), Toast.LENGTH_SHORT).show()
        }

        // Avanzar a la siguiente pregunta
        currentIndex += 1
        if (currentIndex < questions.size) {
            showQuestion()
        } else {
            finishQuiz()
        }
    }

    private fun finishQuiz() {
        // Abrir ResultActivity mostrando el puntaje
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("score", score)
        intent.putExtra("total", questions.size)
        startActivity(intent)
        finish()
    }
}

