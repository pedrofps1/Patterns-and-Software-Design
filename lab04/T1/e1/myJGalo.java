package e1;
// package lab03;

public class myJGalo implements JGaloInterface {
    private char[][] board = new char[3][3];
    private char currentPlayer = 'X';
    private int moves = 0;
    //constructor
    public myJGalo(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = ' ';
            }
        }
    }
    
    // 'O' or 'X'
    public char getActualPlayer(){
        // definição de quem começa a jogar (X ou O)
        if (get_moves() % 2 == 0) {
            return 'X';
        } else {
            return 'O';
        }
  
    }
    
	public boolean setJogada(int lin, int col){
        if (getBoardPosition(lin-1, col-1) == ' ') {
            setBoardPosition(lin-1, col-1, getCurrentPlayer());
            System.out.println(getCurrentPlayer() + " jogou na posição " + lin + " " + col);
            set_moves(get_moves()+1);
            setCurrentPlayer(getActualPlayer());                                            //muda o jogador de acordo com o número de movimentos
            return true;
        } else {
            return false;
        }

    }


	public boolean isFinished(){
        // todos os espaços estao preenchidos ou alguem ganha
        if (get_moves() == 9 || checkResult() == 'X' || checkResult() == 'O') {
            return true;
        } else {
            return false;
        }

    }
    
	public char checkResult(){
        if (get_moves() >= 5) {
            //vertical
            for (int x=0; x < board.length; x++){
                    if(getBoardPosition(x, 0) != ' ' && getBoardPosition(x,0) == getBoardPosition(x,1) && getBoardPosition(x,1) == getBoardPosition(x,2)){
                        return getOppositePlayer();
                    }
            }

            //horizontal
            for(int y=0; y < board.length; y++){
                    if(getBoardPosition(0, y) != ' ' && getBoardPosition(0, y) == getBoardPosition(1, y) && getBoardPosition(1, y) == getBoardPosition(2, y)){
                        return getOppositePlayer();
                    }
                }

            //diagonal
            if(getBoardPosition(0, 0) != ' ' && getBoardPosition(0, 0) == getBoardPosition(1, 1) && getBoardPosition(1, 1) == getBoardPosition(2, 2)){
                return getOppositePlayer();
            }

            //diagonal inversa
            if(getBoardPosition(0, 2) != ' ' && getBoardPosition(0, 2) == getBoardPosition(1, 1) && getBoardPosition(1, 1) == getBoardPosition(2, 0)){
                return getOppositePlayer();
            }    
        }
        return ' ';
    }

    //setter and getters
    public void setPlayer1(char player1) {
        this.player1 = player1;
    }
    
    public void setPlayer2(char player2) {
        this.player2 = player2;
    }
    
    public char getPlayer1() {
        return player1;
    }
    
    public char getPlayer2() {
        return player2;
    }
    
    public void setGameEnded(boolean gameEnded) {
        this.gameEnded = gameEnded;
    }

    public boolean getGameEnded() {
        return gameEnded;
    }
    
    public void setBoard(char[][] board) {
        this.board = board;
    }

    public char[][] getBoard() {
        return board;
    }

    public void setBoardPosition(int x, int y, char value) {
        board[x][y] = value;
    }
    
    public char getBoardPosition(int x, int y) {
        return board[x][y];
    }

    public void setCurrentPlayer(char currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public char getOppositePlayer() {
        if (getCurrentPlayer() == 'X') {
            return 'O';
        } else {
            return 'X';
        }
    }

    public void set_moves(int moves) {
        this.moves = moves;
    }

    public int get_moves() {
        return moves;
    }
    
    
}
