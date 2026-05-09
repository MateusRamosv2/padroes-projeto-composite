package composite;

public class Tarefa extends Atividade {

    private int horasEstimadas;

    public Tarefa(String descricao, int horasEstimadas) {
        super(descricao);
        this.horasEstimadas = horasEstimadas;
    }

    public int getHorasEstimadas() {
        return horasEstimadas;
    }

    public void setHorasEstimadas(int horasEstimadas) {
        this.horasEstimadas = horasEstimadas;
    }

    public String getDetalhes() {
        return "Tarefa: " + this.getDescricao() + " - esforço estimado: " + this.horasEstimadas + "h\n";
    }
}