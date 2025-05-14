# 🛒 Sistema de Pedidos com Autenticação e Integração SQS

Sistema em Java para gerenciamento de pedidos com autenticação JWT e integração com fila SQS (via LocalStack).

## ✅ Funcionalidades

- Autenticação com JWT
- Controle de acesso (ADMIN/USER)
- Criação de pedidos com múltiplos itens
- Envio dos pedidos para serviço de estoque via SQS

## 🛠 Tecnologias

- Java 21+
- Spring Boot & Security
- JWT
- AWS SQS (LocalStack)
- PostgreSQL
- Docker
- Postman (testes)

## 📋 Pré-requisitos

- Java 21+
- Docker (LocalStack e PostgreSQL)
- Serviço de estoque rodando com fila `fila-pedidos` criada
- Postman ou similar

## 🚀 Testes com Postman

### 🔐 Autenticação

**Registrar:**



POST http://localhost:8080/auth/register
Body:
{
"login": "admin",
"password": "senha123",
"role": "ADMIN"
}



**Login:**

POST http://localhost:8080/auth/login
Body:
{
"login": "admin",
"password": "senha123"
}


→ Receberá um token JWT (válido por 2h) para usar nos próximos endpoints.

### 📦 Criar Pedido


POST http://localhost:8080/pedidos
Headers:
Authorization: Bearer <SEU_TOKEN>
Body:
{
"cliente": "Maria",
"itens": [
{ "produtoId": 1001, "quantidade": 1 },
{ "produtoId": 2002, "quantidade": 1 }
]
}


## 💡 Respostas Esperadas

- `200 OK`: Pedido criado com sucesso
- `401`: Token ausente ou inválido
- `403`: Permissão negada
- `503`: Serviço de estoque indisponível

## ⚠️ Observações

- Apenas usuários `ADMIN` podem criar pedidos
- Verifique se o serviço de estoque está ativo
- Fila `fila-pedidos` deve existir no LocalStack

## 🔧 Configuração AWS (dev)

```properties
spring.cloud.aws.credentials.access-key=test
spring.cloud.aws.credentials.secret-key=test


