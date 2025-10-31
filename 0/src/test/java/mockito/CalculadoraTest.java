package projeto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CalculadoraTest {

    @Mock
    private ServicoMatematico servicoMatematico;

    @InjectMocks
    private Calculadora calculadora;

    @Test
    @DisplayName("Cenário 1: Deve retornar a soma correta quando o serviço matemático for chamado com dois números positivos.")
    void cenario_1() {
        when(servicoMatematico.somar(2, 3)).thenReturn(5);
        var resultado = calculadora.somar(2, 3);
        assertEquals(5, resultado);
    }


}