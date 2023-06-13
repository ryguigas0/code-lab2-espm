package codelab.prova2.questao7;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> arvore = new TreeMap<>();

        for (Integer numero : gerarNumeros()) {
            arvore.put(numero, numero);
        }
    }

    private static List<Integer> gerarNumeros() {
        List<Integer> output = new ArrayList<Integer>();

        int meuRA = 203491;

        String input = "761" + (meuRA) + "385";

        for (String digitoString : input.split("")) {
            output.add(Integer.parseInt(digitoString));
        }

        return output;
    }
}
