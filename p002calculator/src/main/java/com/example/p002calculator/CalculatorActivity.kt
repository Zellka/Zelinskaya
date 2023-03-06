package com.example.p002calculator

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.isVisible

class CalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        val btnCalculate = findViewById<AppCompatButton>(R.id.btnCalculate)
        val tvCalculateSum = findViewById<TextView>(R.id.tvCalculateSum)
        btnCalculate.setOnClickListener {
            tvCalculateSum.isVisible = true
        }
    }
}