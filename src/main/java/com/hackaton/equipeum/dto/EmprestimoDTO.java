package com.hackaton.equipeum.dto;

public class EmprestimoDTO {

    private String cpf;
    private String patrimonio;

    public EmprestimoDTO() {
    }

    public EmprestimoDTO(String cpf, String patrimonio) {
        this.cpf = cpf;
        this.patrimonio = patrimonio;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(String patrimonio) {
        this.patrimonio = patrimonio;
    }
}
