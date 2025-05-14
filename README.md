# Sistema de Pedidos com Integração SQS

## 📋 Pré-requisitos
- Java 21+
- Serviço de estoque deve estar rodando com fila SQS criada *(siga o passo a passo no projeto de estoque)*
- [Postman](https://www.postman.com/) ou similar para testar as requisições

## 🚀 Como Testar via Postman

### 🔧 Configuração da Requisição
| Campo            | Valor                          |
|------------------|--------------------------------|
| **Método**       | `POST`                         |
| **URL**          | `http://localhost:8080/pedidos`|
| **Headers**      | `Content-Type: application/json`|

### 📦 Exemplo de Body (JSON)

{
  "id": 1,
  "cliente": "Maria",
  "itens": [
    {
      "produtoId": 1001,
      "quantidade": 1
    },
    {
      "produtoId": 2002,
      "quantidade": 1
    }
  ]
}

💡 Respostas Esperadas
Status Code	Resposta
200 OK	"Pedido criado e enviado para o sistema de estoque!"
503 Service Unavailable	"Serviço de estoque temporariamente indisponível"


⚠️ Observações Importantes
Verifique se o serviço de estoque está rodando antes de enviar pedidos

Caso receba erro 503:

Confira se o LocalStack está ativo no projeto de estoque

Verifique se a fila fila-pedidos existe no LocalStack
