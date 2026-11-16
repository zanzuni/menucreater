
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
                            AlterarCliente();
                            break;
                        case 5:
                            ApagarCliente();
                            break;
                        case 6:
                            OrdenarPorNome();
                            break;
                        case 0:
                            System.out.println("Voltando ao menu principal...");
                            break;
                    }

                }while(clientes !=0);
            }

            if(menu == 2) {
                GerenciarContatos();
            }

        }while(menu !=0);

        System.out.println("######## Obrigado Por Usar Meu Codigo ########");
        System.out.println("######## Volte Sempre ########");

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

        System.out.println("\n######## LISTAR OS CLIENTES ########");

    if (totalClientes == 0) {

        System.out.println("Nenhum cliente cadastrado ainda.");

    } else {

        System.out.printf(
            "%-8s | %-18s | %-12s | %-20s | %-6s | %-15s | %-7s | %-10s%n",
            campos[0], campos[1], campos[2], campos[3],
            campos[4], campos[5], campos[6], campos[7]
        );

        System.out.println("---------------------------------------------------------------------------------------------------------------");

        for (int lin = 0; lin < totalClientes; lin++) {
            System.out.printf(
                "%-8s | %-18s | %-12s | %-20s | %-6s | %-15s | %-7s | %-10s%n",
                lista[lin][0],
                lista[lin][1],
                lista[lin][2],
                lista[lin][3],
                lista[lin][4],
                lista[lin][5],
                lista[lin][6],
                lista[lin][7]
            );
            System.out.println("---------------------------------------------------------------------------------------------------------------\n");
          }
        }
    }

   public static void ConsultarClientePorCodigo() {

    Scanner ler = new Scanner(System.in);

    System.out.println("\n######## CONSULTAR CLIENTE ########");

    System.out.print("\nDigite o código do cliente: ");
    String codigo = ler.nextLine();

    boolean encontrado = false;

    for (int lin = 0; lin < totalClientes; lin++) {

        if (lista[lin][0].equals(codigo)) {

            System.out.println("\n######## CLIENTE ENCONTRADO ########");

            System.out.printf(
                "%-8s | %-18s | %-12s | %-20s | %-6s | %-15s | %-7s | %-10s%n",
                campos[0], campos[1], campos[2], campos[3],
                campos[4], campos[5], campos[6], campos[7]
            );

            System.out.println("---------------------------------------------------------------------------------------------------------------");

            System.out.printf(
                "%-8s | %-18s | %-12s | %-20s | %-6s | %-15s | %-7s | %-10s%n",
                lista[lin][0],
                lista[lin][1],
                lista[lin][2],
                lista[lin][3],
                lista[lin][4],
                lista[lin][5],
                lista[lin][6],
                lista[lin][7]
            );

            encontrado = true;

            break;
        }
    }

    if (!encontrado) {
        System.out.println("Cliente não encontrado.");
    }
    System.out.println("---------------------------------------------------------------------------------------------------------------");
  }

  public static void AlterarCliente() {
    Scanner ler = new Scanner(System.in);

 System.out.println("\n######## ALTERAR CLIENTE ########");

    System.out.print("\nDigite o código do cliente que deseja alterar: ");
    String codigo = ler.nextLine();

    boolean encontrado = false;

    for (int lin = 0; lin < totalClientes; lin++) {

        if (lista[lin][0].equals(codigo)) {

            System.out.println("\n######## CLIENTE ENCONTRADO ########");

            for (int col = 1; col < 8; col++) {
                System.out.print("Digite novo " + campos[col] + " (atual: " + lista[lin][col] + "): ");
                String novoValor = ler.nextLine();
                if (!novoValor.isEmpty()) {
                    lista[lin][col] = novoValor;
                }
            }

            System.out.println("Cliente alterado com sucesso!");
            encontrado = true;
            break;
        }
    }

    if (!encontrado) {
        System.out.println("Cliente não encontrado.");
    }

  }

