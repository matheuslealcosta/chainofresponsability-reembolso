package padroescomportamentais.chainofresponsability;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolicitacaoTest {

    AprovadorPresidente presidente;
    AprovadorDiretor diretor;
    AprovadorGerente gerente;

    @BeforeEach
    void setUp() {
        presidente = new AprovadorPresidente(null);
        diretor = new AprovadorDiretor(presidente);
        gerente = new AprovadorGerente(diretor);
    }

    @Test
    void deveRetornarGerenteParaReembolsoPequeno() {
        assertEquals("Gerente", gerente.aprovarReembolso(new Solicitacao("Ana", 250.0)));
    }

    @Test
    void deveRetornarGerenteNoLimiteDeQuinhentos() {
        assertEquals("Gerente", gerente.aprovarReembolso(new Solicitacao("Ana", 500.0)));
    }

    @Test
    void deveRetornarDiretorLogoAcimaDoLimiteDoGerente() {
        assertEquals("Diretor", gerente.aprovarReembolso(new Solicitacao("Bruno", 500.01)));
    }

    @Test
    void deveRetornarDiretorNoLimiteDeCincoMil() {
        assertEquals("Diretor", gerente.aprovarReembolso(new Solicitacao("Bruno", 5000.0)));
    }

    @Test
    void deveRetornarPresidenteParaReembolsoGrande() {
        assertEquals("Presidente", gerente.aprovarReembolso(new Solicitacao("Carla", 18000.0)));
    }

    @Test
    void deveRetornarReembolsoNegadoAcimaDeQualquerLimite() {
        assertEquals("Reembolso negado", gerente.aprovarReembolso(new Solicitacao("Diego", 50000.01)));
    }

    @Test
    void deveComecarCadeiaPeloDiretor() {
        assertEquals("Diretor", diretor.aprovarReembolso(new Solicitacao("Ana", 100.0)));
    }

    @Test
    void deveRetornarSolicitante() {
        assertEquals("Ana", new Solicitacao("Ana", 100.0).getSolicitante());
    }
}
