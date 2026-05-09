package composite;

public class Cronograma {

    private Atividade escopoPrincipal;

    public void setEscopoPrincipal(Atividade escopoPrincipal) {
        this.escopoPrincipal = escopoPrincipal;
    }

    public String getEscopoPrincipal() {
        if (this.escopoPrincipal == null) {
            throw new NullPointerException("Cronograma sem escopo definido");
        }
        return this.escopoPrincipal.getDetalhes();
    }
}