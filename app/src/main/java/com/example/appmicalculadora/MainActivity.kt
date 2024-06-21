package com.example.appmicalculadora

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var txtUsuario: EditText
    private lateinit var txtContraseña: EditText
    private lateinit var btbIngresar: Button
    private lateinit var btnSalir: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        iniciarComponetes()
        eventosClick()
    }

    public fun iniciarComponetes() {
        txtUsuario = findViewById(R.id.txtUsuario) as EditText
        txtContraseña = findViewById(R.id.txtContraseña) as EditText
        btnSalir = findViewById(R.id.btnSalir) as Button
        btbIngresar = findViewById(R.id.btnIngresar) as Button
    }

    public fun eventosClick() {
        btbIngresar.setOnClickListener(View.OnClickListener {
            var usuario: String = getString(R.string.usuario)
            var pass: String = getString(R.string.pass)
            if (txtUsuario.text.toString().contentEquals(usuario) &&
                txtContraseña.text.toString().contentEquals(pass)
            ) {
                val intent = Intent(this, OperacionesActivity::class.java)
                intent.putExtra("Usuario", txtUsuario.text.toString())
                startActivity(intent)
            } else
                Toast.makeText(
                    this, "Usuario o contraseña no validos",
                    Toast.LENGTH_SHORT
                ).show()
        })
        btnSalir.setOnClickListener(View.OnClickListener {
            finish()
        })
    }
}