//Rafael Murata 17.00103-0
//Osvaldo William Schimidt Junior 17.04091-4

package com.company;

public class Main {

    public static void main(String[] args) {
        //Declaração de usuários
        Usuario u1 = new Usuario("Dougras","novinhopirocudo@redtube.com","696.666.424-69","30/02/2021");
        Usuario u2 = new Usuario("Irineu","vocenaosabenemeu@redtube.com","969.999.242-96","06/06/2006");

        //Declaração de carteiras
        Carteira w1 = new Carteira(1,"Carteira do Dougras","1234C");
        Carteira w2 = new Carteira(2,"Carteira do Irineu","C4321");

        //Atribuição de carteiras aos seus respectivos usuários
        u1.setCarteira(w1);
        u2.setCarteira(w2);

        //Declaração de cartões
        Cartao c1 = new Cartao(32.2,1,"Siva","Drabesco","Debito","06/08/2021","06/08/2027","069","6789","123456","23431-6");
        Cartao c2 = new Cartao(32.2,2,"CasterMard","Uati","Credito","06/08/2021","06/08/2027","096","1234","123457","24331-6");
        Cartao c3 = new Cartao(32.2,3,"Ameripress Excan","SantoAndre","Debito","06/08/2021","06/08/2027","042","1369","123458","24332-6");

        //Adição de cartões às suas respectivas carteiras
        w1.addCartao(c1);
        w2.addCartao(c2);
        w2.addCartao(c3);

        //Debito e 6789
        w1.pagamento(c1,"Debito","6789");

        //Credito e 1234
        //Demonstração de erro na senha
        w2.pagamento(c2,"Credito","4657");

        //Debito e 1369
        //Demonstação de erro no tipo de cartão
        w2.pagamento(c3,"Credito","1369");


        System.out.println(u1.getDados());
        System.out.println(w1.getDados());
        System.out.println(c1.getDados());

        System.out.println(u2.getDados());
        System.out.println(w2.getDados());
        System.out.println(c2.getDados());
        System.out.println(c3.getDados());


    }
}
