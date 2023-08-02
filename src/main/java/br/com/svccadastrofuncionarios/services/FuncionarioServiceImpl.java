package br.com.svccadastrofuncionarios.services;

import br.com.svccadastrofuncionarios.model.dto.FuncionarioRequest;
import br.com.svccadastrofuncionarios.model.dto.FuncionarioResponse;
import br.com.svccadastrofuncionarios.model.entities.FuncionarioEntity;
import br.com.svccadastrofuncionarios.repositories.FuncionarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    FuncionarioRepository funcionarioRepository;

    public FuncionarioEntity salvarFuncionario(FuncionarioRequest funcionarioRequest) {

        FuncionarioEntity funcionarioEntity = new FuncionarioEntity();
        BeanUtils.copyProperties(funcionarioRequest, funcionarioEntity);

        return funcionarioRepository.save(funcionarioEntity);
    }

    public List<FuncionarioResponse> buscarTodosFuncionarios() {
        List<FuncionarioEntity> funcionarioEntities = funcionarioRepository.findAll();
        List<FuncionarioResponse> funcionarioResponses = new ArrayList<>();

        for (FuncionarioEntity funcionarioEntity : funcionarioEntities) {
            FuncionarioResponse funcionarioResponse = new FuncionarioResponse(funcionarioEntity.getNome(), funcionarioEntity.getCargo());
            funcionarioResponses.add(funcionarioResponse);
        }

        return funcionarioResponses;
    }

    public Optional<FuncionarioEntity> buscarPorIdFuncionario(Long id) {
        return funcionarioRepository.findById(id);
    }

    @Transactional
    public void deletarFuncionario(FuncionarioEntity funcionarioEntity) {
        funcionarioRepository.delete(funcionarioEntity);
    }

    @Override
    public boolean atualizarFuncionario(Long id, FuncionarioRequest funcionarioRequest) {
        Optional<FuncionarioEntity> funcionarioEntityOptional = funcionarioRepository.findById(id);

        if (funcionarioEntityOptional.isPresent()) {

            FuncionarioEntity funcionarioEntity = funcionarioEntityOptional.get();
            funcionarioEntity.setNome(funcionarioRequest.getNome());
            funcionarioEntity.setCargo(funcionarioRequest.getCargo());
            funcionarioEntity.setDataNascimento(funcionarioRequest.getDataNascimento());
            funcionarioEntity.setSalario(funcionarioRequest.getSalario());

            funcionarioRepository.save(funcionarioEntity);
            return true;
        }
        return false;
    }
}
