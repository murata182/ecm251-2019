package com.company;

import java.util.LinkedList;

public class LinkedListTestDrive {
    public static void main(String[] args) {
        LinkedList<Item> lista = new LinkedList<>();
        lista.add(new Item(1,"XBOX ONE"));
        lista.add(0,new Item(2,"Switch"));
        lista.add(new Item(3,"PS4"));
        System.out.println("Tamanho: " + lista.size());
        for (Item i: lista) {
            System.out.println("Item - " + i);
        }
    }
}
