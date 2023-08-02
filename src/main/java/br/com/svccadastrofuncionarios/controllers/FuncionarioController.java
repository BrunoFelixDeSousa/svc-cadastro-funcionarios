package br.com.svccadastrofuncionarios.controllers;

import br.com.svccadastrofuncionarios.model.dto.FuncionarioRequest;
import br.com.svccadastrofuncionarios.model.dto.FuncionarioResponse;
import br.com.svccadastrofuncionarios.model.entities.FuncionarioEntity;
import br.com.svccadastrofuncionarios.services.FuncionarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @PostMapping
    public ResponseEntity<Object> criarFuncionario(@RequestBody FuncionarioRequest funcionarioRequest) {

        FuncionarioEntity funcionarioEntity = funcionarioService.salvarFuncionario(funcionarioRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioEntity);
    }

    @GetMapping("/listar-funcionarios")
    public ResponseEntity<List<FuncionarioResponse>> listarFuncionarios() {
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioService.buscarTodosFuncionarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarPoId(@PathVariable(value = "id") Long id) {
        Optional<FuncionarioEntity> funcionarioEntityOptional = funcionarioService.buscarPorIdFuncionario(id);
        return funcionarioEntityOptional.<ResponseEntity<Object>>map(funcionarioEntity ->
                ResponseEntity.status(HttpStatus.OK).body(funcionarioEntity)).orElseGet(() ->
                ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionario não encontrado!"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarFuncionario(@PathVariable(value = "id") Long id) {
        Optional<FuncionarioEntity> funcionarioEntityOptional = funcionarioService.buscarPorIdFuncionario(id);

        if (!funcionarioEntityOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionario não encontrado!");
        }
        funcionarioService.deletarFuncionario(funcionarioEntityOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Funcionario deletado");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarFuncionario(@PathVariable(value = "id") Long id,
                                                       @RequestBody FuncionarioRequest funcionarioRequest) {

        boolean atualizado = funcionarioService.atualizarFuncionario(id, funcionarioRequest);

        if (atualizado) {
            return ResponseEntity.status(HttpStatus.OK).body("Funcionario atualizado.");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body("Funcionario não encontrado.");
        }
//        Optional<FuncionarioEntity> funcionarioEntityOptional = funcionarioService.findById(id);

//        boolean atualizado = funcionarioService.save()
//
//        FuncionarioEntity funcionarioEntity = new FuncionarioEntity();
//        BeanUtils.copyProperties(funcionarioRequest, funcionarioEntity);
//        funcionarioEntity.setId(funcionarioEntityOptional.get().getId());
//        return ResponseEntity.status(HttpStatus.OK).body(funcionarioService.save(funcionarioEntity));
    }

}
