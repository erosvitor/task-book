## Sobre
Projeto criado no curso API REST com Spring Boot.

## Requisitos
* Java 17.x.x
* Maven 3.8.5
* MySQL 8.x.x

## Preparando o projeto
1. Criar o banco de dados
```
CREATE DATABASE taskbook;

USE taskbook;

CREATE TABLE tasks (
  id INTEGER NOT NULL AUTO_INCREMENT,
  description VARCHAR(100) NOT NULL,
  initial_date DATE NOT NULL,
  final_date DATE NOT NULL,
  PRIMARY KEY (id)
);
```

2. Clonar a aplicação
```
git clone https://github.com/erosvitor/task-book.git
```

3. Construir o projeto
```
mvn package
```

4. Executar o projeto
```
java -jar task-book-1.0-SNAPSHOT.jar
```

## Usando o projeto
Executar o Postman e criar as seguintes requisições

1. Inserir uma tarefa
```
POST http://localhost:8080/task

{
  "description": "Finalizar curso API REST com Spring Boot",
  "initialDate": "2022-12-26",
  "finalDate": "2022-12-29"
}
```

2. Listar todas as tarefas
```
GET http://localhost:8080/task
```

3. Atualizar uma tarefa
```
PUT http://localhost:8080/task

{
  "id": 1,  
  "description": "Finalizar curso API REST com Spring Boot",
  "initialDate": "2022-12-26",
  "finalDate": "2022-12-27"
}
```

4. Excluir uma tarefa
```
DELETE http://localhost:8080/task/1
```

## Licença
Este projeto está sob licença do MIT. Para mais detalhes, ver o arquivo LICENSE.
