package codelab.aula5.exercicio2;

import java.util.Scanner;
import java.util.Stack;

public class ColecionadorVinhos {
    public static void main(String[] args) {
        Stack<Vinho> adega = new Stack<Vinho>();

        Scanner kb = new Scanner(System.in);

        boolean alive = true;

        do {
            System.out.println("================");
            System.out.println("1 -> Adicionar vinho");
            System.out.println("2 -> Vinho para ocasiões especiais");
            System.out.println("3 -> 5 vinhos mais antigos");
            System.out.println("4 -> sair");

            int option = kb.nextInt();
            kb.nextLine();

            System.out.println("================");
            switch (option) {
                case 1:
                    System.out.print("Digite o nome do vinho: ");
                    String nomeVinho = kb.nextLine();

                    System.out.print("Digite o ano da safra do vinho: ");
                    int anoVinho = kb.nextInt();

                    Vinho vinho = new Vinho(nomeVinho, anoVinho);
                    adega.push(vinho);
                    break;

                case 2:

                    if (adega.isEmpty()) {
                        System.out.println("Adega está vazia!");
                    } else {
                        System.out.println("Vinho para ocasiões especiais de hoje: ");
                        System.out.println(adega.peek());
                    }

                    break;

                case 3:
                    Stack<Vinho> backup = new Stack<Vinho>();

                    while (adega.size() > 5) {
                        backup.push(adega.pop());
                    }

                    System.out.println("Os 5 vinhos mais antigos");
                    while (!adega.isEmpty()) {
                        System.out.println(adega.peek());
                        backup.push(adega.pop());
                    }

                    while (!backup.isEmpty()) {
                        adega.push(backup.pop());
                    }

                    break;

                case 4:
                    alive = false;
                    break;

                default:
                    System.out.println("Digite uma opção válida");
                    break;
            }
        } while (alive);

        kb.close();
    }
}
