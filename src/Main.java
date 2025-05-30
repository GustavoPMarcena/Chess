import boardgame.Board;
import chesslayer.ChessException;
import chesslayer.ChessMatch;
import chesslayer.ChessPiece;
import chesslayer.ChessPosition;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ChessMatch partida = new ChessMatch();
        UI ui = new UI();
        Scanner sc = new Scanner(System.in);
        while (!partida.isCheckmate()) {
            try {
                System.out.println("Turno das " + partida.getTurn().getDescricao());
                ui.imprimirTabuleiro(partida.getPieces());
                System.out.print("Digite a peça a mover: ");
                ChessPosition peca = ui.lerPosicao(sc);
                System.out.print("Digite o destino: ");
                ChessPosition destino = ui.lerPosicao(sc);

                ChessPiece capturada = partida.performMove(peca, destino);
                ui.imprimirEspacamento();
            }
            catch (ChessException | InputMismatchException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }

        }
        System.out.println(partida.getMensagemVitoria());
    }
}
