package com.hackaton.equipeum.exception;

public class FuncionarioNaoExisteException extends RuntimeException {
    public FuncionarioNaoExisteException() {
        super("Funcionario nao existe!");
    }
}
