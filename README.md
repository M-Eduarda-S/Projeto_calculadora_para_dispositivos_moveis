# Projeto_calculadora_para_dispositivos_moveis

### Disciplina:
Programação para Dispositivos Móveis

### Academicos
- Beatriz Pimentel Bagesteiro Alves
- Juliana Simon
- Maria Eduarda Santos
- Nicolas Vera
- Yasmin Tarnovski Faccin

---
## Descrição do Projeto

Aplicativo Android que simula uma calculadora básica com operações de:
- Soma
- Subtração
- Multiplicação
- Divisão

O app também possui um sistema de login com CPF e senha.
</br> </br>

### Funcionalidades
- Tela de Login com validação
- Exibição de diálogo de erro para credenciais inválidas
- Tela de calculadora com operações básicas
- Botões habilitados/desabilitados conforme entrada
- Compartilhamento de resultado via Intent implícita
</br>

## Tecnologias utilizadas
- Android Studio
- Linguagem de programação Kotlin
- Linguagem de marcação XML (layouts)
- ConstraintLayout

</br>

### Requisitos para rodar o projeto
- Ter o Android Studio instalado
</br>

### Como rodar o projeto
1. Clone o repositório
2. Abra no Android Studio
3. Execute em um emulador ou dispositivo físico
</br>

## Fluxo do Aplicativo
1. Usuário insere CPF e senha
2. Se válido → vai para calculadora
3. Se inválido → exibe diálogo de erro
4. Realiza cálculo
5. Pode compartilhar o resultado
</br> </br> 

---
## Estrutura do projeto

```text
app/
	src/
		main/
			java/com/example/calculadoracomloginapp/
				MainActivity.kt
				DialogoErro.kt
			res/
				drawable/
				layout/
					activity_main.xml
					dialogo_erro.xml
				mipmap/
				values/
			AndroidManifest.xml
.gitignore
README.md
```

## Observações

- O CPF e senha são validados localmente (simulação)
