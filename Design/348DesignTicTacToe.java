        //My solution
        //Simple approach
        //For every new move, we check that move row and column,
        //and if they're in one of the main diagonals we check that one
        //Average-bad runtime at 48ms better than 30.88% O(N) 
        //Bad memory at 46.6mb better than only 21.43% O(N^2)
class TicTacToe {
    
    int matrix[][];
    final int size;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        matrix=new int[n][n];
        size=n;
    } 
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        matrix[row][col]=player;
        int i;
        for(i=0;i<size;i++){
            //System.out.println(player+" checking row");
            if(matrix[row][i]!=player) break;
        }
        if(i==size){
            //System.out.println(player+" wins 1");
            return player;
        }
        for(i=0;i<size;i++){
            //System.out.println(player+" checking col");
            if(matrix[i][col]!=player) break;
        }
        if(i==size){
            //System.out.println(player+" wins 2");
            return player;
        }
        
        
        if(row==col){
            //first diagonal
            for(i=0;i<size;i++){
                //System.out.println(player+" checking row");
                if(matrix[i][i]!=player) break;
            }
            if(i==size){
                //System.out.println(player+" wins 3");
                return player;
            }
        }
        
        if(row+col==size-1){
            //second diagonal
            for(i=0;i<size;i++){
                //System.out.println(player+" checking row");
                if(matrix[i][size-1-i]!=player) break;
            }
            if(i==size){
                //System.out.println(player+" wins 4");
                return player;
            }
        }
        return 0;
    }
}

        //Fastest solution at 44ms better than 100% O(N)
        //Like my solution, count every row and column and diagonal
        //Looking for possible full rows or columns
class TicTacToe {
    
    private int[][] board;
    private int size;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.board = new int[n][n];
        this.size = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int x = player;
        int n = this.size;
        int result = 0;
        board[row][col] = x;
        
        boolean win = true;
        for(int i=0;i<n;i++){
            if(board[row][i] != x){
                win = false;
                break;
            }
        }
        if(win) return player;
        
        win = true;
        for(int i=0;i<n;i++){
            if(board[i][col] != x){
                win = false;
                break;
            } 
        }
        if(win) return player;
        
        win = true;
        for(int i = 0;i<n;i++){
            if(board[i][i] != x){
                win = false;
                break;
            }
        }
        if(win) return player;
        
        win = true;
        for(int i = 0;i<board.length;i++){
            if(board[i][board.length-i-1] != x){
                win = false;
                break;
            }
        }
        if(win) return player;
        
        return result;
    }
}

        //Java O(1) solution
        //Instead of counting every time the total number per column, keep a count
        //of every row and column, for player one add 1, for player 2 decrease 1
        //Finally use math abs to get if a column of row it equal to the game size
        //Also, keep two separate variables for the two diagonals
public class TicTacToe {
    private int[] rows;
    private int[] cols;
    private int diagonal;
    private int antiDiagonal;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
    }

    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int toAdd = player == 1 ? 1 : -1;
        
        rows[row] += toAdd;
        cols[col] += toAdd;
        if (row == col)
        {
            diagonal += toAdd;
        }
        
        if (col == (cols.length - row - 1))
        {
            antiDiagonal += toAdd;
        }
        
        int size = rows.length;
        if (Math.abs(rows[row]) == size ||
            Math.abs(cols[col]) == size ||
            Math.abs(diagonal) == size  ||
            Math.abs(antiDiagonal) == size)
        {
            return player;
        }
        
        return 0;
    }
}