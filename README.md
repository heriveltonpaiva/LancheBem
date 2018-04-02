## LancheBem
Projeto back-end que fornece os serviços para um sistema de vendas.

Endereço do Client: https://github.com/heriveltonpaiva/lancheclient 

### Tecnologias Utilizadas: 
Java 8
Spring Boot 1.5.10 
Spring Data Rest 
Sprint Data JPA
h2database

### Rodar o projeto 
Tenha o Maven instalado, abra o prompt e rode o comando:

[SeuDiretorio]\lanchebem-master> mvn spring-boot:run 

Após o maven baixar as dependências e construir o seu projeto os serviços estarão disponíveis
para ser consumido via REST 

#### Consultando Ingredientes (JSON): 
http://localhost:8080/ingredientes 

#### Consultado Opções do Cardápio (JSON):
http://localhost:8080/opcoesCardapio
