package codelab.aula4.pacientes;

import java.util.Scanner;

import lista.dupla.NodoGenerico;

public class Main {
    static Scanner kb = new Scanner(System.in);
    static ListaPaciente pacientes = new ListaPaciente();

    public static void main(String[] args) {
        boolean alive = true;

        System.out.println("Seja bem vindo ao Programa de Registros de Paciente (PRP)!");
        System.out.println("Escreva `help` caso precisar de ajuda");
        do {
            System.out.print("> ");
            String input = kb.nextLine();
            switch (input) {
                case "exit":
                    System.out.println("Finalizando sessão...");
                    alive = false;
                    break;
                case "help":
                    System.out.println("help -> Mostrar os comandos disponíveis");
                    System.out.println("exit -> Finaliza a sessão");
                    System.out.println("add -> Adicionar um paciente");
                    System.out.println("find -> Encontrar um paciente");
                    System.out.println("delete -> Remover um paciente");
                    System.out.println("list -> Listar todos os pacientes salvos");
                    break;
                case "add":
                    addPaciente();
                    break;
                case "list":
                    listPacientes();
                    break;
                case "find":
                    findPaciente();
                    break;
                case "delete":
                    deletePaciente();
                    break;
                default:
                    System.out
                            .println("Comando não reconhecido! Escreva `help` para uma lista de comandos disponíveis");
                    break;
            }
        } while (alive);

        kb.close();
    }

    private static void deletePaciente() {
        System.out.print("Digite o nome do paciente para deletar: ");
        String nomeBusca = kb.nextLine();

        boolean resultado = pacientes.deletar(new Paciente(nomeBusca, 0, 0, 0, 0));

        if (resultado) {
            System.out.println("Paciente \"" + nomeBusca + "\" deletado!");
        } else {
            System.out.println("Paciente \"" + nomeBusca + "\" não encontrado! Nome incorreto ou paciente não existe!");
        }
    }

    private static void listPacientes() {
        System.out.println("Lista de pacientes registrados");
        System.out.println(pacientes);
    }

    private static void findPaciente() {
        System.out.print("Digite o nome do paciente para buscar: ");
        String nomeBusca = kb.nextLine();

        NodoGenerico<Paciente> resultadoBusca = pacientes.pesquisar(
                new Paciente(nomeBusca, 0, 0, 0, 0));
        if (resultadoBusca == null) {
            System.out.println("Paciente \"" + nomeBusca + "\" não encontrado!");
        } else {
            System.out.println("Paciente encontrado: ");
            System.out.println(resultadoBusca.getDado());
        }
    }

    private static void addPaciente() {
        System.out.print("Digite o nome do paciente: ");
        String nome = kb.nextLine();

        System.out.print("Digite a idade do paciente: ");
        int idade = kb.nextInt();

        System.out.print("Digite o peso do paciente, em kg: ");
        double pesoKG = kb.nextDouble();

        System.out.print("Digite a altura do paciente, em metros: ");
        double alturaMetros = kb.nextDouble();

        System.out.print("Digite a circunferência do quadril do paciente, em centimetros: ");
        double circunfQuadrilCentimetros = kb.nextDouble();

        kb.nextLine();

        pacientes.inserirInicio(new Paciente(nome, idade,
                pesoKG, alturaMetros, circunfQuadrilCentimetros));

        System.out.println("Paciente novo inserido!");
    }
}
