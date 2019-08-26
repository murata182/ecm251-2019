package com.company;

import auxiliar_database.UsuariosDAO;
import model.Usuario;
import utilities.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aplicacao {
    private UsuariosDAO usuarioDAO;
    private List<Usuario> users;
    public Aplicacao(){
        usuarioDAO = new UsuariosDAO(Constants.URL_MEU_BANCO);
        users = new ArrayList<>();
    }

    public void run(){
        Scanner scanner = new Scanner(System.in);
        do{
            menu();
            int op = scanner.nextInt();
            switch(op){
                case 1:
                    String nome, email, senha;
                    System.out.println("Informe: ");
                    nome = scanner.next();
                    email = scanner.next();
                    senha = scanner.next();
                    Usuario user = new Usuario(nome, email, senha);
                    usuarioDAO.insertUsuario(user);
                    break;
                case 2:
                    List<Usuario> meusUsuarios = usuarioDAO.getAllUsuario();
                    for (Usuario u: meusUsuarios
                            ) {
                        System.out.print("ID: " + u.id);
                        System.out.println(" Nome: " + u.nome);
                        }
            }
        }while(true);
    }

    public void menu(){
        System.out.println("1 - Inserir usuario");
        System.out.println("2 - Mostrar todos os usuarios");
        System.out.println("3 - Buscar usuario");
        System.out.println("4 - Atualizar usuário");
        System.out.println("5 - Remover usuario");
        System.out.println("0 - Sair");
    }
}
