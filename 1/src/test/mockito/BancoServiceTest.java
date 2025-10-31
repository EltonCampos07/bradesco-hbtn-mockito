package projeto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BancoServiceTest {

    @Mock
    private ContaRepository contaRepository;

    @InjectMocks
    private BancoService bancoService;

    @Test
    public void testConsultarSaldo() {
        when(contaRepository.buscarConta("12345"))
                .thenReturn(new Conta("12345", 1000.0));

        assertEquals(1000.0, bancoService.consultarSaldo("12345"));

        verify(contaRepository, times(1)).buscarConta("12345");

    }

    @Test
    void testDepositar() {
        Conta conta = new Conta("12345", 500.0);

        when(contaRepository.buscarConta("12345")).thenReturn(conta);

        bancoService.depositar("12345", 200.0);

        assertEquals(700.0, conta.getSaldo(), 0.0001);

        verify(contaRepository).buscarConta("12345");

        ArgumentCaptor<Conta> captor = ArgumentCaptor.forClass(Conta.class);
        verify(contaRepository).salvar(captor.capture());
        assertEquals(700.0, captor.getValue().getSaldo(), 0.0001);
    }

}