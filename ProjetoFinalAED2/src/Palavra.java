package TP_2_Semestre;

/***********************************************************************************
 * TRABALHO PRÃTICO FINAL * ALUNOS: CHRYSTIAN
 * HENRIQUE FONSECA DE SOUZA; SAMARA HELLEN FERREIRA CHAVES * TURMA: 3110101 *
 ***********************************************************************************/
public class Palavra {
    // Declarando as variaveis
    String nome;
    Integer contador;

    // Metodo construtor padrao
    public Palavra(String nome) {
        this.nome = nome;
        this.contador = 1;
    }

	public String getPalavra() {
		return nome;
	}

}

