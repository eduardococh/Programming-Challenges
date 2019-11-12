        //My solution
        //Simple, count every ship and remove it from array
        //Amazing runtime 0ms better than 100% O(M*N)
        //Amazing memory better than 95.65% O(1)
        //
class Solution {
    public int countBattleships(char[][] board) {
        if(board==null || board.length==0 || board[0].length==0) return 0;
        int rowL=board.length,colL=board[0].length;
        int count=0;
        for(int i=0;i<rowL;i++){
            for(int j=0;j<colL;j++){
                if(board[i][j]=='X'){
                    count++;
                    board[i][j]='.';
                    destroyShip(board,i,j);
                }
            }
        }
        return count;
    }
    
    private void destroyShip(char[][] board,int i,int j){
        for(int auxI=i+1;auxI<board.length;auxI++){
            if(board[auxI][j]=='X'){
                board[auxI][j]='.';   
            }else{
                break;
            }
        }
        
        for(int auxJ=j+1;auxJ<board[0].length;auxJ++){
            if(board[i][auxJ]=='X'){
                board[i][auxJ]='.';  
            }else{
                break;
            }
        }
    }
}


        //Genius solution from leetcode's ben65
        //Solves for this problem follow up, avoid changing values of matrix
        //I paste their explanation
        //Going over all cells, we can count only those that are the "first" cell of the battleship.
        //First cell will be defined as the most top-left cell. 
        //We can check for first cells by only counting cells that do not have an 'X' to the left and 
        //do not have an 'X' above them.
    public int countBattleships(char[][] board) {
        int m = board.length;
        if (m==0) return 0;
        int n = board[0].length;
        
        int count=0;
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == '.') continue;
                if (i > 0 && board[i-1][j] == 'X') continue;
                if (j > 0 && board[i][j-1] == 'X') continue;
                count++;
            }
        }
        
        return count;
    }