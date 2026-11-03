package org.example;

import java.util.Scanner;

public class FINAL {
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        int menu;
        int clientes;

        System.out.println("\n##### SEJA BEM VINDO #####");

        do {
            System.out.println("\nqual você quer acessar ?");

            System.out.println("#### 1- Gerencia clientes ####");
            System.out.println("#### 2- Gerencia contatos ####");
            System.out.println("#### 3- Relatórios ####");
            System.out.println("#### 0- sair ####");

            System.out.println("#### qual você escolhe ? ####");
            System.out.print(">");
            menu = ler.nextInt();

            if(menu <0 || menu>3) {
                System.out.println("#### numero incorreto ####");
                System.out.println("#############");
                System.out.println("  ");
                System.out.println("  ");
            }else {
                System.out.println("#### você escolheu n: "+ menu + " ####");
            }
            if(menu == 1) {
                do{
                    System.out.println("#### 1 - Incluir cliente ####");
                    System.out.println("#### 2 - Listar clientes (todos os clientes)  ####");
                    System.out.println("#### 3 - Consultar cliente por código  ####");
                    System.out.println("#### 4 - Alterar cliente  ####");
                    System.out.println("#### 5 - Apagar cliente  ####");
                    System.out.println("#### 6 - Ordenar por nome  ####");
                    System.out.println("#### 0 - Voltar  ####");

                    System.out.println("#### qual você escolhe ? ####");
                    System.out.print(">");
                    clientes = ler.nextInt();

                    if(clientes <0 || clientes>3) {
                        System.out.println("#### numero incorreto ####");
                        System.out.println("#############");
                        System.out.println("  ");
                        System.out.println("  ");
                    }

                }while(clientes !=0);
            }

        }while(menu !=0);

        System.out.println("######## Obrigado Por Usar Meu Codigo ########");

    }
}
