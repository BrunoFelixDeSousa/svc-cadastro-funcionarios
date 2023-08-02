package br.com.svccadastrofuncionarios.services;

import br.com.svccadastrofuncionarios.model.dto.FuncionarioRequest;
import br.com.svccadastrofuncionarios.model.dto.FuncionarioResponse;
import br.com.svccadastrofuncionarios.model.entities.FuncionarioEntity;

import java.util.List;
import java.util.Optional;

public interface FuncionarioService {

    public FuncionarioEntity salvarFuncionario(FuncionarioRequest funcionarioRequest);

    public List<FuncionarioResponse> buscarTodosFuncionarios();

    public Optional<FuncionarioEntity> buscarPorIdFuncionario(Long id);

    public void deletarFuncionario(FuncionarioEntity funcionarioEntity);

    public boolean atualizarFuncionario(Long id, FuncionarioRequest funcionarioRequest);
}
