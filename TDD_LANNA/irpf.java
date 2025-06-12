import java.util.Arrays;

public class IRPF {

    private float totalSalario;
    private String[] dependentes;
    // Outros campos para previdência, pensão, etc., seriam adicionados aqui.

    public IRPF() {
        // Construtor que inicializa o vetor de dependentes para evitar NullPointerException,
        // um passo descoberto durante o primeiro teste de dependentes.
        this.dependentes = new String[0];
    }

    // --- MÉTODOS DE RENDIMENTO ---

    /**
     * Este método foi construído usando TDD.
     * 1. (Falsificação/Duplicação): A primeira versão apenas substituía o valor do salário.
     * 2. (Triangulação): O terceiro teste (com dois salários) forçou a mudança da lógica
     * de uma simples atribuição para uma acumulação (+=).
     */
    public void cadastrarSalario(float salario) {
        this.totalSalario += salario;
    }

    /**
     * Este método foi evoluindo junto com o cadastrarSalario.
     * 1. (Falsificação): A primeira versão retornava um valor fixo: return 5000.0f;
     * 2. (Duplicação): A segunda versão retornava o valor de um atributo: return this.salario;
     * 3. (Triangulação): A versão final retorna o atributo acumulado: return this.totalSalario;
     */
    public float getTotalSalario() {
        return totalSalario;
    }


    // --- MÉTODOS DE DEDUÇÃO ---

    /**
     * Lógica para adicionar um novo dependente.
     * A implementação usa um vetor temporário para redimensionar o vetor original.
     * Esta lógica foi construída e validada passo a passo pelos testes de dependentes.
     */
    public void cadastrarDependente(String nome) {
        // Cria um vetor temporário com uma posição a mais.
        String[] temp = new String[this.dependentes.length + 1];

        // Copia os dependentes existentes para o vetor temporário.
        for (int i = 0; i < this.dependentes.length; i++) {
            temp[i] = this.dependentes[i];
        }

        // Adiciona o novo dependente na última posição.
        temp[this.dependentes.length] = nome;

        // Atualiza a referência do vetor original.
        this.dependentes = temp;
    }

    /**
     * Este método também foi construído com TDD.
     * 1. (Falsificação): A primeira versão retornava o valor fixo para 1 dependente: return 189.59f;
     * 2. (Duplicação): A segunda versão tinha um if/else para tratar 1 ou 2 dependentes.
     * 3. (Triangulação): O terceiro teste (3 dependentes) nos forçou a generalizar a regra,
     * eliminando a necessidade de múltiplos if/else e chegando à fórmula final.
     */
    public float getDeducaoDependentes() {
        final float VALOR_POR_DEPENDENTE = 189.59f;
        return this.dependentes.length * VALOR_POR_DEPENDENTE;
    }
}