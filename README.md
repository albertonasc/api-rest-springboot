# API RESTful 
API RESTful com Spring Boot, Java, H2 DataBase
### Como executar a aplicação
```
git clone https://github.com/albertonasc/api-rest-springboot
cd api-rest-springboot
mvn spring-boot:run
Acesse http://localhost:8080/api/v1/books
```
### APIs endpoints
* GET http://localhost:8080/api/v1/books [lista todos os livros]  
* GET http://localhost:8080/api/v1/books/{id} [lista um livro por ID]  
* GET http://localhost:8080/api/v1/books/client/{clientId}/books [lista de livros emprestados]  
* POST http://localhost:8080/api/v1/books/{bookId}/reserve [reserva de livro]
* PUT http://localhost:8080/api/v1/books/{bookId}/return [devolver livro]

