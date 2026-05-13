package com.example.calculadoracomloginapp.view

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculadoracomloginapp.R
import com.example.calculadoracomloginapp.model.Calculadora
import com.example.calculadoracomloginapp.viewmodel.CalculadoraViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: CalculadoraViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editTextValorA = findViewById<EditText>(R.id.edit_text_valor_a)
        val editTextValorB = findViewById<EditText>(R.id.edit_text_valor_b)

        val inputValorA = editTextValorA.text.toString().toDoubleOrNull()
        val inputValorB = editTextValorB.text.toString().toDoubleOrNull()

        val btnSomar =  findViewById<Button>(R.id.btn_somar)
        val btnSubtrair =  findViewById<Button>(R.id.btn_subtrair)
        val btnDividir =  findViewById<Button>(R.id.btn_dividir)
        val btnMultiplicar = findViewById<Button>(R.id.btn_multiplicar)

        val tvResultado = findViewById<TextView>(R.id.tv_resultado)

        viewModel.mostrarResultado.observe(this) { resultado ->
            tvResultado.text = resultado
        }

        btnSomar.setOnClickListener {
            if (inputValorA != null && inputValorB != null) {
                viewModel.realizarSoma(inputValorA, inputValorB)
            }
        }

        btnSubtrair.setOnClickListener {
            if (inputValorA != null && inputValorB != null) {
                viewModel.realizarSubtracao(inputValorA, inputValorB)
            }
        }

        btnDividir.setOnClickListener {
            if (inputValorA != null && inputValorB != null) {
                viewModel.realizarDivisao(inputValorA, inputValorB)
            }
        }

        btnMultiplicar.setOnClickListener {
            if (inputValorA != null && inputValorB != null) {
                viewModel.realizarMultiplicacao(inputValorA,inputValorB)
            }
        }



    }
}