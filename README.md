# API de Monitoramento Térmico de Transformadores

API RESTful desenvolvida em **Java** com **Spring Boot** para gestão de ativos elétricos (transformadores), registro de leituras térmicas, emissão de alertas e controle dos técnicos responsáveis pela manutenção. O projeto segue uma arquitetura em camadas (Controller → Service → Repository) e conta com documentação interativa via Swagger/OpenAPI.

## ✨ Funcionalidades

- Cadastro de transformadores
- Listagem de todos os transformadores
- Busca detalhada de um transformador pelo número de série (incluindo técnicos, leituras térmicas e alertas vinculados)
- Remoção de transformador
- Modelagem de leituras térmicas (temperatura do óleo e do enrolamento) por transformador
- Modelagem de alertas térmicos vinculados a uma leitura e a um transformador
- Modelagem de técnicos responsáveis, com relação N:N com transformadores
- Documentação da API gerada automaticamente (Swagger UI)

## 🛠️ Tecnologias utilizadas

- Java
- Spring Boot
- Spring Web (MVC)
- Spring Data JPA
- Lombok
- springdoc-openapi (Swagger UI)
- Maven

> Como o `pom.xml` e o `application.properties` não foram fornecidos, ajuste esta lista e a seção de configuração de banco de dados conforme a versão do Java, o banco utilizado (ex.: PostgreSQL, MySQL) e demais dependências reais do projeto.

## 🗺️ Modelo de domínio

| Entidade | Descrição | Relacionamentos |
|---|---|---|
| `Transformador` | Ativo elétrico monitorado (número de série, modelo, subestação, potência, limites de temperatura) | N:N com `Tecnico`; 1:N com `LeituraTermica`; 1:N com `AlertaTermico` |
| `LeituraTermica` | Medição de temperatura do óleo e do enrolamento em um instante | N:1 com `Transformador`; 1:1 com `AlertaTermico` |
| `AlertaTermico` | Alerta emitido a partir de uma leitura térmica que ultrapassa os limites do transformador | N:1 com `Transformador`; 1:1 com `LeituraTermica` |
| `Tecnico` | Técnico responsável pela manutenção (CPF, nome, especialidade, e-mail) | N:N com `Transformador` |

## 📁 Estrutura do projeto

```
src/main/java/br/com/ctw/monitoramento_transformadores
├── MonitoramentoTransformadoresApplication.java  # Classe principal da aplicação
├── config/
│   └── ConfigGlobal.java                # Configuração do Swagger/OpenAPI
├── controller/
│   └── TransformadorController.java     # Endpoints REST de Transformador
├── dto/
│   ├── TransformadorRequestDTO.java     # DTO de entrada para criação
│   ├── TransformadorUpdateDTO.java      # DTO de entrada para atualização
│   ├── TransformadorResponseDTO.java    # DTO de saída (resumido)
│   └── TransformadorDetalhadoDTO.java   # DTO de saída (com técnicos, leituras e alertas)
├── entity/
│   ├── Transformador.java
│   ├── LeituraTermica.java
│   ├── AlertaTermico.java
│   └── Tecnico.java
├── mapper/
│   └── TransformadorMapper.java         # Conversão entre Entity e DTOs
├── repository/
│   ├── TransformadorRepository.java
│   ├── LeituraTermicaRepository.java
│   ├── AlertaTermicaRepository.java
│   └── TecnicoRepository.java
└── service/
    └── TransformadorService.java        # Regras de negócio
```

## ⚙️ Pré-requisitos

- JDK instalado (versão a definir conforme `pom.xml`)
- Maven instalado (ou usar o wrapper `./mvnw`, se incluído no projeto)
- Banco de dados relacional configurado (a definir conforme `application.properties`)

## ▶️ Como executar

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/seu-repositorio.git
cd seu-repositorio

# Execute a aplicação
./mvnw spring-boot:run
```

A aplicação sobe por padrão em `http://localhost:8080`.

## 📖 Documentação da API (Swagger)

```
http://localhost:8080/swagger-ui.html
```

## 📌 Endpoints disponíveis

