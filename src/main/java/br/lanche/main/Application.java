package br.lanche.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.lanche.dominio.Ingrediente;
import br.lanche.dominio.OpcaoCardapio;
import br.lanche.dominio.OpcaoIngrediente;
import br.lanche.repository.IngredienteRepository;
import br.lanche.repository.OpcaoCardapioRepository;
import br.lanche.repository.OpcaoIngredienteRepository;

/**
 * Executar nossa aplicação que irá rodar com o servidor embarcado
 * @author Herivelton Paiva
 * */
@ComponentScan(value = "br.lanche.web")
@EnableJpaRepositories(basePackages = {"br.lanche.repository"})
@EntityScan(basePackages = {"br.lanche.dominio"})
@SpringBootApplication
public class Application {
	
	@Autowired IngredienteRepository repository;
	@Autowired OpcaoIngredienteRepository opcaoRepository;
	@Autowired OpcaoCardapioRepository opcaoCardapioRepository;
	
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
	

	@Bean
	CommandLineRunner runner(){
		return args -> {
			
			carregarIngredientes();
			carregarOpcoesCardapio();
			
		};
	}
    
	private void carregarOpcoesCardapio() {
		OpcaoCardapio xBacon = opcaoCardapioRepository.save(new OpcaoCardapio(1, "X-Bacon"));
		carregarOpcaoIngrediente(xBacon, repository.findById(2));
		carregarOpcaoIngrediente(xBacon, repository.findById(3));
		carregarOpcaoIngrediente(xBacon, repository.findById(5));
		
		OpcaoCardapio xBurguer = opcaoCardapioRepository.save(new OpcaoCardapio(2, "X-Burger"));
		carregarOpcaoIngrediente(xBurguer, repository.findById(3));
		carregarOpcaoIngrediente(xBurguer, repository.findById(5));
		
		OpcaoCardapio xEgg =  opcaoCardapioRepository.save(new OpcaoCardapio(3, "X-Egg"));
		carregarOpcaoIngrediente(xEgg, repository.findById(3));
		carregarOpcaoIngrediente(xEgg, repository.findById(4));
		carregarOpcaoIngrediente(xEgg, repository.findById(5));
		
		OpcaoCardapio xEggBacon =  opcaoCardapioRepository.save(new OpcaoCardapio(4, "X-Egg Bacon"));
		carregarOpcaoIngrediente(xEggBacon, repository.findById(2));
		carregarOpcaoIngrediente(xEggBacon, repository.findById(3));
		carregarOpcaoIngrediente(xEggBacon, repository.findById(4));
		carregarOpcaoIngrediente(xEggBacon, repository.findById(5));
		
		opcaoCardapioRepository.save(new OpcaoCardapio(5, "Customizado"));
		
		System.out.println("Opções iniciais do cardápio cadastrada com sucesso!");
	}

	private void carregarOpcaoIngrediente(OpcaoCardapio op, Ingrediente ingrediente){
		opcaoRepository.save(new OpcaoIngrediente(op, ingrediente, 1));
	}

	private void carregarIngredientes() {
		repository.save(new Ingrediente(1, "Alface", 0.40));
		repository.save(new Ingrediente(2, "Bacon", 2D));
		repository.save(new Ingrediente(3, "Hambúrguer", 3D));
		repository.save(new Ingrediente(4, "Ovo", 0.80));
		repository.save(new Ingrediente(5, "Queijo", 1.50));
		
		System.out.println("Ingredientes iniciais cadastrado com sucesso!");
	}
}
