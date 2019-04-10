class Solution {
		//Took me loooong to do because i didnt understand well the input format and how it translated to shudoku
		//Not so bad solution, 3ms better than 95% and 44.3mb less than 71.48%
		//O(n2)
		//o(n) 
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){//Horizontal
            Set<Character> numbers=new HashSet<Character>();
            for(int j=0;j<9;j++){
                if(board[i][j]!= '.' && !numbers.add(board[i][j])){
                    return false;    
                }
            }
        }
        for(int i=0;i<9;i++){//Vertical
            Set<Character> numbers=new HashSet<Character>();
            for(int j=0;j<9;j++){
                if(board[j][i]!= '.' && !numbers.add(board[j][i])){
                    return false;    
                }
            }
        }    
        for(int i=0;i<9;i+=3){//Squares
            for(int j=0;j<9;j+=3){
                Set<Character> numbers=new HashSet<Character>();
                for(int k=0;k<3;k++){
                    for(int l=0;l<3;l++){
                        //System.out.println("Out in square i "+i+" j "+j+" k "+k+" l "+l);
                        if(board[(i+k)][(j+l)]!= '.' && !numbers.add(board[(i+k)][(j+l)])){
                            System.out.println("Out in square "+board[j][i]+" "+j+" "+i);
                            return false;    
                        }
                    }
                }
            }
        }
        return true;
    }
}

	//From stefanpochmann, worse time (4ms,92.12%) and memory (45.2MB 69.49%) but very interesting logic
public boolean isValidSudoku(char[][] board) {
    Set seen = new HashSet();
    for (int i=0; i<9; ++i) {
        for (int j=0; j<9; ++j) {
            char number = board[i][j];
            if (number != '.')
                if (!seen.add(number + " in row " + i) ||
                    !seen.add(number + " in column " + j) ||
                    !seen.add(number + " in block " + i/3 + "-" + j/3))
                    return false;
        }
    }
    return true;
}


//My solution for the wrong array format where every array is a square
        /*
        System.out.println("Out in TEST "+board[3][4]);
        Set<Character> numbers=new HashSet<Character>();
        for(int i=0;i<9;i+=3){
            for(int j=0;j<9;j++){
                if(j%3==0){
                    numbers.clear();
                }
                for(int k=0;k<3;k++){
                    if(board[i+k][j]!= '.' && !numbers.add(board[i+k][j])){
                        System.out.println("Out in horizontal "+board[i+k][j]+" "+i+k+" "+j);
                        return false;    
                    }   
                }
            }
        }
        for(int i=0;i<3;i++){
            
            for(int j=0;j<3;j++){
                numbers.clear();
                for(int k=0;k<3;k++){
                    if(board[i][j+k*3]!= '.' && !numbers.add(board[i][j+k*3])){
                        System.out.println("Out in vertical 1 "+board[i][j+k*3]+" "+i+" "+j+k*3);
                        return false;    
                    }
                    if(board[i+3][j+k*3]!= '.' && !numbers.add(board[i+3][j+k*3])){
                        System.out.println("Out in vertical 2 "+board[i+3][j+k*3]+" "+(i+3)+" "+(j+k*3));
                        return false;    
                    }   
                    if(board[i+6][j+k*3]!= '.' && !numbers.add(board[i+6][j+k*3])){
                        System.out.println("Out in vertical 3 "+board[i+6][j+k*3]+" "+(i+6)+" "+(j+k*3));
                        return false;    
                    }   
                }
            }
            
        }*/