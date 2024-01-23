package TP_2_Semestre;

public class ArvoreAVL {
	// Declaracao de variavel raiz
	No Raiz;

	// Metodo construtor vazio
	public ArvoreAVL() {
		Raiz = null;
	}

	// Métodos de rotação
	No RotSimpEsq(No a) {
		No b = a.dir;
		a.dir = b.esq;
		b.esq = a;
		a.altura = Math.max(altura(a.esq), altura(a.dir)) + 1;
		b.altura = Math.max(altura(b.dir), a.altura) + 1;
		return b;
	}

	No RotSimpDir(No a) {
		No b = a.esq;
		a.esq = b.dir;
		b.dir = a;
		a.altura = Math.max(altura(a.esq), altura(a.dir)) + 1;
		b.altura = Math.max(altura(b.esq), a.altura) + 1;
		return b;
	}

	No RotDupEsqDir(No a) {
		a.esq = RotSimpEsq(a.esq);
		return RotSimpDir(a);
	}

	No RotDupDirEsq(No a) {
		a.dir = RotSimpDir(a.dir);
		return RotSimpEsq(a);
	}

	// Método para obter a altura de um nó
	int altura(No n) {
		if (n == null) {
			return -1;
		}
		return n.altura;
	}

	// Metodo que calcula o fator de balanceamento da árvore
	int fatorBalanceamento(No n) {
		if (n == null) {
			return 0;
		}
		return altura(n.esq) - altura(n.dir);// F
	}

	// Metodo Inserir, com balanceamento por rotacao
	void inserir(Palavra x) throws Exception {
		Raiz = Inserir(x, Raiz);
	}

	No Inserir(Palavra x, No i) throws Exception {
		// Caso a arvore esteja vazia, insere no "primeiro" No
		if (i == null) {
			i = new No(x);
		}
		// Caso o valor seja menor que o elemento do no avaliado, insere na esquerda do
		// mesmo
		else if (x.getPalavra().compareTo(i.p.getPalavra()) < 0) {
			i.esq = Inserir(x, i.esq);
		}
		// Caso o valor seja maior que o elemento do no avaliado, insere na direita do
		// mesmo
		else if (x.getPalavra().compareTo(i.p.getPalavra()) < 0) {
			i.dir = Inserir(x, i.dir);
		}
		// Caso nao se enquadre em nenhuma condicao, da a mensagem de erro
		else {
			throw new Exception("ERRO!");
		}

		// Chamando o método que calcula o fator de balanceamento
		int balanceamento = fatorBalanceamento(i);

		// Verifica se é necessário realizar rotações para balancear a árvore
		if (balanceamento > 1) {
			if (x.getPalavra().compareTo(i.esq.p.getPalavra()) < 0) {
				// Chamando o metodo que faz a rotação simples a direita
				i = RotSimpDir(i);
			} else {
				// Chamando o metodo que faz a rotação dupla a esquerda e a direita
				i = RotDupEsqDir(i);
			}
		} else if (balanceamento < -1) {
			if (x.getPalavra().compareTo(i.dir.p.getPalavra()) > 0) {
				// Chamando o metodo que faz a rotação simples a esquerda
				i = RotSimpEsq(i);
			} else {
				// Chamando o metodo que faz a rotação dupla a direita e a esquerda
				i = RotDupDirEsq(i);
			}
		}

		return i;
	}

	// Metodo Caminhar Central
	void Caminhar_Central(No i) {
		if (i != null) {
			Caminhar_Central(i.esq);
			System.out.print(i.p + " ");
			Caminhar_Central(i.dir);
		}
	}

	// Metodo Remover, com balanceamento por rotacao
	void Remover(Palavra x) throws Exception {
		Raiz = Remover(x, Raiz);
	}

	No Remover(Palavra x, No i) throws Exception {
		// Caso a árvore esteja vazia
		if (i == null) {
			throw new Exception("ERRO!");
		}
		// Caso o Elemento seja menor que o nodo procurado, procura na esquerda
		else if (x.getPalavra().compareTo(i.p.getPalavra()) < 0) {
			i.esq = Remover(x, i.esq);
		}
		// Caso o Elemento seja maior que o nodo procurado, procura na direita
		else if (x.getPalavra().compareTo(i.p.getPalavra()) < 0) {
			i.dir = Remover(x, i.dir);
		}
		// Verifica se não tem filhos à direita
		else if (i.dir == null) {
			i = i.esq;
		}
		// Verifica se não tem filhos à esquerda
		else if (i.esq == null) {
			i = i.dir;
		}
		// Caso tenha os dois filhos, verifica qual é o maior
		else {
			i.esq = MaiorEsq(i, i.esq);
		}
		return i;
	}

	No MaiorEsq(No i, No j) {
		// Caso não tenha mais filhos à direita
		if (j.dir == null) {
			i.p = j.p;
			j = j.esq;
		}
		// Caso tenha mais filhos à direita, verifica novamente qual é o maior
		else {
			j.dir = MaiorEsq(i, j.dir);
		}
		return j;
	}

	// Metodo Imprimir
	void Imprimir() {
		System.out.println("Árvore AVL: ");
		Caminhar_Central(Raiz);
		System.out.println(""); // Espaço
		System.out.println(""); // Espaço
	}
}
