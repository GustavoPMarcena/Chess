import chesslayer.ChessPiece;

public class UI {
    public void imprimirTabuleiro(ChessPiece[][] matriz) {
        int tamanhoMatriz = matriz.length;
        for(int i = 0; i< tamanhoMatriz; i++) {
            System.out.print(tamanhoMatriz-i + " ");
            for (int j = 0; j < tamanhoMatriz; j++) {
                imprimirPecasComLogica(matriz[i][j]);
            }
            System.out.println();
        }
        System.out.println("  A B C D E F G H");
    }

    public void imprimirPecasComLogica (ChessPiece piece) {
        if (piece != null) {
            System.out.print(piece.toString());
        } else {
            System.out.print("-");
        }
        System.out.print(" ");
    }
}
