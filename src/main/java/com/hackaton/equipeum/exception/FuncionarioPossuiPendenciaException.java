package com.hackaton.equipeum.exception;

public class FuncionarioPossuiPendenciaException extends RuntimeException {
    public FuncionarioPossuiPendenciaException() {
        super("Funcionario nao pode ser desligado, pois possui pendencias");
    }
}
