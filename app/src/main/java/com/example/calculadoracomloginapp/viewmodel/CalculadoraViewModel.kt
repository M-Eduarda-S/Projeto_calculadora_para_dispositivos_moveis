package com.example.calculadoracomloginapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.calculadoracomloginapp.model.Calculadora

class CalculadoraViewModel(): ViewModel() {
    private val calculadora = Calculadora()

    private val _mostrarResultado = MutableLiveData<String>() //Backing property - Apenas o VM pode acessa-lo
    val mostrarResultado: LiveData<String> get() = _mostrarResultado // Apenas leitura - É mostrado ao MainActivity

    init {
        _mostrarResultado.value = "0"
    }

    fun realizarSoma(a:Double, b: Double){
        val resultado = calculadora.somar(a,b)
        _mostrarResultado.value = resultado.toString()
    }

    fun realizarSubtracao(a: Double, b: Double){
        val resultado = calculadora.subtrair(a,b)
        _mostrarResultado.value = resultado.toString()
    }

    fun realizarMultiplicacao(a: Double, b: Double){
        val resultado = calculadora.multiplicar(a,b)
        _mostrarResultado.value = resultado.toString()
    }

    fun realizarDivisao(a: Double, b: Double){
        val resultado = calculadora.dividir(a,b)
        _mostrarResultado.value = resultado.toString()
    }
}