package TP_2_Semestre;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/***********************************************************************************
 *                              TRABALHO PRÃTICO FINAL * ALUNOS: CHRYSTIAN
 *HENRIQUE FONSECA DE SOUZA; SAMARA HELLEN FERREIRA CHAVES    * TURMA: 3110101 *
 ***********************************************************************************/

public class ClassePrincipal {
    public static void main(String[] args) throws IOException {
    	// Fazendo com que o programa abra e leia um arquivo txt
    	
    	// Declaração de variáveis
    	String CaminhoArquivo = "D:\\LabAEDII\\src\\TP_2_Semestre\\ArquivoTP";
    	// Leitura do arquivo
    	BufferedReader Leitor = new BufferedReader(new FileReader(CaminhoArquivo)); //Abre o arquivo
		String linha = "";
		while (true) { //Condição para que o programa leia todo o arquivo txt
			if (linha != null) {
                linha = linha.replaceAll("[^a-zA-Z0-9]", ""); //Despreza os sinais de pontuação e espacos
                linha = linha.toLowerCase(); //Converte as letras maiusculas em minusculas
				System.out.println(linha); //Apos as modificacoes, "le" o arquivo
			} 
			else // Caso não haja mais nada para ler, o programa encerra a leitura
				break;
			linha = Leitor.readLine();
		}
		Leitor.close();
		
		//Criando a arvore binaria AVL
	}
}
