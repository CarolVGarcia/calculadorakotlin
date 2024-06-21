package com.example.appmicalculadora

class Operaciones (var num1:Float, var num2:Float){
    public fun suma() : Float {
        return this.num1 + this.num2


    }

    public  fun resta() : Float {
        return this.num1 - this.num2
    }

    public  fun multiplicacion() : Float{
        return this.num1 * this.num2
    }

    public fun division() : Float {
        return this.num1 / this.num2
    }

}