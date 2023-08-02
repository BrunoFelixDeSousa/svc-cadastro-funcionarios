package br.com.svccadastrofuncionarios.model.entities;

import br.com.svccadastrofuncionarios.model.enums.CargoEnum;
import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "funcionarios")
public class FuncionarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dataNascimento;
    private Double salario;
    @Enumerated(EnumType.STRING)
    private CargoEnum cargo;

}
