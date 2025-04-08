package com.example.atividadePontuada.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

        @GetMapping("/welcome")
        public String welcome() {
            return "Seja bem vindo ao cadastro de funcionarios ✅";
        }



        @GetMapping("/dev")
        public String getDesenvolvedor() {
            return "Desenvolvedor: Silvestre Ferreira 👻🤖";
        }
    }
