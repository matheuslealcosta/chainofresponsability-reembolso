package padroescomportamentais.chainofresponsability;

public class AprovadorGerente extends Aprovador {

    public AprovadorGerente(Aprovador superior) {
        setAprovadorSuperior(superior);
    }

    public String getDescricaoCargo() {
        return "Gerente";
    }

    public double getLimite() {
        return 500.0;
    }
}
