# To Do List REST API

API simples que simula uma lista de coisas a fazer(to do list), desenvolvida utilizando o framework Spring e o banco de dados PostgreSQL.

# Métodos e respostas.

## Cadastrar nova tarefa

`POST /tarefas`
  
    {
    	"descricao": "Fazer compras" ,
	"prazo": "2021-05-17T15:00:00"
    }
    
  #### Novas tarefas são cadastradas como não completas
  
  ### Resposta
  
    Status: 201 Created
    
    {
     	"id": 1,
      	"descricao": "Fazer compras",
      	"prazo": "2021-05-17T15:00:00",
      	"completa": false
    }


## Obter tarefas cadastradas

`GET /tarefas`

### Resposta

  Status: 200 OK

  [
  	{
		"id": 1,
		"descricao": "Fazer compras",
		"prazo": "2021-05-17T15:00:00",
		"completa": false
	}
  ]
  
## Obter tarefa específica a partir do Id

`GET /tarefas/id`
  
    
  ### Respostas
  
  #### Tarefa existente  
    Status: 200 OK
    
    {
    	"id": 1,
      	"descricao": "Fazer compras",
      	"prazo": "2021-05-17T15:00:00",
      	"completa": false
    }
    
   #### Tarefa não existente
    Status: 404 Not Found


## Alterar tarefa

`PUT /tarefas/id`
  
    {
	"descricao": "update" ,
	"prazo": "2022-05-17T18:00:00",
	"completa" : "true"
    }
    
  ### Respostas
  
   #### Tarefa existente  
    Status: 200 OK
    
    {
    	"id": 1,
      	"descricao": "update",
      	"prazo": "2021-05-17T15:00:00",
      	"completa": true
    }
    
   #### Tarefa não existente
    Status: 404 Not Found


## Deletar tarefa

`DELETE /tarefas/id`
  
  ### Respostas
  
   #### Tarefa existente  
    Status: 204 No Content
    
   #### Tarefa não existente
    Status: 404 Not Found


