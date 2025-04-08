package com.example.atividadePontuada.controller;

import org.springframework.web.bind.annotation.*;

import com.example.atividadePontuada.model.Funcionario;
import com.example.atividadePontuada.services.FuncionarioService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping ("/funcionario")
public class FuncionarioController {
    private FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }
    //Setando a opção listar os funcionarios
    @GetMapping ("/listar")
    public List<Funcionario> listarTodos() {
        return funcionarioService.listarTodos();
    }
    //Setando cadastrando funcionarios
    @PostMapping
    public ResponseEntity<Map<String, String>> salvar (@Valid @RequestBody Funcionario funcionario){
        funcionarioService.salvar(funcionario);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("Mensagem", "Funcionário cadastrado com sucesso!"));
    }
    //Setando a opção de atualizar os funcionarios
    @PutMapping
    public ResponseEntity<Map<String, String>> atualizar(@Valid @RequestBody Funcionario funcionario) {
        funcionarioService.atualizar(funcionario);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("Mensagem", "Funcionário atualizado com sucesso!"));
    }
    //Setando a opção de excluir os funcionarios
    @DeleteMapping ("/{id}")
    public ResponseEntity<Map<String, String>> excluir(@PathVariable Long id) {
        funcionarioService.excluir(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("Mensagem", "Funcionário excluído com sucesso!"));
    }



}

