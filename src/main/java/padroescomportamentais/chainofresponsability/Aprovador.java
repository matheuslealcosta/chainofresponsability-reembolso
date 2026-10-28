package padroescomportamentais.chainofresponsability;

public abstract class Aprovador {

    private Aprovador aprovadorSuperior;

    public Aprovador getAprovadorSuperior() {
        return aprovadorSuperior;
    }

    public void setAprovadorSuperior(Aprovador aprovadorSuperior) {
        this.aprovadorSuperior = aprovadorSuperior;
    }

    public abstract String getDescricaoCargo();

    public abstract double getLimite();

    public String aprovarReembolso(Solicitacao solicitacao) {
        if (solicitacao.getValor() <= this.getLimite()) {
            return getDescricaoCargo();
        }
        else {
            if (aprovadorSuperior != null) {
                return aprovadorSuperior.aprovarReembolso(solicitacao);
            }
            else {
                return "Reembolso negado";
            }
        }
    }
}
