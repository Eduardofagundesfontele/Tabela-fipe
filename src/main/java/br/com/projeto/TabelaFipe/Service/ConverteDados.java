package br.com.projeto.TabelaFipe.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.util.List;

public class ConverteDados implements IConveteDados {
    // Cria uma instância do ObjectMapper, que será usada para converter JSON em objetos Java
    private ObjectMapper mapper = new ObjectMapper();

    // Método genérico para converter uma String JSON em um objeto da classe especificada.
    @Override
    public <T> T obterDados(String json, Class<T> classe) {
        try {
            // Tenta converter o JSON em objeto do tipo classe
            return mapper.readValue(json, classe);
        } catch (JsonProcessingException e) {
            // Se não conseguir, avisa que deu problema jogando a exceção para cima
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> List<T> obterLista(String json, Class<T> classe) {
        try {
            // Obtém a fábrica de tipos do Jackson
            TypeFactory typeFactory = mapper.getTypeFactory();
            // Cria o tipo para lista de objetos do tipo 'classe'
            CollectionType listaTipo = typeFactory.constructCollectionType(List.class, classe);
            // Converte o JSON para uma lista do tipo definido
            return mapper.readValue(json, listaTipo);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
