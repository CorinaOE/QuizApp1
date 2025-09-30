package com.example.quizapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : Activity() {

    private lateinit var tvResult: TextView
    private lateinit var btnRestart: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        tvResult = findViewById(R.id.tvResult)
        btnRestart = findViewById(R.id.btnRestart)

        val score = intent.getIntExtra("score", 0)
        val total = intent.getIntExtra("total", 0)

        tvResult.text = getString(R.string.result_text, score, total)

        btnRestart.setOnClickListener {
            // Reiniciar el quiz volviendo a MainActivity
            val intent = Intent(this, MainActivity::class.java)
            // Limpia la pila para evitar múltiples instancias
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }
}
