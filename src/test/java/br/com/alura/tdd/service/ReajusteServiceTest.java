package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {

    private ReajusteService service;
    private Funcionario funcionario;

    @BeforeEach
    public void inicializar(){
        service = new ReajusteService();
        funcionario = new Funcionario("Mula sem cabeça", LocalDate.now(), new BigDecimal("1000"));
    }

    @AfterEach
    public void finalizar(){
        System.out.println("Chegou ao final do código -> Próximo");
    }

    @BeforeAll
    private static void antesDeTodos(){
        System.out.println("Antes de Todos");
    }

    @AfterAll
    public static void depoisDeTodos(){
        System.out.println("Depois de Todos");
    }

    @Test
    void ReajusteDeveriaSerTresPorcentoQuandoDesempenhoForADesejar(){
        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }
    @Test
    void ReajusteDeveriaSerQuinzePorcentoQuandoDesempenhoForBom(){
        service.concederReajuste(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }
    @Test
    void ReajusteDeveriaSerVintePorcentoQuandoDesempenhoForOtimo(){
        service.concederReajuste(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
    @Test
    void ReajusteDeveriaSerQuarentaPorcentoQuandoDesempenhoForEspetacular(){
        service.concederReajuste(funcionario, Desempenho.ESPETACULAR);
        assertEquals(new BigDecimal("1400.00"), funcionario.getSalario());
    }
    @Test
    void ReajusteDeveriaSerSemReajusteQuandoDesempenhoForInferiorAMeta(){
        service.concederReajuste(funcionario, Desempenho.NAO_ALCANCADO);
        assertEquals(new BigDecimal("1000.00"), funcionario.getSalario());
    }
}
