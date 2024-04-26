package com.IoC;

public class Empleado implements Persona{
    GeneradorDocumentacion documentacion;
    public Empleado(GeneradorDocumentacion documentacion){
        this.documentacion = documentacion;
    }


    @Override
    public String agregar() {
        return "\u001B[32mHa agregado a un empleado en el registro" + "\n\u001B[33m" + getDocumentacion() +
                "\u001B[0m";
    }

    @Override
    public String eliminar() {
        return "\u001B[31mHa eliminado a un empleado del registro" + "\n\u001B[33m" + getDocumentacion() +
                "\u001B[0m";
    }

    public String getDocumentacion(){
        return this.documentacion.mostrarDocumentacion();
    }
}