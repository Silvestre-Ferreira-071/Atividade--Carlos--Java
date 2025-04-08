package com.example.atividadePontuada.repository;

import com.example.atividadePontuada.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    // Aqui você pode adicionar métodos personalizados, se necessário
    Optional<Funcionario> findByEmail(String email);
    boolean existsByEmail(String email);
}
