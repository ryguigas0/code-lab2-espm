package codelab.aula5.fila.exercicio1;

import java.util.*;

public class Sistema {
    Queue<LoteAcoes> filaLoteAcoes = new LinkedList<LoteAcoes>();
    Scanner kb = new Scanner(System.in);

    public void inicializar() {

        boolean alive = true;

        while (alive) {
            try {
                int userInput = optionsInput(
                        "Selecione uma das opções abaixo:",
                        "Comprar ação", "Vender ação",
                        "Listar ações compradas", "Finalizar");
                switch (userInput) {
                    case 1:
                        adicionarCompra();
                        System.out.println("Compra de ação adicionada!");
                        break;

                    case 2:
                        verderLoteAcoes();
                        break;
                    case 3:
                        listarLoteAcoes();
                        break;

                    default:
                        alive = false;
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Digite uma opção válida!");
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void listarLoteAcoes() {
        LoteAcoes[] loteAcoes = filaLoteAcoes.toArray(new LoteAcoes[] {});

        if (loteAcoes.length == 0) {
            System.out.println("Nenhuma ação foi comprada ainda...");
        } else {
            System.out.println("Ações compradas:");
            for (int i = 0; i < loteAcoes.length; i++) {
                System.out.println(
                        String.format("ID: %d - Valor: R$%.2f - Quant: %d",
                                (i + 1), loteAcoes[i].getValorAcao(), loteAcoes[i].getQuantidade()));
            }
        }
    }

    private void verderLoteAcoes() {
        int quantidade = intInput("Digite a quantidade de ações para vender", 0);

        double valorAcoes = doubleInput("Digite o valor de venda das ações", 0);

        double captialObtido = efeutarVenda(quantidade, valorAcoes);

        System.out.println(String.format("Capital obtido: R$%.2f", captialObtido));
    }

    private double efeutarVenda(int quantidadeAcoesVenda, double valorAcoesVenda) {
        double accCapital = 0;

        int quantidadeAcoesRestantes = quantidadeAcoesVenda;

        while (filaLoteAcoes.size() > 0) {
            LoteAcoes loteAcaoCompra = filaLoteAcoes.remove();

            int quantidadeAcoes = loteAcaoCompra.getQuantidade();

            if (quantidadeAcoesRestantes >= quantidadeAcoes) {
                quantidadeAcoesRestantes -= quantidadeAcoes;
            } else {
                quantidadeAcoes = quantidadeAcoesRestantes;
            }

            accCapital += (valorAcoesVenda - loteAcaoCompra.getValorAcao()) * quantidadeAcoes;
        }

        return accCapital;
    }

    private void adicionarCompra() {
        int quantidade = intInput("Digite a quantidade de ações para comprar", 0);

        double valorAcoes = doubleInput("Digite o valor das ações compradas", 0);

        filaLoteAcoes.add(new LoteAcoes(quantidade, valorAcoes));
    }

    private double doubleInput(String message, int min) {
        System.out.print(message + ": ");

        String userInput = kb.nextLine();

        double parsedInput = Double.parseDouble(userInput);

        if (parsedInput <= min) {
            throw new RuntimeException("Digite um valor maior que " + min + "!");
        }

        return parsedInput;
    }

    private int intInput(String message, int min) {
        System.out.print(message + ": ");

        String userInput = kb.nextLine();

        int parsedInput = Integer.parseInt(userInput);

        if (parsedInput <= min) {
            throw new RuntimeException("Digite um valor maior que " + min + "!");
        }

        return parsedInput;
    }

    private void printarSeparador() {
        System.out.println("---------------------");
    }

    private int optionsInput(String titulo, String... opts) {
        printarSeparador();

        System.out.println(titulo);
        for (int i = 0; i < opts.length; i++) {
            System.out.println(String.format("%d. %s", (i + 1), opts[i]));
        }

        printarSeparador();

        String userInput = kb.nextLine();

        int parsedInput = Integer.parseInt(userInput);

        if (parsedInput <= 0 || parsedInput > opts.length) {
            throw new RuntimeException("Digite uma opção válida!");
        }

        return parsedInput;
    }
}
