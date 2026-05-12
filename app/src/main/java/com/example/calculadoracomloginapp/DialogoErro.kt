package com.example.calculadoracomloginapp

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class DialogoErro(context: Context, private val mensagem: String) : Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialogo_erro)

        val btnFechar = findViewById<Button>(R.id.btnFechar)
        val btnFecharX = findViewById<ImageButton>(R.id.btnFecharX)
        val tvErroMensagem = findViewById<TextView>(R.id.tvErroMensagem)

        tvErroMensagem.text = mensagem

        btnFechar.setOnClickListener { dismiss() }
        btnFecharX.setOnClickListener { dismiss() }

        window?.setBackgroundDrawableResource(android.R.color.transparent)
        window?.setDimAmount(0.6f)
    }

    companion object {
        fun show(context: Context, tipoErro: Int) {
            val mensagem = when (tipoErro) {
                1 -> context.getString(R.string.erro_cpf_invalido)
                2 -> context.getString(R.string.erro_senha_invalida)
                else -> context.getString(R.string.erro_cpf_senha_invalidos)
            }
            DialogoErro(context, mensagem).show()
        }
    }
}