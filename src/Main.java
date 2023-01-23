import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
        int turn = 0;
        while (true) {
            printBoard(board);
            int row = turn % 2 == 0 ? getInput('X') : getInput('O');
            int col = turn % 2 == 0 ? getInput('X') : getInput('O');
            board[row][col] = turn % 2 == 0 ? 'X' : 'O';
            if (isWin(board, row, col)) {
                printBoard(board);
                System.out.println(turn % 2 == 0 ? "X wygrał" : "O wygrał");
                break;
            }
            if (isDraw(board)) {
                printBoard(board);
                System.out.println("Remis");
                break;
            }
            turn++;
        }
    }

    private static boolean isDraw(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isWin(char[][] board, int row, int col) {
        return board[row][0] == board[row][1] && board[row][0] == board[row][2]
                || board[0][col] == board[1][col] && board[0][col] == board[2][col]
                || row == col && board[0][0] == board[1][1] && board[0][0] == board[2][2]
                || row + col == 2 && board[2][0] == board[1][1] && board[2][0] == board[0][2];
    }

    private static int getInput(char player) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Gracz " + player + " wybierz wiersz (0-2):");
        int row = scanner.nextInt();
        System.out.println("Gracz " + player + " wybierz kolumnę (0-2):");
        int col = scanner.nextInt();
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            System.out.println("Niepoprawny wybór");
            return getInput(player);
        }
        return row;
    }

    private static void printBoard(char[][] board) {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
}