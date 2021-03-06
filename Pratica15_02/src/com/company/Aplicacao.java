package com.company;

import auxiliar_database.SingletonUsuariosDAO;
import model.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aplicacao {
    private List<Usuario> users;
    public Aplicacao(){
        users = new ArrayList<>();
    }

    public void run(){
        Scanner scanner = new Scanner(System.in);
        do{
            menu();
            int op = scanner.nextInt();
            int id;
            Usuario us;
            switch (op){
                case 1:
                    String nome, email, senha;
                    System.out.println("Informe:");
                    nome = scanner.next();
                    email = scanner.next();
                    senha = scanner.next();
                    Usuario user = new Usuario(
                            nome, email, senha
                    );
                    SingletonUsuariosDAO.getInstance().insertUsuario(user);
                    break;
                    case 2:
                        users = SingletonUsuariosDAO.getInstance().getAllUsuario();
                        for (Usuario u : users) {
                            System.out.print("ID: " + u.id);
                            System.out.println(" Nome: " + u.nome);
                        }
                    break;
                    case 3:
                        System.out.printf("Informe o id: ");
                        id = scanner.nextInt();
                        us = SingletonUsuariosDAO.getInstance().getUsuario(id);
                        System.out.println();
                        if(us == null)
                            System.out.println("Usuário não cadastrado!");
                        else {
                            System.out.println("ID: "+us.id);
                            System.out.println("Nome: "+us.nome);
                            System.out.println("Email: "+us.email);
                        }
                        break;
                    case 4:
                        System.out.printf("Informe o id: ");
                        id = scanner.nextInt();
                        us = SingletonUsuariosDAO.getInstance().getUsuario(id);
                        System.out.println();
                        if(us == null)
                            System.out.println("Usuário não cadastrado!");
                        else {
                            System.out.println("ID: "+us.id);
                            System.out.println("Nome: "+us.nome);
                            System.out.println("Email: "+us.email);
                            System.out.println("Qual o campo a ser atualizado: ");
                            System.out.println("1 - Nome");
                            System.out.println("2 - Email");
                            System.out.println("3 - Senha");
                            op = scanner.nextInt();
                            System.out.println("Novo valor: ");
                            String temp = scanner.next();
                            switch(op){
                                case 1: us.nome = temp; break;
                                case 2: us.email = temp; break;
                                case 3: us.senha = temp; break;
                            }
                            SingletonUsuariosDAO.getInstance().updateUserById(us);
                        }
                        break;
                    case 5:
                        System.out.println("ID para deletar: ");
                        id = scanner.nextInt();
                        SingletonUsuariosDAO.getInstance().deleteUserById(id);
                        break;
                    default: return;

            }
        }while(true);
    }
    public void menu(){
        System.out.println("1 - Inserir Usuario");
        System.out.println("2 - Mostrar todos os usuarios");
        System.out.println("3 - Buscar usuario");
        System.out.println("4 - Atualizar usuario");
        System.out.println("5 - Remover usuario");
        System.out.println("0 - Sair");
    }
}