| Método | Endpoint atual | Descrição |
|--------|-----------------|-----------|
| POST   | `/api/v1/transformadores/api/v1/transformadores` | Cadastra um novo transformador |
| GET    | `/api/v1/transformadores/api/v1/transformadores` | Lista todos os transformadores |
| GET    | `/api/v1/transformadores/api/v1/transformadores/{numeroSerie}` | Retorna os dados detalhados de um transformador pelo número de série |
| DELETE | `/api/v1/transformadores/api/v1/transformadores/{numeroSerie}` | Remove um transformador pelo número de série |

> ⚠️ **Atenção — bug de rota**: o `@RequestMapping("/api/v1/transformadores")` está declarado na classe **e repetido** em cada `@PostMapping`/`@GetMapping`/`@DeleteMapping`, duplicando o prefixo no caminho final (acima refletido). O caminho pretendido, seguindo a convenção do restante do projeto, provavelmente é apenas `/api/v1/transformadores` (e `/api/v1/transformadores/{numeroSerie}`). Recomenda-se remover o path repetido das anotações de método, deixando-as como `@PostMapping`, `@GetMapping`, `@GetMapping("/{numeroSerie}")` e `@DeleteMapping("/{numeroSerie}")`.

### Exemplo de criação de transformador

**Requisição** `POST /api/v1/transformadores` *(caminho pretendido, após correção da rota)*

```json
{
  "numeroSerie": "TR-2024-001",
  "modelo": "Trifásico 500kVA",
  "subestacao": "Subestação Norte",
  "potenciaKva": 500.00,
  "limiteTempOleo": 95.0,
  "limiteTempEnrol": 105.0
}
```

**Resposta** `200 OK`

```json
{
  "id": 1,
  "numeroSerie": "TR-2024-001",
  "modelo": "Trifásico 500kVA",
  "subestacao": "Subestação Norte",
  "potenciaKva": 500.00,
  "limiteTempOleo": 95.0,
  "limiteTempEnrol": 105.0
}
```

### Exemplo de busca detalhada por número de série

**Requisição** `GET /api/v1/transformadores/TR-2024-001`

**Resposta** `200 OK`

```json
{
  "id": 1,
  "numeroSerie": "TR-2024-001",
  "modelo": "Trifásico 500kVA",
  "subestacao": "Subestação Norte",
  "potenciaKva": 500.00,
  "limiteTempOleo": 95.0,
  "limiteTempEnrol": 105.0,
  "tecnicos": [],
  "alertaTermico": [],
  "leituraTermica": []
}
```

## 🐞 Problemas conhecidos

- **Duplicação de path no controller**: ver aviso na seção de endpoints acima.
- **`TransformadorMapper.toUpadate`**: o método monta a entidade atualizada, mas retorna `null` em vez de `transformador`; além disso, não há endpoint `PUT`/`PATCH` no `TransformadorController` que utilize o `TransformadorUpdateDTO`.
- **Tratamento de erros**: o `TransformadorService` lança `RuntimeException` genérica quando um transformador não é encontrado, sem um handler global (`@RestControllerAdvice`) para padronizar a resposta de erro — diferente do padrão adotado em outros projetos da equipe.
- **`TransformadorRequestDTO` com campo `id`**: o DTO de criação aceita um `id` vindo do cliente, o que normalmente não é desejado em um cadastro (o ID deveria ser gerado pelo banco).

## ✅ Validações

Atualmente os DTOs (`TransformadorRequestDTO`, `TransformadorUpdateDTO`) não possuem anotações de Bean Validation (`@NotNull`, `@NotBlank`, etc.). Recomenda-se adicioná-las para garantir consistência dos dados de entrada, seguindo o padrão dos demais projetos.

## 🚧 Roadmap

- [ ] Corrigir duplicação de rota no `TransformadorController`
- [ ] Implementar endpoint de atualização (`PUT`/`PATCH /api/v1/transformadores/{numeroSerie}`)
- [ ] Corrigir retorno do `TransformadorMapper.toUpadate`
- [ ] Adicionar tratamento global de exceções (`GlobalExceptionHandler`)
- [ ] Adicionar validações de entrada (Bean Validation) nos DTOs
- [ ] Endpoints dedicados para `LeituraTermica`, `AlertaTermico` e `Tecnico`
- [ ] Regra de negócio para geração automática de `AlertaTermico` quando uma leitura ultrapassa os limites do transformador

## 👤 Autor

Desenvolvido por Luigi Lombardo.
