package br.com.svccadastrofuncionarios.model.dto;

import br.com.svccadastrofuncionarios.model.enums.CargoEnum;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FuncionarioResponse {
    private String nome;
    private CargoEnum cargo;
}
