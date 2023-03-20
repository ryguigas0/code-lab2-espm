package codelab.aula4.pacientes;

import static javax.swing.JOptionPane.*;

import lista.dupla.NodoGenerico;

public class GUI {

    private ListaPaciente pacientes = new ListaPaciente();

    public void inciar() {
        int opcao;
        do {
            opcao = Integer.parseInt(showInputDialog(null, gerarMensagemInicial()));

            if (opcao == 5) {
                break;
            }

            switch (opcao) {
                case 1:
                    addPaciente();
                    break;
                case 2:
                    listPacientes();
                    break;
                case 3:
                    findPaciente();
                    break;
                case 4:
                    deletarPaciente();
                    break;

                default:
                    showMessageDialog(null, "Por favor digite uma opção válida");
                    break;
            }

        } while (true);
    }

    private void deletarPaciente() {
        String nomeBusca = showInputDialog(null, "Digite o nome do paciente para deletar");

        boolean resultado = pacientes.deletar(new Paciente(nomeBusca, 0, 0, 0, 0));

        if (resultado) {
            showMessageDialog(null, "Paciente \"" + nomeBusca + "\" foi deletado!");
        } else {
            showMessageDialog(null, "Paciente \"" + nomeBusca + "\" não foi encontrado!");
        }
    }

    private void findPaciente() {
        String nomeBusca = showInputDialog(null, "Digite o nome do paciente para buscar");

        NodoGenerico<Paciente> resultadoBusca = pacientes.pesquisar(new Paciente(nomeBusca, 0, 0, 0, 0));

        if (resultadoBusca == null) {
            showMessageDialog(null, "Paciente \"" + nomeBusca + "\" não encontrado!");
        } else {
            showMessageDialog(null, resultadoBusca.getDado());
        }
    }

    private void listPacientes() {
        showMessageDialog(null, pacientes);
    }

    private void addPaciente() {
        String nome = showInputDialog(null, "Digite o nome do paciente");

        pacientes.inserirInicio(new Paciente(nome));
    }

    private String gerarMensagemInicial() {
        return "1 - Adicionar paciente\n2 - Listar pacientes\n3 - Pesquisar paciente\n4 - Deletar paciente\n5 - Sair";
    }

}
