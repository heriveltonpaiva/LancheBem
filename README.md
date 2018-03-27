# LancheBem
Sistema para Vendas de Lanches

#Tecnologias Utilizadas: 
Java 8
Spring Boot 1.5.10 (parent e web)
Apache Tomcat/8.5.27 (Embarcado) 


## Detalhes Técnicos de Implementação 
- Implementação da Lógica de cálculo para o valor do lanche 
a) Caso seja a estratégia Carne ou Queijo será realizado alteração na entidade
OpçãoIngrediente alterando o valorDesconto  
b) Caso seja a estratégia Light, será dado o desconto de 10% considerando o atributo
valorOriginal da entidade OpcaoCardapio 

- calcularPromocaoDesconto(OpcaoCardapio lanche)
Método responsável por realizar o cálculo dos lanches considerando as RN's 

- adicionarIngrediente(Ingrediente ingrediente, int qnt, OpcaoCardapio lanche)
Método responsável por realizar a adição de 1 ingrediente ao lanche, 
realizando os cálculos chamando o método calcularPromocaoDesconto(OpcaoCardapio lanche)
quando necessário. 

- adicionarOpcaoAoPedido(OpcaoCardapio opcao, Pedido pedido)
Método que adiciona uma opção do cardápio ao pedido realizado. 

- OpcaoCardapio criarMontarMeuHamburguer(Ingrediente...opcaoIngrediente)
O Método tem como finalizar realizar a confecção de um lanche de acordo
com os ingredientes solicitados pelo cliente.

- public class CardapioBuilder 
Classe responsável por realizar a construção dos ingredientes com seus respectivos
valores e as opções do cardápio. 