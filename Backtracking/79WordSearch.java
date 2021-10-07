		//My solution, all good backtracking
		//Thought was going to be very brute force like, but good runtime
		//Approach is going through the array one by one and for every position check
		//Amazing runtime at 3ms better than 99.93 % O(N*M*K) where M and N are width/height
		//and k is word length, ???
		//Amazing memory better than 99.32% O(1)
		//Good problem	
class Solution {
    public boolean exist(char[][] board, String word) {
        if(word.length()==0) return false;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(verifyMatrix(board,word,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean verifyMatrix(char[][] board, String word, int i, int j, int index){
        if(i<0 || i>=board.length || j<0 || j>=board[0].length){
            return false;
        }
        if(word.charAt(index)==board[i][j]){
            if(index+1==word.length()) return true;
            char aux=board[i][j];
            board[i][j]='0';
            if(verifyMatrix(board,word,i+1,j,index+1)) return true;
            if(verifyMatrix(board,word,i-1,j,index+1)) return true;
            if(verifyMatrix(board,word,i,j+1,index+1)) return true;
            if(verifyMatrix(board,word,i,j-1,index+1)) return true;
            board[i][j]=aux;
        }
        return false;
    }
}

//Same approach as above, some time later,
//But this got a terrible runtime of 87ms, despite the same time complexity
//Not sure why
class Solution {
    public boolean exist(char[][] board, String word) {
        for(int row=0;row<board.length;row++){
            for(int column=0;column<board[0].length;column++){
                if(exist(board,word,row,column,0)) return true;
            }
        }
        return false;
    }
    
    public boolean exist(char[][] board, String word,int row,int column,int index){
        if(row<0 || column<0 || row>=board.length || column>=board[0].length) return false;
        if(board[row][column]=='0') return false;//already visited
        if(board[row][column]!=word.charAt(index)) return false;//not a match
        if(index==word.length()-1) return true;
        //current position is valid
        char aux=board[row][column];
        board[row][column]='0';
        if(exist(board,word,row+1,column,index+1)) return true;
        if(exist(board,word,row-1,column,index+1)) return true;
        if(exist(board,word,row,column+1,index+1)) return true;
        if(exist(board,word,row,column-1,index+1)) return true;
        board[row][column]=aux;
        return false;
    }
}

		//Best solution with 2ms, same approach as me
		//Setting board[x][x]^=256 is an XOR with 256, char get at most 255 so this is 
		//equal to setting board[x][y] to #
		//trycount is for a very specific testcase apparently
class Solution {
    public boolean exist(char[][] board, String word) {
        int[][] tryCount = new int[board.length][board[0].length];
        char[] w = word.toCharArray();
        for (int y=0; y<board.length; y++) {
            for (int x=0; x<board[y].length; x++) {
                if (exist(board, y, x, w, 0,tryCount)) return true;
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int y, int x, char[] word, int i,int[][] tryCount) {
        if (i == word.length) return true;

        if (y<0 || x<0 || y == board.length || x == board[y].length) return false;

        if (board[y][x] != word[i] || tryCount[y][x]>121) return false;

        tryCount[y][x]++;
        board[y][x] ^= 256;
        boolean exist = exist(board, y, x+1, word, i+1,tryCount)
            || exist(board, y, x-1, word, i+1,tryCount)
            || exist(board, y+1, x, word, i+1,tryCount)
            || exist(board, y-1, x, word, i+1,tryCount);
        board[y][x] ^= 256;
        return exist;
    }
}