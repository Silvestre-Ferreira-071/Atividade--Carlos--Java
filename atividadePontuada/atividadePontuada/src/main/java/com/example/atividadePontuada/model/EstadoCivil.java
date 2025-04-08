package com.example.atividadePontuada.model;

public enum EstadoCivil {

    SOLTEIRO("Solteiro"),
    CASADO("Casado"),
    SEPARADO("Separado"),
    DIVORCIADO("Divorciado"),
    VIUVO("Viúvo");


    private String texto;

    EstadoCivil(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

}
