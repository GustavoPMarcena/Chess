import chesslayer.ChessMatch;

public class Main {
    public static void main(String[] args) {
        ChessMatch partida = new ChessMatch();
        UI ui = new UI();
        ui.imprimirTabuleiro(partida.getPieces());
    }
}
