package padroescomportamentais.chainofresponsability;

public class AprovadorDiretor extends Aprovador {

    public AprovadorDiretor(Aprovador superior) {
        setAprovadorSuperior(superior);
    }

    public String getDescricaoCargo() {
        return "Diretor";
    }

    public double getLimite() {
        return 5000.0;
    }
}
