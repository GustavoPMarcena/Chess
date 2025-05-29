import chesslayer.ChessMatch;
import chesslayer.ChessPiece;
import chesslayer.ChessPosition;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ChessMatch partida = new ChessMatch();
        UI ui = new UI();
        Scanner sc = new Scanner(System.in);
        while (true) {
            ui.imprimirTabuleiro(partida.getPieces());
            System.out.print("Digite a peça a mover: ");
            ChessPosition peca = ui.lerPosicao(sc);
            System.out.print("Digite o destino: ");
            ChessPosition destino = ui.lerPosicao(sc);

            ChessPiece capturada = partida.performMove(peca, destino);


        }
    }
}
