package com.example.quizapp

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : Activity() {

    private lateinit var tvQuestion: TextView
    private lateinit var btnTrue: Button
    private lateinit var btnFalse: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Vincular vistas (asegúrate de que activity_main.xml tiene estos ids)
        tvQuestion = findViewById(R.id.tvQuestion)
        btnTrue = findViewById(R.id.btnTrue)
        btnFalse = findViewById(R.id.btnFalse)

        // Listeners para mostrar Toasts
        btnTrue.setOnClickListener {
            Toast.makeText(this, getString(R.string.toast_true), Toast.LENGTH_SHORT).show()
        }

        btnFalse.setOnClickListener {
            Toast.makeText(this, getString(R.string.toast_false), Toast.LENGTH_SHORT).show()
        }
    }
}

