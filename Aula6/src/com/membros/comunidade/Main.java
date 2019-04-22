package com.membros.comunidade;

public class Main {
    static void mostrarDados(MembroDaComunidade mdc){
        System.out.println(mdc.getDados());
    }
    public static void main(String[] args) {
        Aluno a1 = new Aluno("Osvaldo","455.819.068-90","17.00103-0");
        Graduado g1 = new Graduado("Rafael","422.564.832-10","Computação");
        Funcionario f1 = new Funcionario("Josias", "233.651.739-20");
        Professor p1 = new Professor("Cutri","899.258.321-30","Fisica 1");
        Empregado e1 = new Empregado("Salomão","544.766.899-90");

//        System.out.println(a1.getDados());
//        System.out.println(g1.getDados());
//        System.out.println(f1.getDados());
//        System.out.println(p1.getDados());
//        System.out.println(e1.getDados());

        mostrarDados(a1);
        mostrarDados(g1);
        mostrarDados(f1);
        mostrarDados(p1);
        mostrarDados(e1);
    }



}
