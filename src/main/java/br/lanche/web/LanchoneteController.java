package br.lanche.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LanchoneteController {

    @RequestMapping("/")
    public String index() {
        return "Olá Amigos, Eu me chamo Herivelton!";
    }

}
