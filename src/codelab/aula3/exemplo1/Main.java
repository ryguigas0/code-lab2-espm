package codelab.aula3.exemplo1;

public class Main {
    public static void main(String[] args) {
        Veiculo v = new Veiculo("ABC", "Audi");
        Veiculo v1 = new Veiculo("ABC", "Audi");

        System.out.println(v);
        System.out.println(v1);

        if (v == v1) {
            System.out.println("v == v1");
        } else {
            System.out.println("v != v1");
        }

        if (v.equals(v1)) {
            System.out.println("v equals v1");
        } else {
            System.out.println("v not equals v1");
        }
    }
}
