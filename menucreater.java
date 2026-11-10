
import java.util.Scanner;

public class menucreater {

    Scanner ler = new Scanner(System.in);
       static int menu;
        static int clientes;

        static int totalClientes = 0;

     static String[][] lista = new String[10][8];

     static String[] campos = {
        "Código", "Nome", "CPF/CNPJ", "Data de nascimento",
        "Sexo", "Cidade", "Estado", "Status"
     };

    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);

        System.out.println("\n##### SEJA BEM VINDO #####");

        do {
            System.out.println("\nqual você quer acessar ?");

            System.out.println("#### 1- Gerencia clientes ####");
            System.out.println("#### 2- Gerencia contatos ####");
            System.out.println("#### 3- Relatórios ####");
            System.out.println("#### 0- sair ####");

            System.out.println("#### qual você escolhe ? ####");
            menu = ler.nextInt();

            if(menu <0 || menu>3) {
                System.out.println("#### numero incorreto ####");
                System.out.println("\n#############");
                
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
                    clientes = ler.nextInt();

                    if(clientes <0 || clientes>6) {
                        System.out.println("#### numero incorreto ####");
                        System.out.println("\n#############");
                        
                    }
                    switch(clientes) {
                        case 1:
                            IncluirCliente();
                            break;
                        case 2:
                            ListarClientes();
                            break;
                        case 3:
                            ConsultarClientePorCodigo();
                            break;
                        case 4:
                            System.out.println("Alterar cliente");
                            break;
                        case 5:
                            System.out.println("Apagar cliente");
                            break;
                        case 6:
                            System.out.println("Ordenar por nome");
                            break;
                        case 0:
                            System.out.println("Voltando ao menu principal...");
                            break;
                    }

                }while(clientes !=0);
            }

        }while(menu !=0);

        System.out.println("######## Obrigado Por Usar Meu Codigo ########");

    }

    public static void IncluirCliente() {

        Scanner ler = new Scanner(System.in);

        System.out.println("#### Incluir cliente ####");

        if (totalClientes < lista.length) {

            System.out.println("\n--- Cadastrando Cliente " + (totalClientes + 1) + " ---");

            for (int col = 0; col < 8; col++) {

                System.out.print("Digite " + campos[col]);

                lista[totalClientes][col] = ler.nextLine();
            }

            totalClientes++;

            System.out.println("Cliente cadastrado com sucesso!");

        } else {

            System.out.println("Limite máximo de 10 clientes atingido!");
        }
    }

    public static void ListarClientes() {

        System.out.println("\n--- Lista de Clientes ---");

        if (totalClientes == 0) {

            System.out.println("Nenhum cliente cadastrado ainda.");

        } else {

            for (int lin = 0; lin < totalClientes; lin++) {

                System.out.println("\nCliente " + (lin + 1) + ":");

                for (int col = 0; col < 8; col++) {

                    System.out.println(campos[col] + ": " + lista[lin][col]);
                    System.out.println("-------------------------\n");
                }
            }
        }
    }

    public static void ConsultarClientePorCodigo() {

        Scanner ler = new Scanner(System.in);

        System.out.print("Digite o código do cliente: ");

        String codigo = ler.nextLine();

        boolean encontrado = false;

        for (int lin = 0; lin < totalClientes; lin++) {

            if (lista[lin][0].equals(codigo)) {

                System.out.println("\n=== DADOS DO CLIENTE ===");

                for (int col = 0; col < 8; col++) {

                    System.out.println(campos[col] + ": " + lista[lin][col]);
                    System.out.println("-------------------------\n");
                }

                encontrado = true;

                break;
            }
        }

        if (!encontrado) {

            System.out.println("Cliente não encontrado.");
        }
    }

   }



