package com.example.atividadePontuada.model;

public enum Sexo {

    MASCULINO("Masculino"),
    FEMININO("Feminino"),
    OUTRO("Outro");

    private String texto;

    Sexo(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }
}
