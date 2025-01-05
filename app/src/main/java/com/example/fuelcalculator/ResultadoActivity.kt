package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val btnNovaConsulta = findViewById<Button>(R.id.btn_novo_calculo)
        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvPreco = findViewById<TextView>(R.id.tv_preco)
        val tvConsumo = findViewById<TextView>(R.id.tv_consumo)
        val tvDistancia = findViewById<TextView>(R.id.tv_distancia)

        val precoFloat = intent.getFloatExtra("KEY_PRECO", 0F)
        val consumoFloat = intent.getFloatExtra("KEY_CONSUMO", 0F)
        val distanciaFloat = intent.getFloatExtra("KEY_DISTANCIA", 0F)
        val totalGasto = intent.getFloatExtra("KEY_TOTAL_GASTO", 0F)

        tvResult.text = totalGasto.toString()
        tvPreco.text =  precoFloat.toString()
        tvConsumo.text = consumoFloat.toString()
        tvDistancia.text = distanciaFloat.toString()

        btnNovaConsulta.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}