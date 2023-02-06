# Projeto MapFood

[![Build Status](https://travis-ci.com/britalodev/codenationMapFood.svg?branch=master)](https://travis-ci.com/britalodev/codenationMapFood)

[Detalhes técnicos](DETALHES_TECNICOS.md)

## Descrição 

Para utilizar a metodologia CBL - Challenge Based Learning, os participantes do programa executarão um projeto real baseado nos aprendizados que recebem dos tutores,  mentores e equipes da Code:Nation e da Movile. Para isso, os selecionados serão divididos em squads para execução do projeto MapFood.

O objetivo do squad é fornecer autonomia para que cada equipe tome decisões e que cada integrante descubra seu papel dentro do grupo, tornando-os aptos a resolver problemas reais por conta própria.

--- 
🇬🇧 ## Description

To use the CBL - Challenge Based Learning methodology, program participants will carry out a real project based on the learning they receive from tutors, mentors and teams from Code:Nation and Movile. For this, those selected will be divided into squads to execute the MapFood project.

The objective of the squad is to provide autonomy for each team to make decisions and for each member to discover their role within the group, making them able to solve real problems on their own.
---
## Objetivo:

O objetivo do projeto é criar uma API para organizar os pedidos e gerar os melhores trajetos de entrega do iFood.

🇬🇧 ## Goal:

The aim of the project is to create an API to organize orders and generate the best iFood delivery routes.

---

## Contextualização

Utilizando um conjunto de dados da plataforma iFood, contendo informações como estabelecimentos conveniados, suas localizações e produtos, os participantes deverão construir uma API para gerenciar essas informações, além de uma base com os motoristas que farão as entregas e respectivas listas de pedidos (contando com clientes e localização). A API deverá apresentar o melhor trajeto e também poderá trazer outras informações (a critério das squads), como gasto de cada estabelecimento com a quilometragem rodada, tempo de entrega, etc.

Ao final do programa, além de apresentar a API criada, cada squad deverá expor quais são os pontos de melhoria e quais seriam os próximos passos no projeto, caso fossem seguir adiante.


 🇬🇧 ## Context

Using a set of data from the iFood platform, containing information such as affiliated establishments, their locations and products, participants must build an API to manage this information, in addition to a base with the drivers who will make the deliveries and the respective order lists (with customers and location). The API must present the best route and can also bring other information (at the discretion of the squads), such as the cost of each establishment with the mileage traveled, delivery time, etc.

At the end of the program, in addition to presenting the API created, each squad should explain what are the points of improvement and what would be the next steps in the project, if they were to move forward.

---
## Requisitos técnicos obrigatórios

Para o projeto MapFood, é necessário que as squads se utilizem dos aprendizados repassados pelo programa AceleraDev, portanto a solução deve ser construída de acordo com os seguintes requisitos:

- Banco de dados;
- Desenvolvimento do backend e APIs com Java Spring Boot;
- Testes unitários são um bônus importante


🇬🇧 ## Mandatory technical requirements

For the MapFood project, it is necessary for the squads to use the learnings passed on by the AceleraDev program, so the solution must be built according to the following requirements:

- Database;
- Development of backend and APIs with Java Spring Boot;
- Unit tests are a major bonus


---


## Definições do sistema MapFood

- Um motoboy pode levar no máximo 5 pedidos por entrega independente do número de itens do pedido;
- O tempo de preparação de cada pedido é 10 minutos;
- Consumo motocicleta: 42km/L
- Entende-se por pedido como uma solicitação de entrega feita por um usuário, sendo que o mesmo pode conter diversos itens (cachorro quente, batata frita, refrigerante, etc);
- Para o tempo de entrega, é importante considerar os seguintes parâmetros:
	- Deslocamento do motoboy até o estabelecimento;
	- Deslocamento do motoboy até a entrega do pedido ao cliente.


🇬🇧 ## MapFood system settings

- A motoboy can take a maximum of 5 orders per delivery regardless of the number of items in the order;
- The preparation time for each order is 10 minutes;
- Consumption motorcycle: 42km/L
- An order is understood as a delivery request made by a user, and it may contain several items (hot dog, french fries, soda, etc);
- For delivery time, it is important to consider the following parameters:
- Displacement of the motoboy to the establishment;
- Displacement of the motoboy until the delivery of the order to the customer.

---
## Casos práticos do sistema

Para facilitar o entendimento da API que deverá ser construída, segue abaixo alguns casos práticos de possíveis interações que o sistema pode conter:

**Dado que** um consumidor selecionou um cachorro quente no estabelecimento X
**Quando** o pedido for realizado
**Então** deve-se identificar no sistema qual motoboy deve ser selecionado, qual o respectivo trajeto e informações adicionais do trajeto (ex: quilometragem, tempo de entrega…);

**Dado que** vários pedidos em localizações próximas foram solicitados em um mesmo estabelecimento e em horários próximos
**Quando** o sistema for selecionar o motoboy e respectiva rota
**Então** o mesmo pode levar em consideração a proximidade desses pedidos para utilizar o mesmo motoboy em tais entregas.

**Dado que** um restaurante deseje saber o tempo/quilometragem das entregas do seu estabelecimento
**Quando** o restaurante solicitar tais dados de determinada data
**Então** o sistema poderá gerar um relatório para o mesmo.


🇬🇧 ## Practical cases of the system

To facilitate the understanding of the API that should be built, below are some practical cases of possible interactions that the system may contain:

**Given that** a consumer selected a hot dog at establishment X
**When** the order is placed
**Then** it is necessary to identify in the system which motoboy should be selected, the respective route and additional information on the route (eg mileage, delivery time…);

**Given that** several orders in close locations were requested in the same establishment and at close times
**When** the system selects the motoboy and respective route
**So** it can take into account the proximity of these orders to use the same motoboy in such deliveries.

**Since** a restaurant wants to know the delivery time/mileage of its establishment
**When** the restaurant requests such data for a given date
**Then** the system can generate a report for it.

---

## Informações adicionais

É papel do squad definir quais atributos serão levados em consideração para definir o melhor trajeto. Alguns exemplos são: quilometragem, tempo de entrega, capacidade de buscar e entregar múltiplos pedidos em uma única rota, etc.

Com exceção dos requisitos técnicos obrigatórios, as funcionalidades e seus atributos podem ser alterados livremente por cada squad, desde que as alterações sejam justificáveis. Exemplos: em tempo de desenvolvimento, nova ideia que facilite o uso pelo usuário, melhorias na geração das rotas de entrega, etc.

É necessário que apenas uma pessoa do squad faça a submissão dos códigos para que os mentores possam fazer a avaliação.

🇬🇧 ## Additional Information

It is the role of the squad to define which attributes will be taken into account to define the best route. Some examples are: mileage, delivery time, ability to pick up and deliver multiple orders on a single route, etc.

With the exception of mandatory technical requirements, the features and their attributes can be freely changed by each squad, as long as the changes are justifiable. Examples: in development time, new idea that facilitates the use by the user, improvements in the generation of delivery routes, etc.

Only one person in the squad needs to submit the codes so that the mentors can carry out the evaluation.

