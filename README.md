Aplicação de Consulta Tabela FIPE (Console)
Este é um projeto simples de aplicação Java de console que permite consultar informações de veículos (carros, motos e caminhões) da Tabela FIPE utilizando a API pública da FIPE.

Funcionalidades
Seleção do Tipo de Veículo: Escolha entre carros, motos ou caminhões.

Listagem de Marcas: Exibe uma lista ordenada das marcas disponíveis para o tipo de veículo selecionado.

Busca de Modelos: Filtra modelos de veículos com base em um trecho do nome digitado.

Detalhes do Veículo: Consulta valores e avaliações específicas para um modelo em diferentes anos.

Como Usar
Execute a classe Principal.

Selecione o Tipo de Veículo: Quando solicitado, digite "Carro", "Moto" ou "Caminhão" e pressione Enter.

Informe o Código da Marca: Após a listagem das marcas, digite o código correspondente à marca desejada e pressione Enter.

Busque o Modelo: Digite um trecho do nome do modelo do veículo (ex: "civic", "titan") e pressione Enter para filtrar os modelos.

Digite o Código do Modelo: Da lista filtrada, insira o código do modelo específico para o qual você deseja obter os detalhes e pressione Enter.

Visualize os Resultados: A aplicação exibirá uma lista de todos os anos disponíveis para o modelo escolhido, juntamente com seus respectivos valores e avaliações da Tabela FIPE.

Estrutura do Projeto (Lógica Principal)
O código fornecido mostra a estrutura central da aplicação, que inclui:

Principal.java: A classe principal que orquestra o fluxo da aplicação e a interação com o usuário via console.

Model/: Pacote que deve conter as classes (ou records, como sugerido pelo uso do Dados com codigo e nome) para mapear os dados JSON retornados pela API da FIPE (ex: Dados, Modelo, Veiculo).

Service/: Pacote que contém as classes de serviço responsáveis pelo consumo da API (ConsumoApi) e pela conversão dos dados JSON para objetos Java (ConverteDados).

Dependências
Este projeto utiliza apenas as bibliotecas padrão do Java. Não são necessárias dependências externas para as funcionalidades básicas de requisição HTTP e processamento JSON, assumindo que as classes ConsumoApi e ConverteDados manipulam isso internamente ou com recursos do JDK.

Caso você adicione bibliotecas específicas para cliente HTTP (como Apache HttpClient, OkHttp) ou para parseamento de JSON (como Jackson, Gson), certifique-se de incluí-las no CLASSPATH do seu projeto.



Como Desenvolver/Executar (Para Desenvolvedores)
Para configurar e rodar este projeto localmente:

-Clone o repositório (se aplicável).

-Abra o projeto em sua IDE Java preferida (ex: IntelliJ IDEA, Eclipse, VS Code).

-Certifique-se de que todas as classes Model e Service estejam corretamente definidas e implementadas para interagir com a API da FIPE.

-Execute o método exibirMenu() da classe Principal.