public static void ApagarCliente() {
    Scanner ler = new Scanner(System.in);

    System.out.println("\n######## APAGAR CLIENTE ########");

    System.out.print("\nDigite o código do cliente que deseja apagar: ");
    String codigo = ler.nextLine();

    boolean encontrado = false;

    for (int lin = 0; lin < totalClientes; lin++) {

        if (lista[lin][0].equals(codigo)) {
        
            for (int i = lin; i < totalClientes - 1; i++) {
                lista[i] = lista[i + 1];
            }

            lista[totalClientes - 1] = new String[8];

            totalClientes--;
            System.out.println("Cliente apagado com sucesso!");
            encontrado = true;
            break;
        }
    }

    if (!encontrado) {
        System.out.println("Cliente não encontrado.");
    }
  }

  public static void OrdenarPorNome() {
    if (totalClientes == 0) {
        System.out.println("Nenhum cliente cadastrado para ordenar.");
        return;
    }

    for (int i = 0; i < totalClientes - 1; i++) {
        for (int j = 0; j < totalClientes - i - 1; j++) {
            if (lista[j][1].compareToIgnoreCase(lista[j + 1][1]) > 0) {
                String[] temp = lista[j];
                lista[j] = lista[j + 1];
                lista[j + 1] = temp;
            }
        }
    }

    System.out.println("Clientes ordenados por nome com sucesso!");
  }

  public static void GerenciarContatos() {
Scanner ler = new Scanner(System.in);

static int totalContatos = 0;

    String[][] contatos = new String[100][5];

    String[] contatos = {
        "Código", "cliente", "Tipo", "valor", "Status"
     };

                do{
                    System.out.println("#### 1 - Incluir contato ####");
                    System.out.println("#### 2 - Listar contatos (todos os clientes)  ####");
                    System.out.println("#### 3 - Consultar contato de um cliente ####");
                    System.out.println("#### 4 - Alterar contato  ####");
                    System.out.println("#### 5 - Apagar contato  ####");
                    System.out.println("#### 0 - Voltar  ####");

                    System.out.println("#### qual você escolhe ? ####");
                    clientes = ler.nextInt();

                    if(clientes <0 || clientes>6) {
                        System.out.println("#### numero incorreto ####");
                        System.out.println("\n#############");
                        
                    }
                    switch(clientes) {
                        case 1:
                            IncluirContato();
                            break;
                        case 2:
                            ListarContatos();
                            break;
                        case 3:
                            ConsultarContatoPorCodigo();
                            break;
                        case 4:
                            AlterarContato();
                            break;
                        case 5:
                            ApagarContato();
                            break;
                        case 0:
                            System.out.println("Voltando ao menu principal...");
                            break;
                    }

                }while(clientes !=0);
            }

            public static void IncluirContato() {
                Scanner ler = new Scanner(System.in);

                System.out.println("####### Incluir contato ########");

                System.out.print("Digite o código do cliente para o qual deseja adicionar um contato: ");
                String codigoCliente = ler.nextLine();

                for(int lin = 0; lin < lista.length; lin++) {
                    if (lista[lin][0].equals(codigoCliente)) {
                        if (totalContatos < contatos.length) {
                            System.out.println("\n--- Cadastrando Contato " + (totalContatos + 1) + " ---");

                            for (int col = 0; col < 5; col++) {
                                System.out.print("Digite " + campos[col]);
                                contatos[totalContatos][col] = ler.nextLine();
                            }

                            totalContatos++;
                            System.out.println("Contato cadastrado com sucesso!");
                        } else {
                            System.out.println("Limite máximo de contatos atingido!");
                        }
                        return;
                    }
                }
                System.out.println("Cliente não encontrado!");
            }

            public static void ListarContatos() {
                Scanner ler = new Scanner(System.in);
            }

            public static void ConsultarContatoPorCodigo() {
                Scanner ler = new Scanner(System.in);
            }

            public static void AlterarContato() {
                
            }

            public static void ApagarContato() {
                
            }

}
