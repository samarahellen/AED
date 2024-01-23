import java.io.Serializable;//A bilbioteca serializable é utiliada para serializar ou desserializar objetos.
//                          ou seja, vamos usa-la para converter os dados do csv em bytes e vice-versa.

public class Brasileirao implements Serializable {
    // Definindo os atributos
    private int id;
    private int rodada;
    private String data;
    private String mandante;
    private String visitante;
    private String vencedor;

    // Construtor padrao
    public Brasileirao(int id, int rodada, String data, String mandante, String visitante, String vencedor) {
        this.id = id;
        this.rodada = rodada;
        this.data = data;
        this.mandante = mandante;
        this.visitante = visitante;
        this.vencedor = vencedor;
    }

    // Metodos get e set para cada um dos atributos da classe
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRodada() {
        return rodada;
    }

    public void setRodada(int rodada) {
        this.rodada = rodada;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMandante() {
        return mandante;
    }

    public void setMandante(String mandante) {
        this.mandante = mandante;
    }

    public String getVisitante() {
        return visitante;
    }

    public void setVisitante(String visitante) {
        this.visitante = visitante;
    }

    public String getVencedor() {
        return vencedor;
    }

    public void setVencedor(String vencedor) {
        this.vencedor = vencedor;
    }

    // Metodo to string
    @Override
    public String toString() {
        return "Brasileirao{" +
                "id=" + id +
                ", rodada=" + rodada +
                ", data='" + data + '\'' +
                ", mandante='" + mandante + '\'' +
                ", visitante='" + visitante + '\'' +
                ", vencedor='" + vencedor + '\'' +
                '}';
    }

}
