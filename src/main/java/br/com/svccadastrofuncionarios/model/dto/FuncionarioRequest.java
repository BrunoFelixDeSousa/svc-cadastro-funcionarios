package br.com.svccadastrofuncionarios.model.dto;

import br.com.svccadastrofuncionarios.model.enums.CargoEnum;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FuncionarioRequest {
    private String nome;
    private String dataNascimento;
    private Double salario;
    private CargoEnum cargo;
}
