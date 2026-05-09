package composite;

import java.util.ArrayList;
import java.util.List;

public class Fase extends Atividade {

    private List<Atividade> atividades;

    public Fase(String descricao) {
        super(descricao);
        this.atividades = new ArrayList<Atividade>();
    }

    public void addAtividade(Atividade atividade) {
        this.atividades.add(atividade);
    }

    public String getDetalhes() {
        String saida = "Fase: " + this.getDescricao() + "\n";
        for (Atividade atividade : atividades) {
            saida += atividade.getDetalhes(); // Aqui ocorre a mágica da recursividade!
        }
        return saida;
    }
}