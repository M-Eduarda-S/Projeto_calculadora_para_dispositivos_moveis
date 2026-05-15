package com.example.calculadoracomloginapp.view

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculadoracomloginapp.R
import com.example.calculadoracomloginapp.viewmodel.CalculadoraViewModel
import kotlin.apply

class Calculadora : AppCompatActivity() {

    private val viewModel: CalculadoraViewModel by viewModels()
    private lateinit var editTextValorA: EditText
    private lateinit var editTextValorB: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculadora)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        editTextValorA = findViewById<EditText>(R.id.edit_text_valor_a)
        editTextValorB = findViewById<EditText>(R.id.edit_text_valor_b)

        val btnSomar =  findViewById<Button>(R.id.btn_somar)
        val btnSubtrair =  findViewById<Button>(R.id.btn_subtrair)
        val btnDividir =  findViewById<Button>(R.id.btn_dividir)
        val btnMultiplicar = findViewById<Button>(R.id.btn_multiplicar)

        val tvResultado = findViewById<TextView>(R.id.tv_resultado)

        val btnCompartilhar = findViewById<Button>(R.id.btn_compartilhar)

        viewModel.botoesHabilitados.observe(this){ habilitado ->
            btnSomar.isEnabled = habilitado
            btnSubtrair.isEnabled = habilitado
            btnDividir.isEnabled = habilitado
            btnMultiplicar.isEnabled = habilitado
        }

        viewModel.mostrarResultado.observe(this) { resultado ->
            tvResultado.text = resultado
        }

        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
               viewModel.validarCampos(editTextValorA.text.toString(),editTextValorB.text.toString())
            }
        }

        editTextValorA.addTextChangedListener(textWatcher)
        editTextValorB.addTextChangedListener(textWatcher)


        btnSomar.setOnClickListener {
            val inputValorA = editTextValorA.text.toString().toDoubleOrNull()
            val inputValorB = editTextValorB.text.toString().toDoubleOrNull()

            if (inputValorA != null && inputValorB != null) {
                viewModel.realizarSoma(inputValorA, inputValorB)
            }
        }

        btnSubtrair.setOnClickListener {
            val inputValorA = editTextValorA.text.toString().toDoubleOrNull()
            val inputValorB = editTextValorB.text.toString().toDoubleOrNull()

            if (inputValorA != null && inputValorB != null) {
                viewModel.realizarSubtracao(inputValorA, inputValorB)
            }
        }

        btnDividir.setOnClickListener {
            val inputValorA = editTextValorA.text.toString().toDoubleOrNull()
            val inputValorB = editTextValorB.text.toString().toDoubleOrNull()

            if (inputValorA != null && inputValorB != null) {
                viewModel.realizarDivisao(inputValorA, inputValorB)
            }
        }

        btnMultiplicar.setOnClickListener {
            val inputValorA = editTextValorA.text.toString().toDoubleOrNull()
            val inputValorB = editTextValorB.text.toString().toDoubleOrNull()

            if (inputValorA != null && inputValorB != null) {
                viewModel.realizarMultiplicacao(inputValorA,inputValorB)
            }
        }

        btnCompartilhar.setOnClickListener {
            val textValorA = editTextValorA.text.toString()
            val textValorB = editTextValorB.text.toString()
            val operador = viewModel.operadorUtilizado
            val resultado = viewModel.mostrarResultado.value

            val intent = Intent().apply{
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Oi! Você sabia que $textValorA $operador $textValorB = $resultado?")
                type = "text/plain"
            }
            val compartilharIntent = Intent.createChooser(intent, "Compartilhar resultado:")
            startActivity(compartilharIntent)
        }

    }
}