package codelab.aula4.pacientes;

import java.util.Scanner;

import lista.dupla.ListaDuplaGenerica;

public class Main {

    String[] comandos = { "create", "find", "delete", "list" };

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        ListaDuplaGenerica<Paciente> pacientes = new ListaDuplaGenerica<Paciente>();
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
                    System.out.println("create -> Adicionar um paciente");
                    System.out.println("find -> Encontrar um paciente");
                    System.out.println("delete -> Remover um paciente");
                    System.out.println("list -> Listar todos os pacientes salvos");
                    break;
                case "create":
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
                    break;
                case "list":
                    System.out.println("Lista de pacientes registrados");
                    System.out.println(pacientes);
                    break;
                default:
                    System.out
                            .println("Comando não reconhecido! Escreva `help` para uma lista de comandos disponíveis");
                    break;
            }
        } while (alive);

        kb.close();
    }
}
