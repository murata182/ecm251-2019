package ex1;

public class Produto {
    private String nome;

    public Produto(String nome){
        this.nome = nome;
    }

    @Override
    public String toString(){
        return nome;
    }

    public boolean equals(Object obj){
        return this.nome.equals(obj.toString());
    }
}
