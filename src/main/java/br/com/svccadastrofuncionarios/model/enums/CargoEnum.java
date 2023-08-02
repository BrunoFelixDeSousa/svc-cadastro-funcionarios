package br.com.svccadastrofuncionarios.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CargoEnum {

    VENDEDOR(0, "Cargo vendedor"),
    GERENTE(1, "Gerente");

    private final int code;
    private final String descricao;
}
