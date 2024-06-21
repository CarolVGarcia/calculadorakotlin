package com.example.appmicalculadora

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class OperacionesActivity : AppCompatActivity() {
    private lateinit var txtUsuario : TextView
    private lateinit var txtNum1 : EditText
    private lateinit var txtNum2 : EditText
    private lateinit var txtResultado : TextView
    private lateinit var btnSumar : Button
    private lateinit var btnRestar : Button
    private lateinit var btnMult : Button
    private lateinit var btnDiv : Button
    private lateinit var btnCerrar : Button
    private lateinit var btnLimpiar : Button
    private lateinit var operaciones: Operaciones
    var opcion : Int =0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_operaciones)
        iniciarCompontes()
        eventosClic()
    }
    public fun iniciarCompontes(){
        txtUsuario = findViewById(R.id.txtNombre)
        txtResultado = findViewById(R.id.txtResultado)
        txtNum1 = findViewById(R.id.txtNum1)
        txtNum2 = findViewById(R.id.txtNum2)
        btnSumar = findViewById(R.id.btnMas)
        btnRestar = findViewById(R.id.btnRes)
        btnMult = findViewById(R.id.btnMul)
        btnDiv = findViewById(R.id.btnDiv)
        btnCerrar = findViewById(R.id.btnCerrar)
        btnLimpiar = findViewById(R.id.btnLimpiar)
        val bundle: Bundle? = intent.extras
        txtUsuario.text = bundle?.getString("Usuario")
    }
    public fun validar() : Boolean {
        if( txtNum1.text.toString().contentEquals("") ||
            txtNum2.text.toString().contentEquals("")) return false
        else return true
    }
    public fun operacion(): Float{
        var num1 : Float = 0.0f
        var num2 : Float =0.0f
        var res : Float =0.0f
        if(validar()){
            num1 = txtNum1.text.toString().toFloat()
            num2 = txtNum2.text.toString().toFloat()
            operaciones = Operaciones(num1,num2)
            when(opcion){
                1 -> {res=operaciones.suma()}
                2 -> {res= operaciones.resta()}
                3 -> {res= operaciones.multiplicacion()}
                4 -> {res= operaciones.division()}
            }
        } else Toast.makeText(this,"Falto capturar informacion",Toast.LENGTH_SHORT).show()
            return res;
    }
    public fun eventosClic(){
        btnSumar.setOnClickListener(View.OnClickListener {
            opcion =1;
            txtResultado.text= operacion().toString()
        })
        btnRestar.setOnClickListener(View.OnClickListener {
            opcion =2
            txtResultado.text= operacion().toString()
        })
        btnMult.setOnClickListener(View.OnClickListener {
            opcion =3
            txtResultado.text= operacion().toString()
        })
        btnDiv.setOnClickListener(View.OnClickListener {
            if(this.txtNum2.text.toString().toFloat()==0f)
                txtResultado.text="No es posible dividir sobre 0"
            else {
                opcion = 4
                txtResultado.text= operacion().toString()
            }
        })
        btnLimpiar.setOnClickListener(View.OnClickListener {
            txtResultado.text =""
            txtNum2.text.clear()
            txtNum1.text.clear()
        })
        btnCerrar.setOnClickListener(View.OnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Calculadora")
            builder.setMessage("¿ Desea Cerrar ?")
            builder.setPositiveButton(android.R.string.yes) { dialog,
                                                              which ->
                this.finish()
            }
            builder.setNegativeButton(android.R.string.no) { dialog, which ->
            }
            builder.show()
        })
    }
}
