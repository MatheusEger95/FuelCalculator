package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class DistanciaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_distancia)

        val btnResultado = findViewById<Button>(R.id.btn_resultado)
        val tieDistancia = findViewById<TextInputEditText>(R.id.tie_distancia)
        val btnVoltar = findViewById<ImageView>(R.id.iv_distancia)

        val precoFloat = intent.getFloatExtra("KEY_PRECO", 0F)
        val consumoFloat = intent.getFloatExtra("KEY_CONSUMO", 0F)

        btnVoltar.setOnClickListener {
            finish()
        }

        btnResultado.setOnClickListener {
            val distanciaStr = tieDistancia.text.toString()
            if (distanciaStr == ""){
                Snackbar
                    .make(
                        tieDistancia,
                        "Preencha o campo distância",
                        Snackbar.LENGTH_LONG
                    )
                    .show()
            }else{
                val distanciaFloat: Float = tieDistancia.text.toString().toFloat()

                val mediaConsumo: Float = distanciaFloat / consumoFloat
                val totalGasto: Float = mediaConsumo * precoFloat

                val intent = Intent (this, ResultadoActivity::class.java)
                    .apply {
                        putExtra("KEY_PRECO", precoFloat)
                        putExtra("KEY_CONSUMO", consumoFloat)
                        putExtra("KEY_DISTANCIA", distanciaFloat)
                        putExtra("KEY_TOTAL_GASTO", totalGasto)

                    }
                startActivity(intent)
            }
        }
    }
}