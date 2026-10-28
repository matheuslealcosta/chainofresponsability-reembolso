package padroescomportamentais.chainofresponsability;

public class AprovadorPresidente extends Aprovador {

    public AprovadorPresidente(Aprovador superior) {
        setAprovadorSuperior(superior);
    }

    public String getDescricaoCargo() {
        return "Presidente";
    }

    public double getLimite() {
        return 50000.0;
    }
}
