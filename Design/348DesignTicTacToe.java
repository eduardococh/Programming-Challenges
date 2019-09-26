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

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */