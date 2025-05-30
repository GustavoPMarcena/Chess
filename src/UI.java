import chesslayer.ChessMatch;
import chesslayer.ChessPiece;
import chesslayer.ChessPosition;
import chesslayer.Color;

import java.util.Scanner;

public class UI {
    public void imprimirTabuleiro(ChessPiece[][] matriz) {
        int tamanhoMatriz = matriz.length;
        for (int i = 0; i < tamanhoMatriz; i++) {
            System.out.print(tamanhoMatriz - i + " ");
            for (int j = 0; j < tamanhoMatriz; j++) {
                imprimirPecasComLogica(matriz[i][j]);
            }
            System.out.println();
        }
        System.out.println("  A B C D E F G H");
    }

    public void imprimirPecasComLogica(ChessPiece piece) {
        if (piece == null) {
            System.out.print("-" + ColorsThemes.ANSI_RESET);
        }
        else {
            if (piece.getColor() == Color.WHITE) {
                System.out.print(ColorsThemes.ANSI_WHITE + piece + ColorsThemes.ANSI_RESET);
            }
            else {
                System.out.print(ColorsThemes.ANSI_YELLOW + piece + ColorsThemes.ANSI_RESET);
            }
        }
        System.out.print(" ");

    }

    public void imprimirPecasCapturadas(ChessMatch partida) {
        if(partida.getBoard().getPecasBrancasCapturadas() != null || partida.getBoard().getPecasPretasCapturadas() != null) {
            System.out.println("Peças capturadas brancas: "+ partida.getBoard().getPecasBrancasCapturadas().toString());
            System.out.println("Peças capturadas pretas: "+ partida.getBoard().getPecasPretasCapturadas().toString());
        }
    }

    public void imprimirEspacamento () {
        System.out.println("\n\n\n\n\n");
    }

    public ChessPosition lerPosicao(Scanner sc) {
        try {
            String s = sc.nextLine();
            char column = s.charAt(0);
            int row = Integer.parseInt(s.substring(1));
            return new ChessPosition(column, row);
        } catch (NumberFormatException i) {
            System.out.println("Escreveu errado!");
        }
        return null;
    }
}
