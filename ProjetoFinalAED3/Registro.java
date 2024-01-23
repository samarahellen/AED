public class Registro {
    private byte lapide; // 0 para válido, 1 para excluído
    private int tamanho; // tamanho do vetor de bytes
    private byte[] dados; // vetor de bytes com os dados do registro

    // Construtor
    public Registro(byte lapide, int tamanho, byte[] dados) {
        this.lapide = lapide;
        this.tamanho = tamanho;
        this.dados = dados;
    }
}
