package codelab.atividade2;
import java.util.*;

import static javax.swing.JOptionPane.*;

import codelab.atividade2.models.*;;

public class Sistema {
    Caixa[] caixas = { new Caixa(), new Caixa(), new Caixa() };

    Queue<Transacao> filaTransacoes = new LinkedList<Transacao>();

    int[] mapaCodigoQuantidade = new int[8];

    int qtdClientesAtendidos = 0;

    int cronometro = 0;

    public void inicializar() {
        int limiteTempo = -1;
        do {
            try {
                limiteTempo = intInput("Digite o tempo em segundos para processar a simulação", 0);
            } catch (NumberFormatException e) {
                showMessageDialog(getRootFrame(), "Digite um valor válido");
            } catch (RuntimeException e) {
                showMessageDialog(getRootFrame(), e.getMessage());
            }
        } while (limiteTempo == -1);

        int quantidadeTransacoes = -1;
        do {
            try {
                quantidadeTransacoes = intInput("Digite a quantidade de transações serão feitas", 0);
            } catch (NumberFormatException e) {
                showMessageDialog(getRootFrame(), e.getMessage());
            }
        } while (quantidadeTransacoes == -1);

        popularFila(quantidadeTransacoes);

        simular(limiteTempo);

        mostrarRelatorio();
    }

    private void mostrarRelatorio() {
        String output = "Relatório de performance\n";

        output += "--------------------------------\n";
        output += "Quantidade de clientes atendidos: " + qtdClientesAtendidos + "\n";

        output += "-----------------\n";
        output += "Quantidade de clientes não atendidos: " + filaTransacoes.size() + "\n";

        output += "-----------------\n";
        output += "Tempo médio de espera da fila: " + (cronometro / (qtdClientesAtendidos)) + "s \n";

        output += "-----------------\n";
        output += "Transações efetuadas (qtd -> transacao)\n";
        for (int codigo = 0; codigo < mapaCodigoQuantidade.length; codigo++) {
            Transacao transacao = new Transacao(codigo);

            output += String.format("%d -> %s\n", mapaCodigoQuantidade[codigo], transacao.getNome());

        }

        output += "--------------------------------\n";
        showMessageDialog(getRootFrame(), output);
    }

    private void simular(int limiteTempo) {
        for (; cronometro <= limiteTempo && filaTransacoes.size() > 0; cronometro++) {
            for (int i = 0; i < caixas.length && filaTransacoes.size() > 0; i++) {
                if (caixas[i].getTickLiberacao() == cronometro) {
                    Transacao transacao = filaTransacoes.remove();

                    caixas[i].setTickLiberacao(transacao.getTempo() + cronometro);

                    mapaCodigoQuantidade[transacao.getCodigo()]++;

                    qtdClientesAtendidos++;
                }
            }
        }
    }

    private void popularFila(int quantidadeTransacoes) {
        Random r = new Random();
        for (int i = 0; i < quantidadeTransacoes; i++) {
            int codigoTransacao = r.nextInt(7);

            filaTransacoes.add(new Transacao(codigoTransacao));
        }
    }

    private int intInput(String message, int min) {
        System.out.print(message + ": ");

        String userInput = showInputDialog(message);

        int parsedInput = Integer.parseInt(userInput);

        if (parsedInput <= min) {
            throw new RuntimeException("Digite um valor maior que " + min + "!");
        }

        return parsedInput;
    }
}
