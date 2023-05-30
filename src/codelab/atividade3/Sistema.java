package codelab.atividade3;

import static javax.swing.JOptionPane.*;

import java.util.TreeMap;
import java.util.Map.Entry;

public class Sistema {
    TreeMap<Integer, Carga> cargas = new TreeMap<>();
    double limitePeso = 10000.0; // kg
    double pesoAtual = 0.0; // kg

    public void iniciar() {
        String[] opcoesDisponiveis = { "Reservar carga", "Pesquisar carga", "Imprimir cargas reservadas",
                "Excluir cargas", "Finalizar" };
        boolean rodar = true;
        while (rodar) {
            // System.out.println(cargas);
            int opcaoEscolhida = 0;
            do {
                opcaoEscolhida = inputSelecaoOpcoes("Sistema de reserva de cargas", opcoesDisponiveis);
            } while (opcaoEscolhida == 0);

            switch (opcaoEscolhida) {
                case 1:
                    reservarCarga();
                    break;
                case 3:
                    imprirCargasReservadas();
                    break;
                case 2:
                    pesquisarCarga();
                    break;
                case 4:
                    excluirCarga();
                    break;

                default:
                    rodar = false;
                    break;
            }
        }

    }

    private void excluirCarga() {
        String inputId = showInputDialog("Digite o ID da carga:");
        if (inputId == null) {
            return;
        }

        try {
            int id = Integer.parseInt(inputId);

            Carga cargaRemovida = cargas.remove(id);

            if (cargaRemovida != null) {
                showMessageDialog(getRootFrame(), "Carga foi deletada com sucesso!");
            } else {
                showMessageDialog(getRootFrame(), "Carga não foi encontrada!");
            }
        } catch (Exception e) {
            showMessageDialog(getRootFrame(), "Digite um ID válido!");
        }

    }

    private void pesquisarCarga() {
        String inputID = showInputDialog("Digite o ID da carga:");

        if (inputID == null) {
            return;
        }

        try {
            int id = Integer.parseInt(inputID);

            Carga carga = cargas.get(id);

            if (carga != null) {
                showMessageDialog(getRootFrame(), carga);
            } else {
                showMessageDialog(getRootFrame(), "Carga não foi encontrada!");
            }
        } catch (NumberFormatException e) {
            showMessageDialog(getRootFrame(), "ID de carga inválido!");
        }
    }

    private void imprirCargasReservadas() {
        String msg = "Não há cargas registradas!";
        if (!cargas.isEmpty()) {
            msg = "Cargas encontradas:";

            for (Entry<Integer, Carga> integerCarga : cargas.entrySet()) {
                msg += "\n==============\n";
                msg += integerCarga.getValue();
            }

        }

        showMessageDialog(getRootFrame(), msg);
    }

    private void reservarCarga() {
        String cnpjEmpresa = showInputDialog("Digite o CNPJ da empresa responsável pela carga:");
        if (cnpjEmpresa == null) {
            return;
        }

        String nomeEmpresa = showInputDialog("Digite o nome da empresa responsável pela carga:");
        if (nomeEmpresa == null) {
            return;
        }

        String destinoCarga = showInputDialog("Digite o destino da carga:");
        if (destinoCarga == null) {
            return;
        }

        double pesoCarga = 0.0;

        do {
            String pesoCargaString = showInputDialog("Digite o peso da carga:");
            if (pesoCargaString == null) {
                return;
            }

            try {
                pesoCarga = Double.parseDouble(pesoCargaString);
            } catch (NumberFormatException e) {
                showMessageDialog(getRootFrame(), "Digite um valor válido");
            }
        } while (pesoCarga == 0.0);

        if (pesoCarga + pesoAtual > limitePeso) {
            showMessageDialog(getRootFrame(), "O peso da carga excede o peso limite do navio! (10.000 kg)");
        } else {
            pesoAtual += pesoCarga;

            Carga novaCarga = new Carga(cnpjEmpresa, nomeEmpresa, destinoCarga, pesoCarga);

            cargas.put(novaCarga.getId(), novaCarga);
        }

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
