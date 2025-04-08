package com.example.atividadePontuada.services;

import java.util.List;

import com.example.atividadePontuada.model.Funcionario;
import com.example.atividadePontuada.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.Valid;

@Service
@Validated
public class FuncionarioService {
    private FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    //Listar todos os funcionarios
    public List<Funcionario> listarTodos() {
        return funcionarioRepository.findAll();
    }
    //Salvar dados do funcionario com o parametro de que se o email ja está cadastrado exibe a mensagem Email ja cadastrado
    public Funcionario salvar (@Valid Funcionario funcionario){
        if (funcionarioRepository.findByEmail(funcionario.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email já cadastrado!");
        }
        return funcionarioRepository.save(funcionario);
    }

    //Atualizar
    public Funcionario atualizar(@Valid Funcionario funcionario) {
        Funcionario funcionarioAtualizar = funcionarioRepository.findByEmail(funcionario.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Funcionário não encontrado!"));


        funcionarioAtualizar.setNome(funcionario.getNome());
        funcionarioAtualizar.setCpf(funcionario.getCpf());
        funcionarioAtualizar.setEmail(funcionario.getEmail());
        funcionarioAtualizar.setDataNascimento(funcionario.getDataNascimento());
        funcionarioAtualizar.setEstadoCivil(funcionario.getEstadoCivil());
        funcionarioAtualizar.setSexo(funcionario.getSexo());
        funcionarioAtualizar.setEndereco(funcionario.getEndereco());

        return funcionarioRepository.save(funcionarioAtualizar);

    }
    //Deletar Funcionario
    public void excluir(Long id) {
        Funcionario funcionarioexcluir = funcionarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Funcionário não encontrado!"));
        funcionarioRepository.delete(funcionarioexcluir);
    }

}