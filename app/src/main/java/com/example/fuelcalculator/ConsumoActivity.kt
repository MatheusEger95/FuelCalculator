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

class ConsumoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consumo)

        val btnProximoConsumo = findViewById<Button>(R.id.btn_proximo_consumo)
        val tieConsumo = findViewById<TextInputEditText>(R.id.tie_consumo)
        val btnVoltar = findViewById<ImageView>(R.id.iv_consumo)

        val precoFloat = intent.getFloatExtra("KEY_PRECO", 0F)

        btnVoltar.setOnClickListener{
            finish()
        }

        btnProximoConsumo.setOnClickListener{
            val consumoStr = tieConsumo.text.toString()
            if (consumoStr == ""){
                Snackbar
                    .make(
                        tieConsumo,
                        "Preencha o campo consumo",
                        Snackbar.LENGTH_LONG
                    )
                    .show()
            }else{
                val consumoFloat: Float = tieConsumo.text.toString().toFloat()

                val intent = Intent(this, DistanciaActivity::class.java)
                    .apply {
                        putExtra("KEY_PRECO", precoFloat)
                        putExtra("KEY_CONSUMO", consumoFloat)
                    }
                startActivity(intent)
            }
        }
    }
}