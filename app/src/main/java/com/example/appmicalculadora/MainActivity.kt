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

    private lateinit var txtUsuario : EditText;
    private lateinit var txtConstraseña : EditText;
    private lateinit var btnIngresar : Button;
    private lateinit var btnSalir : Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //INICIAR COMPONENTES
        iniciarComponentes()
        eventosClic()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    public fun iniciarComponentes(){
        txtUsuario = findViewById(R.id.txtUsuario)
        txtConstraseña = findViewById(R.id.txtContraseña)
        btnIngresar = findViewById(R.id.btnIngresar)
        btnSalir = findViewById(R.id.btnSalir)
    }

    public fun eventosClic(){
        btnIngresar.setOnClickListener(View.OnClickListener {

            var usuario : String = getString(R.string.usuario)
            var pas : String = getString(R.string.pass)
            var nombre : String = getString(R.string.nombre)

            if (txtUsuario.text.toString().contentEquals(usuario) && txtConstraseña.text.toString().contentEquals(pas)){

                var intet = Intent(this, OperacionesActivity::class.java)
                    intet.putExtra("Nombre", nombre)
                startActivity(intet)

            }
            else

                Toast.makeText(this, "El usuario o password es incorrecto", Toast.LENGTH_SHORT).show()

        })

        btnSalir.setOnClickListener(View.OnClickListener {

            finish()
        })


    }



}