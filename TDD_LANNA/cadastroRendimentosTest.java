import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CadastroRendimentosTest {

    private IRPF irpf;

    @Before
    public void setUp() {
        irpf = new IRPF();
    }

    @Test
    public void testeCadastrarUmSalario() {
        // Ciclo 1: Primeiro teste que força a criação dos métodos.
        // A primeira implementação em IRPF usaria Falsificação para passar neste teste.
        irpf.cadastrarSalario(5000.0f);
        assertEquals(5000.0f, irpf.getTotalSalario(), 0.0f);
    }

    @Test
    public void testeCadastrarOutroSalario() {
        // Ciclo 2: Duplicação. Este teste força a generalização da Falsificação.
        // A implementação em IRPF muda de um valor fixo para retornar o valor de um atributo.
        irpf.cadastrarSalario(6000.0f);
        assertEquals(6000.0f, irpf.getTotalSalario(), 0.0f);
    }

    @Test
    public void testeCadastrarDoisSalarios() {
        // Ciclo 3: Triangulação. Este teste força a implementação correta (acumulativa).
        // A lógica em IRPF muda de `totalSalario = valor` para `totalSalario += valor`.
        irpf.cadastrarSalario(5000.0f);
        irpf.cadastrarSalario(6000.0f);
        assertEquals(11000.0f, irpf.getTotalSalario(), 0.0f);
    }
}