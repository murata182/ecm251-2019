package com.company;

public class Teste {
    public static void main(String[] args) {
        Animal[] animals = new Animal[3];
        animals[0] = new Lobo();
        animals[0].comer();
        animals[1] = new Lobo();
        animals[2] = new Lobo();

        for (Animal animal: animals) {
            animal.comer();
        }
    }
}
