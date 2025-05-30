package chesslayer;

public enum Color {
    BLACK("pretas"),
    WHITE("brancas");

    private final String descricao;

    private Color(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
