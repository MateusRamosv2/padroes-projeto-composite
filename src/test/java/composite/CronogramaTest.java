package composite;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CronogramaTest {

    @Test
    void deveRetornarEscopoCronogramaCompleto() {
        // Montando a Fase 1 (Apenas tarefas)
        Fase faseLevantamento = new Fase("Levantamento de Requisitos");
        Tarefa tarefa1 = new Tarefa("Entrevista com o cliente", 4);
        faseLevantamento.addAtividade(tarefa1);

        // Montando a Fase 2 (Apenas tarefas)
        Fase faseDesenvolvimento = new Fase("Desenvolvimento Backend");
        Tarefa tarefa2 = new Tarefa("Modelar banco de dados", 8);
        Tarefa tarefa3 = new Tarefa("Criar API REST", 16);
        faseDesenvolvimento.addAtividade(tarefa2);
        faseDesenvolvimento.addAtividade(tarefa3);

        // Montando o Escopo Principal (Uma fase que contém outras fases)
        Fase escopoGeral = new Fase("Projeto Sistema ERP Cloud");
        escopoGeral.addAtividade(faseLevantamento);
        escopoGeral.addAtividade(faseDesenvolvimento);

        Cronograma cronograma = new Cronograma();
        cronograma.setEscopoPrincipal(escopoGeral);

        // Validando se a árvore inteira foi lida corretamente
        assertEquals("Fase: Projeto Sistema ERP Cloud\n" +
                "Fase: Levantamento de Requisitos\n" +
                "Tarefa: Entrevista com o cliente - esforço estimado: 4h\n" +
                "Fase: Desenvolvimento Backend\n" +
                "Tarefa: Modelar banco de dados - esforço estimado: 8h\n" +
                "Tarefa: Criar API REST - esforço estimado: 16h\n", cronograma.getEscopoPrincipal());
    }

    @Test
    void deveRetornarExcecaoCronogramaSemEscopo() {
        try {
            Cronograma cronograma = new Cronograma();
            cronograma.getEscopoPrincipal();
            fail();
        }
        catch (NullPointerException e) {
            assertEquals("Cronograma sem escopo definido", e.getMessage());
        }
    }
}