package org.example.desafio_final;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {

        Collection<String> minhaLista = new ArrayList<>();
        Collection<String> minhasCompras = new ArrayList<>();
        List<String> produtosListaDisponiveis = new ArrayList<>();
        int quant = 0;
        System.out.print("Quantos itens terá na sua lista: ");
        quant = Integer.parseInt(entrada.nextLine());
        System.out.print("Qual a sua lista de compras para hoje?\n");
        for(int i = 0; i < quant; i++) {
            Collections.addAll(minhaLista,
                    entrada.nextLine());
        }
        System.out.println("Lista de produtos disponíveis hoje:");
        for(int i = 0; i < quant; i++) {
            Collections.addAll(minhasCompras,
                    entrada.nextLine());
        }
        System.out.printf("%nMinha lista de produtos: %s", minhaLista);
        System.out.printf("%nProdutos disponíveis hoje: %s%n", minhasCompras);


        produtosListaDisponiveis = Stream.concat(minhaLista.stream(),
                minhasCompras.stream()).collect(Collectors.toList());

        Map<String, List<String>> itens = new LinkedHashMap<>();
        for(int i = 0; i < produtosListaDisponiveis.size(); i++) {
            String s = produtosListaDisponiveis.get(i);
            if(!itens.containsKey(s)) {
                itens.put(s, new  ArrayList<>());
            }
            itens.get(s).add(String.valueOf(i));
        }

        System.out.println("Os produtos da minha lista que estão disponíveis hoje são:");

        for(Map.Entry<String, List<String>> stringListEntry: itens.entrySet()) {
            List<String> posicoes = stringListEntry.getValue();
            if(posicoes.size() > 1) {
                System.out.printf("%s%n", stringListEntry.getKey());
            }
        }

        System.out.print(itens);
    }
}