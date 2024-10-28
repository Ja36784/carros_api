**Carros API**
**Descrição**
A Carros API é um serviço RESTful que permite gerenciar um inventário de carros. Esta API permite operações como criar, ler, atualizar e deletar informações sobre carros, bem como consultar carros por tipo.

Tecnologias Utilizadas
Java
Spring Boot
JPA (Java Persistence API)
ModelMapper
Lombok

**Estrutura do Projeto**
com.carros.api: Contém os controladores que definem as rotas da API.
com.carros.domain: Contém as classes de domínio, serviços e repositórios.
com.carros.domain.dto: Contém os objetos de transferência de dados (DTOs).

**Endpoints**
1. Listar todos os carros
URL: /api/v1/carros
Método: GET
Resposta: Lista de carros.

2. Obter carro por ID
URL: /api/v1/carros/{id}
Método: GET
Parâmetros:
id: ID do carro.
Resposta: Carro encontrado ou 404 se não existir.

3. Listar carros por tipo
URL: /api/v1/carros/tipo/{tipo}
Método: GET
Parâmetros:
tipo: Tipo do carro.
Resposta: Lista de carros do tipo especificado ou 204 se não houver carros.

4. Adicionar um novo carro
URL: /api/v1/carros
Método: POST
Corpo da Requisição: Objeto Carro em formato JSON.
Resposta: 201 (Criado) e URI do novo carro.

5. Atualizar um carro existente
URL: /api/v1/carros/{id}
Método: PUT
Parâmetros:
id: ID do carro a ser atualizado.
Corpo da Requisição: Objeto Carro em formato JSON.
Resposta: Carro atualizado ou 404 se não existir.

6. Deletar um carro
URL: /api/v1/carros/{id}
Método: DELETE
Parâmetros:
id: ID do carro a ser deletado.
Resposta: 200 (OK) se deletado, ou 404 se não existir.

7. Endpoint de índice
URL: /
Método: GET
Resposta: Mensagem de boas-vindas da API.
