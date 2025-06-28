package br.com.projeto.TabelaFipe.Principal;

import br.com.projeto.TabelaFipe.Model.Dados;
import br.com.projeto.TabelaFipe.Model.Modelo;
import br.com.projeto.TabelaFipe.Model.Veiculo;
import br.com.projeto.TabelaFipe.Service.ConsumoApi;
import br.com.projeto.TabelaFipe.Service.ConverteDados;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private Scanner leitura = new Scanner(System.in);

    //url Base
    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();

    public void exibirMenu(){
        var menu = """
                ***OPÇÕES****
                Carro
                Moto
                Caminhão
                
                Digite uma das opções para leitura: 
                """;

        System.out.println(menu);
        var opcao = leitura.nextLine();

        String endereco;

        if (opcao.toLowerCase().contains("carr")){
            endereco = URL_BASE + "carros/marcas";
        }else if(opcao.toLowerCase().contains("mot")){
            endereco = URL_BASE + "motos/marcas";
        }else{
            endereco = URL_BASE + "caminhoes/marcas";
        }

        var json = consumoApi.obterDados(endereco);
        System.out.println(json);
        var marcas = conversor.obterLista(json, Dados.class);
        marcas.stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);

        System.out.println("Informe o códico da marca escolhida");
        var codMarca = leitura.nextLine();

        endereco = endereco + "/" + codMarca + "/modelos";
        json =consumoApi.obterDados(endereco);
        var modeloLista =conversor.obterDados(json, Modelo.class);
        modeloLista.modelos().stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);

        System.out.println("\n Digite um trecho do nome a ser buscado");
        var nomeVeiculo = leitura.nextLine();

        List<Dados> modelosFiltrados = modeloLista.modelos().stream()
                .filter(m-> m.nome().toLowerCase().contains(nomeVeiculo.toLowerCase()))
                .collect(Collectors.toList());
        System.out.println("\nmodelos filtrados");
        modelosFiltrados.forEach(System.out::println);

        System.out.println("Digite o código do modelo para buscar os valores e avaliações");
        var codModelo = leitura.nextLine();

        endereco = endereco + "/" + codModelo + "/anos";
        json = consumoApi.obterDados(endereco);

        List<Dados> anos =conversor.obterLista(json,Dados.class);
       List<Veiculo> veiculos = new ArrayList<>();

       for (int i = 0; i < anos.size(); i++){
           var enderecoAno = endereco +"/"+anos.get(i).codigo();
           json = consumoApi.obterDados(enderecoAno);
           Veiculo veiculo = conversor.obterDados(json,Veiculo.class);
           veiculos.add(veiculo);


       }

       System.out.println("\nTodos os veículos filtrados com avaliações por ano: ");
       veiculos.forEach(System.out::println);





    }
}
