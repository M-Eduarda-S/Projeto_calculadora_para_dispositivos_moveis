package com.example.calculadoracomloginapp.view

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import com.example.calculadoracomloginapp.R
import android.content.Intent

class MainActivity : AppCompatActivity() {

    // Para ir à calculadora
    private fun goToCalculator() {
        val intent = Intent(this, Calculadora::class.java)
        startActivity(intent)
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Inicializando os componentes
        val etCpf = findViewById<EditText>(R.id.etCpf)
        val etSenha = findViewById<EditText>(R.id.etSenha)
        val btnEnviar = findViewById<Button>(R.id.btnEnviar)
        val tvStatusMessage = findViewById<TextView>(R.id.tvStatusMessage)
        
        // O botão de enviar começa desabilitado
        btnEnviar.isEnabled = false

        // Credenciais padrão
        val defaultCpf = "12345678910"
        val defaultSenha = "123"

        // Função para validar se os campos estão preenchidos e habilitar o botão
        val watcher = {
            val cpf = etCpf.text.toString().trim()
            val senha = etSenha.text.toString().trim()
            btnEnviar.isEnabled = cpf.isNotEmpty() && senha.isNotEmpty()
        }

        // Adiciona listeners para monitorar a digitação e habilitar o botão
        etCpf.addTextChangedListener { watcher() }
        etSenha.addTextChangedListener { watcher() }

        btnEnviar.setOnClickListener {
            val cpfInput = etCpf.text.toString().trim()
            val senhaInput = etSenha.text.toString().trim()

            // remove máscara do CPF
            val cpfLimpo = cpfInput.replace(Regex("[^\\d]"), "")

            // Lógica de validação do login
            if (cpfLimpo == defaultCpf && senhaInput == defaultSenha) {
                // Login Aprovado
                tvStatusMessage.text = getString(R.string.login_approved)
                tvStatusMessage.setTextColor(ContextCompat.getColor(this, R.color.meow_green))

                // Vai para a tela da Calculadora
                goToCalculator()
            } else {
                // Determina qual erro mostrar no diálogo
                val tipoErro = when {
                    cpfLimpo  != defaultCpf && senhaInput != defaultSenha -> 0 // ambos errados
                    cpfLimpo  != defaultCpf -> 1 // CPF errado
                    else -> 2 // senha errada
                }
                
                // Abre o diálogo de erro customizado
                DialogoErro.show(this, tipoErro)

                // Atualiza a mensagem na tela de login também
                tvStatusMessage.text = getString(R.string.error_invalid_credentials)
                tvStatusMessage.setTextColor(ContextCompat.getColor(this, R.color.meow_error))
            }
        }
    }
}