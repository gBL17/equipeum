package com.hackaton.equipeum.exception;

public class FuncionarioPossuiEquipamentoException extends RuntimeException {
    public FuncionarioPossuiEquipamentoException() {
        super("Funcionario ja possui o equipamento");
    }
}
