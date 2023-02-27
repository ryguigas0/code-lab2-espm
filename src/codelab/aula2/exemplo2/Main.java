package codelab.aula2.exemplo2;

public class Main {
    public static void main(String[] args) {
        ListaDupla l = new ListaDupla();

        System.out.println(l);

        l.inserirInicio(1, "Ana");
        l.inserirInicio(2, "Beto");
        l.inserirInicio(3, "Caio");
        l.inserirInicio(4, "Diogo");
        l.inserirInicio(5, "Eduardo");

        // System.out.println(l);

        l.inserirFim(6, "Felipe");
        l.inserirFim(7, "Guilherme");
        l.inserirFim(8, "Heitor");
        l.inserirFim(9, "Iasmin");
        l.inserirFim(10, "João");

        System.out.println(l);
        
        Nodo a = l.buscarRA(10);
        System.out.println("Nodo encontrado: " + a);

        Nodo b = l.buscarRA(30);
        System.out.println("Nodo encontrado: " + b);
    }
}