package projeto;

public class Calculadora {

    private final ServicoMatematico servicoMatematico;

    public Calculadora(ServicoMatematico servicoMatematico) {
        this.servicoMatematico = servicoMatematico;
    }

    public Integer somar(Integer a, Integer b) {
        return servicoMatematico.somar(a, b);
    }
}
