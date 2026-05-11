package com.example.calculadoracomloginapp

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Button

class DialogErro(context: Context) : Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.dialogo_erro)

        val btnFechar = findViewById<Button>(R.id.btnFechar)
        val btnFecharX = findViewById<ImageButton>(R.id.btnFecharX)

        btnFechar.setOnClickListener { dismiss() }
        btnFecharX.setOnClickListener { dismiss() }

        window?.setBackgroundDrawableResource(android.R.color.transparent)
        window?.setDimAmount(0.6f)
    }
}