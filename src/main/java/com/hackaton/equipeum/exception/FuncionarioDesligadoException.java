package com.hackaton.equipeum.exception;

public class FuncionarioDesligadoException extends RuntimeException {
    public FuncionarioDesligadoException() {
        super("Funcionario desligado!");
    }
}
