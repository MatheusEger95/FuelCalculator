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

class PrecoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preco)

        val btnProximoPreco = findViewById<Button>(R.id.btn_proximo_preco)
        val tiePreco = findViewById<TextInputEditText>(R.id.tie_preco)
        val btnVoltar = findViewById<ImageView>(R.id.iv_preco)

        btnVoltar.setOnClickListener{
            finish()
        }

        btnProximoPreco.setOnClickListener{
            val precoStr = tiePreco.text.toString()
            if (precoStr == ""){
                Snackbar
                    .make(
                        tiePreco,
                        "Preencha o campo preço",
                        Snackbar.LENGTH_LONG
                    )
                    .show()
            }else{
                val precoFloat: Float = tiePreco.text.toString().toFloat()

                val intent = Intent(this, ConsumoActivity::class.java)
                    .apply {
                        putExtra("KEY_PRECO", precoFloat)
                    }
                startActivity(intent)
            }
        }
    }
}