package TP_2_Semestre;

/***********************************************************************************
 * TRABALHO PRÃTICO FINAL * ALUNOS: CHRYSTIAN
 * HENRIQUE FONSECA DE SOUZA; SAMARA HELLEN FERREIRA CHAVES * TURMA: 3110101 *
 ***********************************************************************************/
public class ListaDupla {
    // Declarando as variáveis
    No dir;
    No esq;

    // Método construtor vazio
    public ListaDupla() {
        this.dir = null;
        this.esq = null;
    }

    // Métodos de inserção e remoção na lista
    // Inserir no início
    public void inserirInicio(Palavra palavra) {
        // Criação de um novo nó para inserção da palavra no início da lista
        No tmp = new No(palavra);
        // Condição caso a lista esteja vazia
        if (dir == null) {
            dir = tmp;
            esq = tmp;
        } else { // Se não, faz o devido encadeamento para o tmp virar o primeiro
            tmp.dir = dir;
            dir.esq = tmp;
            dir = tmp;
        }
    }

    // Inserir no fim
    public void inserirFim(Palavra palavra) {
        // Criação de um novo nó para inserção da palavra no fim da lista
        No tmp = new No(palavra);
        // Condição caso a lista esteja vazia
        if (esq == null) {
            dir = tmp;
            esq = tmp;
        } else { // Se não, faz o devido encadeamento para o tmp virar o último
            tmp.esq = esq;
            esq.dir = tmp;
            esq = tmp;
        }
    }

    // Remover no início
    public void removerInicio() {
        // Condição caso a lista esteja vazia
        if (dir == null) {
            System.out.println("A lista está vazia. Não é possível remover.");
        } else if (dir == esq) { // Condição caso haja apenas um nó na lista
            dir = null;
            esq = null;
        } else { // Remove o nó no início e atualiza as referências
            dir = dir.dir;
            dir.esq = null;
        }
    }

    // Remover no fim
    public void removerFim() {
        // Condição caso a lista esteja vazia
        if (esq == null) {
            System.out.println("A lista está vazia. Não é possível remover.");
        } else if (dir == esq) { // Condição caso haja apenas um nó na lista
            dir = null;
            esq = null;
        } else { // Remove o nó no fim e atualiza as referências
            esq = esq.esq;
            esq.dir = null;
        }
    }
}
