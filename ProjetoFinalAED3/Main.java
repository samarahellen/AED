import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opcao = 0;
        Scanner scanner = new Scanner(System.in);

        // Início do loop principal do menu
        while (opcao != 6) {
            System.out.println("Menu:");
            System.out.println("1. Carregar base de dados");
            System.out.println("2. Criar registro");
            System.out.println("3. Ler registro");
            System.out.println("4. Atualizar registro");
            System.out.println("5. Deletar registro");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    // Opção 1: Carregar base de dados

                    String arquivoCSV = "campeonato-brasileiro-full.csv";
                    BufferedReader conteudoCSV = null;
                    String linha = "";
                    String separadorCSV = ",";
                    String[][] registrosArray = null;

                    try {
                        // Abrir o arquivo CSV
                        conteudoCSV = new BufferedReader(new FileReader(arquivoCSV));
                        int numLinhas = 0;

                        // Contar o número de linhas no arquivo
                        while (conteudoCSV.readLine() != null) {
                            numLinhas++;
                        }

                        conteudoCSV.close();

                        // Reabrir o arquivo CSV
                        conteudoCSV = new BufferedReader(new FileReader(arquivoCSV));

                        registrosArray = new String[numLinhas - 1][]; // Subtrair 1 para excluir a linha de cabeçalho
                        int i = 0;

                        while ((linha = conteudoCSV.readLine()) != null) {
                            if (linha.equals("id,rodada,data,mandante,visitante,vencedor")) {
                                continue; // Ignorar a linha de cabeçalho
                            }
                            String[] campeonato = linha.split(separadorCSV);
                            registrosArray[i] = campeonato;
                            i++;
                            System.out.println("Registros salvos com sucesso!");
                        }

                        // Converter os registros em objetos Brasileirao
                        List<Brasileirao> listaBrasileirao = converterParaBrasileirao(registrosArray);

                        // Exibir os objetos Brasileirao
                        for (Brasileirao brasileirao : listaBrasileirao) {
                            System.out.println(brasileirao);
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("Arquivo não encontrado: " + e.getMessage());
                    } catch (IOException e) {
                        System.out.println("Erro de leitura/escrita: " + e.getMessage());
                    } finally {
                        try {
                            if (conteudoCSV != null) {
                                conteudoCSV.close();
                            }
                        } catch (IOException e) {
                            System.out.println("Erro ao fechar o arquivo: " + e.getMessage());
                        }
                    }
                    break;
                case 2:
                    // Opção 2: Criar registro
                    break;
                case 3:
                    // Opção 3: Ler registro
                    break;
                case 4:
                    // Opção 4: Atualizar registro
                    break;
                case 5:
                    // Opção 5: Deletar registro
                    break;
            }
        }

        // Fechar o scanner
        scanner.close();
    }

    // Método para converter os registros em objetos Brasileirao
    public static List<Brasileirao> converterParaBrasileirao(String[][] registrosArray) {
        List<Brasileirao> listaBrasileirao = new ArrayList<>();

        // Loop para converter cada registro em um objeto Brasileirao
        for (String[] registro : registrosArray) {
            int id = Integer.parseInt(registro[0]);
            int rodada = Integer.parseInt(registro[1]);
            String data = registro[2];
            String mandante = registro[3];
            String visitante = registro[4];
            String vencedor = registro[5];

            // Criar um objeto Brasileirao com os dados do registro
            Brasileirao brasileirao = new Brasileirao(id, rodada, data, mandante, visitante, vencedor);
            listaBrasileirao.add(brasileirao);
        }
        return listaBrasileirao; // Retorna a lista de objetos Brasileirao criada
    }
}
