package com.example.calculadoracomloginapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.calculadoracomloginapp.model.Calculadora

class CalculadoraViewModel(): ViewModel() {
    private val calculadora = Calculadora()

    private val _mostrarResultado = MutableLiveData<String>() //Backing property - Apenas o VM pode acessa-lo
    val mostrarResultado: LiveData<String> get() = _mostrarResultado // Apenas leitura - É mostrado ao MainActivity

    private val _botoesHabilitados = MutableLiveData<Boolean>()
    val botoesHabilitados: LiveData<Boolean> get() = _botoesHabilitados

    private val _operadorUtilizado = MutableLiveData<String>()
    val operadorUtilizado: LiveData<String> get() = _operadorUtilizado

    init {
        _mostrarResultado.value = "0"
        _botoesHabilitados.value = false
        _operadorUtilizado.value = ""
    }

    fun validarCampos(a: String, b: String) {
        val camposPreenchidos = a.isNotBlank() && b.isNotBlank()
        _botoesHabilitados.value = camposPreenchidos
    }

    fun realizarSoma(a:Double, b: Double){
        val resultado = calculadora.somar(a,b)
        _mostrarResultado.value = resultado.toString()
        _operadorUtilizado.value = "+"
    }

    fun realizarSubtracao(a: Double, b: Double){
        val resultado = calculadora.subtrair(a,b)
        _mostrarResultado.value = resultado.toString()
        _operadorUtilizado.value = "-"
    }

    fun realizarMultiplicacao(a: Double, b: Double){
        val resultado = calculadora.multiplicar(a,b)
        _mostrarResultado.value = resultado.toString()
        _operadorUtilizado.value = "*"
    }

    fun realizarDivisao(a: Double, b: Double){
        val resultado = calculadora.dividir(a,b)
        _mostrarResultado.value = resultado.toString()
        _operadorUtilizado.value = "/"
    }
}