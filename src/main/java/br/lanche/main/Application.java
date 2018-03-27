package br.lanche.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Executar nossa aplicação que irá rodar com o servidor embarcado
 * @author Herivelton Paiva
 * */
@ComponentScan(value = "br.lanche.web")
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
