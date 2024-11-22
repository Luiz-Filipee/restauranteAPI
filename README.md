# Sistema de Gestão de um Restaurante

Sistema de Gestão de um Restaurante é um sistema web de gerenciamento de um restaurante desenvolvido para realizar a gestão de pedidos, e mesas de um restaurente. Será um aplicativo web utilizado em um tablet pelos garçons do estabelecimento. Cada mesa poderá ser atribuida a um cliente já cadastrado e a partir disso, um pedido pode ser feito a cozina.

## Funcionalidades

  # CRUD Mesa
    - **Adicionar Mesa:** O usuário pode cadastrar um nova mesa inserindo nome do cliente, nome do garçom e status da mesa.
    - **Editar Mesa:** O usuário pode atualizar as informações de um mesa existente.
    - **Deletar Mesa:** O usuário pode excluir um mesa da lista.
    - **Listar Mesa:** Todos as mesas cadastradas são exibidos em uma lista interativa, permitindo fácil visualização e gerenciamento.
  # CRUD Pedidos
    - **Adicionar Pedido:** O usuário pode cadastrar um novo pedido nome do cliente, nome do garçom, itens do pedido.
    - **Editar Pedido:** O usuário pode atualizar as informações(como status do pedido) de um Pedido existente.
    - **Deletar Pedido:** O usuário pode excluir um Pedido da lista.
    - **Listar Pedido:** Todos os Pedidos cadastrados são exibidos em uma card com uma lista interativa.
  # CRUD Clientes
    - **Adicionar Cliente:** O usuário pode cadastrar um novo cliente, nome, telfone.
    - **Deletar Cliente:** O usuário pode excluir um cliente.

## Estrutura do Projeto

- `src/`
  - `main/`
      - `java/`
        - `com.luifilipehenriquelenis.restaurante.api/`
          - `models/`
            - **Cliente**: Entidade para representar clientes.
            - **Funcionario**: Entidade para representar funcionarios.
            - **MenuItem**: Entidade para representar itens do pedido.
            - **Mesa**: Entidade para representar mesas.
            - **Pedido**: Entidade para respresentar pedido.
            - **Autenticacao**: Entidade para respresentar autenticacao.
            - **MessageResponse**: Entidade para respresentar mensagens de erro na aplicacao.
          - `controllers/`
            - **ClienteController**: Classe de controler dos clientes.
            - **FuncionarioController**: Classe de controler dos funcionarios.
            - **MenuItemController**: Classe de controler de itens do pedido.
            - **MesaController**: Classe de controller de mesa.
            - **PedidoController**: classe de controller de pedido.
            - **AutenticacaoController**: classe de controller de pedido.
          - `repositories/`
            - **ClienteRepository**: Classe de repository dos clientes.
            - **FuncionarioRepository**: Classe de repository dos funcionarios.
            - **MenuItemRepository**: Classe de repository dos itens dos pedidos.
            - **MesaRepository**: Classe de repository das mesas.
            - **PedidoRepository**: Classe de repository dos pedidos.
            - **AutenticacaoRepository**: Classe de repository dos pedidos.
          - `config/`
          - **WebConfgi**: Arquivos de configuracao do servidor cross-origin.
 
## Estrutura do Projeto
    - **Java:** Back-End.
    - **Angular:** Front-end.

![Captura de tela 2024-11-22 155401](https://github.com/user-attachments/assets/d3e3421a-58e2-4fbd-9d01-68eed7397017)
![Captura de tela 2024-11-22 155406](https://github.com/user-attachments/assets/c19dcdbc-13fd-48ce-ab82-b74b639cae03)
![Captura de tela 2024-11-22 155412](https://github.com/user-attachments/assets/3b6f51a2-ebe0-4d17-b7be-147f6436483e)


## Tecnologias utilizada
  #PHP: Back-End.
  #Angular: Front-End.

## Instalação

1. Clone este repositório:
   ```bash
   git clone https://github.com/seu-usuario/restaurantephpapi.git
   cd restaurantephpapi

2. Instale as dependecias do spring initializer
   ```bash
   maven

3. Rode a aplicacao
