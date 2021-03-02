# CRUD-Spring-Next.Js

## Descrição do projeto:
 
Uma aplicação para realizar cadastro, deleção e atualização de clientes utilizando autenticação de usuários.

Sumário
=================
<!--ts-->
   * [Descrição do Projeto](#descrição-do-projeto)
   * [Sumário](#sumário)
   * [Como instalar e rodar o projeto](#Como-instalar-e-rodar-o-projeto)
      * [Pré Requisitos](#pré-requisitos)
      * [Build do Projeto](#build-do-projeto)
   * [Uso e Testes](#uso-e-testes)
        * [Uso e Endpoints Liberados](#uso-e-endpoints-liberados)
        * [Testes](#testes)
   * [Utilizando o Postman](#utilizando-o-postman)
        * [Erro Login](#erro-login)
        * [Login](#login)
        * [Requisições](#requisições-usuário-comum)
        * [Erros](#erros-nas-requisições)
* [Considerações Finais](#considerações-finais)
<!--te-->



## Tecnologias utilizadas: 

* Spring Boot - A aplicação foi construída inteiramente em java utilizando-se dos recursos do framework para construir uma API REST.

* H2 - Banco de dados em memória para facilitar os testes da persistência de dados dos clientes.

* Lombok - Lib utilizada para deixar o código mais limpo, facilitando o uso de getters e setters, por exemplo.

* Tokens JWT - Em assistência do Spring Security, método utilizado para autenticação que consiste em um token formado por "Bearer " e as informações do usuário codificados.

# Como instalar e rodar o projeto: 

## Pré Requisitos:

Para poder rodar o projeto na sua máquina é necessário ter instalado [Maven](https://maven.apache.org/download.cgi) e [Java](https://www.oracle.com/technetwork/pt/java/javase/downloads/index.html) (Sendo necessário pelo o menos a versão 8.0 do Java), caso utilizem o docker-compose é necessário ter instalado também o [Docker](https://www.docker.com/products/docker-desktop).


## Build do projeto:

Após baixar o projeto, abra o terminal de comando na raíz do projeto e execute o seguinte comando:

```sh
mvn clean package
```

Este comando irá gerar um arquivo .jar compilado que pode ser executado com o seguinte comando: 

```sh
java -jar CRUD-Spring-Next.Js-Backend
```

Também é possível subir a aplicação para um container via Docker, para isso utilizar o comando:

```sh
docker-compose up
```
Ou, caso deseje deixar em background e continuar usando o terminal,

```sh 
docker-compose up -d
```
Após subir a aplicação, acesse http://localhost:8080/free/ para conferir se não houve nenhum erro durante a execução da aplicação.

# Uso e Testes

## Uso e endpoints liberados

Após conferir o funcionamento da API é possível testar a aplicação, primeiro, vale ressaltar que essa é uma aplicação protegida via autenticação com tokens JWT, com apenas 2 endpoints liberados sem autenticação: o primeiro, /free/ foi testado durante a execução da aplicação, já o segundo consiste em um endpoint para poder acessar o banco de dados H2, caso deseje conferir a criação das tabelas e dados iniciais antes de testar a aplicação acesse http://localhost:8080/h2-console.

## Testes

Para auxiliar nos testes foi criada uma coleção no postman, assim se torna bem mais simples acessar os dados da aplicação, para acessar a coleção basta acessá-la pelo botão abaixo:

[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/07f518c0c1269116731b)

# Utilizando o Postman

A coleção criada no postman foi criada pensando no melhor    aproveitamento da aplicação, tentando abrangir ao máximo todas as possíveis situações de sucesso e erros, utilizando-se de testes para isso e visando a simplicidade. Para isso ela foi dividida em pastas, cada pasta contendo diversas requisições para diversos endpoints da aplicação.

Dito isso, recomenda-se seguir a ordem das pastas e das requisições
que serão detalhadas abaixo:

## Erro login

Pasta criada para mostrar erro ao logar com credenciais erradas.

## Login

Pasta criada para as requisições de login, nesta aplicação temos 2 usuários: 

* admin (username: admin, password: 123456)
* comum (username: comum, password: 123456)


<p align ="justify">
Após o login, é necessário, em cada requisição enviar um token de autorização, que no caso estará contido no Header da requisição enviada, para facilitar isso nas próximas pastas a seguir realize as etapas:
</p>

1. Na Response, clique na aba Headers.
2. Copie o token em Authorization, sem o "Bearer".
3. Clique na pasta, exemplo: Requisições Usuário comum.
4. Em Authorization, na aba Type selecione "Bearer Token".
5. Cole o token(Sem o "Bearer") no campo Token.

Pronto, agora você está autenticado e autorizado a usar a aplicação, para demonstrar a expiração do token, foi colocado um tempo de 30 minutos, após isso será necessário fazer outro login.

## Requisições usuário comum

Requisições para demonstrar a autorização de um usuário comum (apenas leitura).

## Requisições sucedidas

Requisições de um usuário admin que devem ser bem sucedidas, isto é, não se espera erros.

## Erros nas requisições

Requisições para abordar e testar todos os erros tratados na aplicação.

## Erros de validação

Erros caso o usuário esqueça algum campo obrigatório, ou dê valores inválidos para determinados campos, entre outros, ao adicionar ou atualizar clientes.

# Considerações finais

* Não foi pedido para utilizar um banco de dados, por isso utilizei o h2, além de ser mais prático para implementar e rodar em modo de testes, mas, caso fosse continuar desenvolvendo uma aplicação como esta implementaria o uso do PostgreSQL para armazenar os dados dos clientes.
* Por conta de não necessitar salvar múltiplos endereços os deixei como propriedades do próprio cliente como objeto, mas para um controle maior poderia criar uma entidade só para os endereços, assim possibilitando um maior isolamento das propriedades do cliente.
* Uma sugestão de atualização da aplicação seria implementar um serviço de e-mail para envios de e-mail de confirmação de cadastro de clientes, entre outros.
*Outra sugestão seria o cadastro de Novos usuários tal qual uma função de "esqueci minha senha".




