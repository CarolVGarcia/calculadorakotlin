package com.example.appmicalculadora

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OperacionesActivity : AppCompatActivity() {

    private lateinit var txtUsuario : TextView
    private lateinit var txtNum1 : EditText
    private lateinit var txtNum2 : EditText
    private lateinit var txtResultado : TextView

    private lateinit var btnSumar : Button
    private lateinit var btnRestar : Button
    private lateinit var btnMultiplicar : Button
    private lateinit var btnDiv : Button

    private lateinit var btnLimpiar : Button
    private lateinit var btnRegresar : Button


    private lateinit var operaciones: Operaciones


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_operaciones)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


    public fun iniciarComponentes(){
        txtUsuario = findViewById(R.id.txtUsuario)
        txtResultado = findViewById(R.id.txtResultado)
        txtNum1 = findViewById(R.id.txtNum1)
        txtNum2 = findViewById(R.id.txtNum2)

        btnSumar = findViewById(R.id.btnSumar)
        btnRestar = findViewById(R.id.btnRestar)
        btnMultiplicar = findViewById(R.id.btnMultiplicar)
        btnDiv = findViewById(R.id.btnDiv)

        btnRegresar = findViewById(R.id.btnRegresar)
        btnLimpiar = findViewById(R.id.btnLimpiar)

        val bundle : Bundle? = intent.extras
        txtUsuario.text = bundle?.getString("nombre")
    }

    public fun validar() : Boolean{

        if (txtNum1.text.toString().contentEquals(" ") || txtNum2.text.toString().contentEquals(""))return false

        else return true
    }

}