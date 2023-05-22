package codelab.aula6;

import java.util.Map;
import java.util.TreeMap;

public class ArvoreRubroNegra {
    public static void main(String[] args) {
        TreeMap<Integer, String> arvore = new TreeMap<Integer, String>();

        arvore.put(1, "Anais");
        arvore.put(5, "Eduarda");
        arvore.put(6, "Felipe");
        arvore.put(4, "Diogo");
        arvore.put(2, "Beto");
        arvore.put(8, "Heitor");
        arvore.put(7, "Guilherme");
        arvore.put(3, "Caio");

        System.out.println(arvore.toString());

        System.out.println("Buscando o " + arvore.get(2));

        for (Map.Entry<Integer,String> entry : arvore.entrySet()) {
            System.out.println(entry.toString());
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        arvore.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}
