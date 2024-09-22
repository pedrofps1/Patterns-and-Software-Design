package JogoDoGalo;
public class JGaloEngine implements JGaloInterface {

    private int controlPlayer = 0;
    private char[][] board = new char[3][3];
    private char winner = ' ';
    private int boardsize = 3;
    private char player1 = 'X';
    private char player2 = 'O';
    private char player;

    public JGaloEngine(String args[]) {
        for (int i = 0; i < boardsize; i++) {
            for (int j = 0; j < boardsize; j++) {
                board[i][j] = ' ';
            }
        }
    }

    @Override
    public char getActualPlayer() {
        if (controlPlayer % 2 == 0) {
            player = player1;
        } else {
            player = player2;
        }
        controlPlayer++;
        return player;
    }

    @Override
    public boolean setJogada(int lin, int col) {
        if (board[lin - 1][col - 1] == ' ') {
            board[lin - 1][col - 1] = player;
            return true;
        } else {
            return false;
        }
    }

    int count = 0;

    @Override
    public boolean isFinished() {
        count++;
        int x;
        int y;
        if (count == (boardsize * boardsize)) {
            return true;
        }
        for (y = 0; y < boardsize; y++) {
            x = 0;
            if ((board[x][y] == player1 && board[x + 1][y] == player1 && board[x + 2][y] == player1)
                    || (board[x][y] == player2 && board[x + 1][y] == player2 && board[x + 2][y] == player2)) {
                if (board[x][y] == player1) {
                    winner = player1;
                } else
                    winner = player2;
                return true;
            }
        }
        for (x = 0; x < boardsize; x++) {
            y = 0;
            if ((board[x][y] == player1 && board[x][y + 1] == player1 && board[x][y + 2] == player1)
                    || (board[x][y] == player2 && board[x][y + 1] == player2 && board[x][y + 2] == player2)) {
                if (board[x][y] == player1) {
                    winner = player1;
                } else
                    winner = player2;
                return true;
            }

        }
        if ((board[0][0] == player1 && board[1][1] == player1 && board[2][2] == player1)
                || (board[0][0] == player2 && board[1][1] == player2 && board[2][2] == player2)) {
            if (board[0][0] == player1) {
                winner = player1;
            } else
                winner = player2;
            return true;
        }
        if ((board[0][2] == player1 && board[1][1] == player1 && board[2][0] == player1)
                || (board[0][2] == player2 && board[1][1] == player2 && board[2][0] == player2)) {
            if (board[0][2] == player1) {
                winner = player1;
            } else
                winner = player2;
            return true;
        }
        return false;
    }

    @Override
    public char checkResult() {
        return winner;
    }
}
