package padroescomportamentais.chainofresponsability;

public class Solicitacao {

    private String solicitante;
    private double valor;

    public Solicitacao(String solicitante, double valor) {
        this.solicitante = solicitante;
        this.valor = valor;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public double getValor() {
        return valor;
    }
}
