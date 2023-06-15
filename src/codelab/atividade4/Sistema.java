package codelab.atividade4;

import java.util.*;

import codelab.aula8.Grafo;

import static javax.swing.JOptionPane.*;

public class Sistema {

    HashMap<String, Integer> cidadeIndex = new HashMap<>();
    int numeroCidade = 1;

    Grafo rotasGrafo = new Grafo();

    public void inicializar() {
        String[] opcoesDisponiveis = { "Adicionar rota", "Rotas disponíveis", "Calcular rota", "Finalizar" };
        boolean rodar = true;
        while (rodar) {
            try {
                int opcaoEscolhida = 0;
                do {
                    opcaoEscolhida = inputSelecaoOpcoes("Calculadora de menor rota possível", opcoesDisponiveis);
                } while (opcaoEscolhida == 0);

                switch (opcaoEscolhida) {
                    case 1:
                        adicionarRota();
                        break;
                    case 2:
                        imprimirRotasDisponiveis();
                        break;
                    case 3:
                        calcularRota();
                        break;

                    default:
                        rodar = false;
                        break;
                }
            } catch (Exception e) {
                showInternalMessageDialog(null, e.getMessage());
            }
        }
    }

    private void calcularRota() {
        String nomeCidadeA = stringInput("Digite o nome da cidade de origem");

        if (!cidadeIndex.containsKey(nomeCidadeA)) {
            throw new RuntimeException("Digite uma cidade registrada!");
        }

        String nomeCidadeB = stringInput("Digite o nome da cidade de destino");

        if (!cidadeIndex.containsKey(nomeCidadeB)) {
            throw new RuntimeException("Digite uma cidade registrada!");
        }

        int indA = cidadeIndex.get(nomeCidadeA);
        int indB = cidadeIndex.get(nomeCidadeB);

        double distanciaKM = rotasGrafo.calcularCaminhoMinimo(indA).get(indB);

        showMessageDialog(null,
                String.format("A menor distância entre %s e %s é %.2f",
                        nomeCidadeA, nomeCidadeB, distanciaKM));
    }

    private void imprimirRotasDisponiveis() {
        String output = "Rotas disponíveis\n";
        output += "----------------\n";

        for (Map.Entry<String, Integer> cidadeEntry : cidadeIndex.entrySet()) {
            output += cidadeEntry.getKey() + "\n";
            output += "----------------\n";
        }

        showMessageDialog(null, output);

    }

    private void adicionarRota() {
        String nomeCidadeA = stringInput("Digite o nome da cidade de origem da rota");
        String nomeCidadeB = stringInput("Digite o nome da cidade de destino da rota");
        double distanciaKM = doubleInput("Digite a distância entre " + nomeCidadeA + " e " + nomeCidadeB, 0.0);

        rotasGrafo.adicionarAresta(numeroCidade, numeroCidade + 1, distanciaKM);

        if (!cidadeIndex.containsKey(nomeCidadeA)) {
            cidadeIndex.put(nomeCidadeA, numeroCidade);
            numeroCidade += 1;
        }

        if (!cidadeIndex.containsKey(nomeCidadeB)) {
            cidadeIndex.put(nomeCidadeB, numeroCidade);
            numeroCidade += 1;
        }
    }

    private String stringInput(String message) {
        System.out.print(message + ": ");

        String userInput = showInputDialog(message);

        return userInput;
    }

    private double doubleInput(String message, double min) {
        System.out.print(message + ": ");

        String userInput = showInputDialog(message);

        double parsedInput = Double.parseDouble(userInput);

        if (parsedInput <= min) {
            throw new RuntimeException("Digite um valor maior que " + min + "!");
        }

        return parsedInput;
    }

    // 0 -> Opção inválida
    // -1 -> Cancelar
    private int inputSelecaoOpcoes(String titulo, String[] opcoesDisponiveis) {
        String msg = titulo + "\n";

        for (int i = 0; i < opcoesDisponiveis.length; i++) {
            msg += String.format("%d. %s\n", (i + 1), opcoesDisponiveis[i]);
        }

        String userInputString = showInputDialog(msg);

        if (userInputString == null) {
            return -1;
        }

        int resultado;

        try {
            resultado = Integer.parseInt(userInputString);
        } catch (NumberFormatException e) {
            return 0;
        }

        if (resultado < 1 || resultado > opcoesDisponiveis.length) {
            return 0;
        }

        return resultado;
    }
}
