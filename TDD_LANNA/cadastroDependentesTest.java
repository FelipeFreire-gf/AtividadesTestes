import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CadastroDependentesTest {

    private IRPF irpf;

    @Before
    public void setUp() {
        irpf = new IRPF();
    }

    @Test
    public void testeCadastrarUmDependente() {
        // Ciclo 1: Força a criação dos métodos `cadastrarDependente` e `getDeducaoDependentes`.
        // A primeira implementação em IRPF usaria Falsificação, retornando 189.59f diretamente.
        irpf.cadastrarDependente("João");
        assertEquals(189.59f, irpf.getDeducaoDependentes(), 0.0f);
    }

    @Test
    public void testeCadastrarDoisDependentes() {
        // Ciclo 2: Duplicação. Força a implementação a lidar com mais de um caso.
        // A implementação em IRPF teria um if/else para tratar 1 ou 2 dependentes.
        irpf.cadastrarDependente("João");
        irpf.cadastrarDependente("Maria");
        assertEquals(189.59f * 2, irpf.getDeducaoDependentes(), 0.0f);
    }

    @Test
    public void testeCadastrarTresDependentes() {
        // Ciclo 3: Triangulação. Força a generalização completa da regra.
        // A implementação em IRPF abandona o if/else e adota a fórmula final:
        // `dependentes.length * 189.59f`.
        irpf.cadastrarDependente("João");
        irpf.cadastrarDependente("Maria");
        irpf.cadastrarDependente("José");
        assertEquals(189.59f * 3, irpf.getDeducaoDependentes(), 0.0f);
    }
}