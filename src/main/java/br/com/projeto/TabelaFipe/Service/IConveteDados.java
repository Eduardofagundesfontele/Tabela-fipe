package br.com.projeto.TabelaFipe.Service;

import java.util.List;

public interface IConveteDados {
    <T> T obterDados (String json,Class<T> classe);

    <T> List<T> obterLista(String json, Class<T> classe);
}
