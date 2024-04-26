package com.IoC;

public class GeneradorDocumentacion implements Documentacion{
    @Override
    public String mostrarDocumentacion() {
        return "Esta es la documentación requerida para el procedimiento.";
    }
}
