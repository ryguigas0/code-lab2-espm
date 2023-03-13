package codelab.aula4.pacientes;

import java.util.Scanner;

import lista.dupla.ListaDuplaGenerica;

public class Main {

    String[] comandos = { "create", "find", "delete", "list" };

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
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
                default:
                    System.out
                            .println("Comando não reconhecido! Escreva `help` para uma lista de comandos disponíveis");
                    break;
            }
        } while (alive);

        kb.close();
    }
}
