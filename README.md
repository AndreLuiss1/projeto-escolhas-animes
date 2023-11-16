# projeto-escolhas-filmes
Nesse projeto irei criar um lugar aonde te auxilia a escolha de um filme.

# Nome do desenvolvedor e RA
André Luis Costa Da Silva Ra:202113316

# Descrição do projeto 
Camada de Modelo (Model):

Anime:
Representa a entidade principal do seu domínio, com atributos como título, gênero, ano, episódios e se é um filme.
Camada de Serviço (Service):

AnimeService:
Define a interface para operações relacionadas a Anime, como criar, listar, obter por ID, atualizar e excluir.
AnimeServiceImpl implementa essa interface e fornece a lógica de negócios para essas operações.
Camada de Controle (Controller):

AnimeFilter:
Controlador REST que expõe endpoints para realizar operações CRUD em Anime.
Utiliza AnimeService para executar as operações necessárias.
Configuração do Spring:

Application:
Classe principal com o método main para iniciar a aplicação Spring Boot.
Anotada com @SpringBootApplication para configuração automática do Spring Boot.
