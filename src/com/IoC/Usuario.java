package com.IoC;

public class Usuario implements Persona{
    GeneradorDocumentacion documentacion;
    public Usuario(GeneradorDocumentacion documentacion){
        this.documentacion = documentacion;
    }


    @Override
    public String agregar() {
        return "\u001B[32mHa agregado a un usuario en el registro" + "\n\u001B[33m" + getDocumentacion() +
                "\u001B[0m";
    }

    @Override
    public String eliminar() {
        return "\u001B[31mHa eliminado a un usuario del registro" + "\n\u001B[33m" + getDocumentacion() +
                "\u001B[0m";
    }

    public String getDocumentacion(){
        return this.documentacion.mostrarDocumentacion();
    }
}
