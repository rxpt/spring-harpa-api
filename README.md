# Harpa API (com Spring Boot)

API RESTful para acessar hinos da Harpa Cristã.

## Recursos

- **Endpoints:**
  - Listar todos os hinos `(GET /hymns)`
  - Obter hino por ID `(GET /hymns/:id)`
  - Buscar por título `(GET /hymns/search/title/:query)`
  - Buscar por estrofe `(GET /hymns/search/verse/:query)`
  - Buscar por número `(GET /hymns/search/number/:number)`
  - Obter hino aleatório `(GET /hymns/random)`

## Tecnologias

- Java 17
- Spring Boot 3.3.1
- Maven
- MongoDB

## Instalação e Uso

1. **Requisitos:** Java 17 e MongoDB instalados.
2. **Clonar:** `git clone https://github.com/rxpt/spring-harpa-api.git`
3. **Instale as dependências e compile o projeto:** `mvn clean install`
4. **Configurar:**
   - Copiar `application.properties.example` para `application.properties`
   - Editar `application.properties` com suas configurações
5. **Popular o banco de dados:**
   - Os dados para popular o banco de dados estão presentes em `hymns-data.json`.
6. **Iniciar:** `mvn spring-boot:run`
