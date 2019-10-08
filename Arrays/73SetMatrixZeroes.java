class Solution {
		//My approach, using dummy value
		//Brute force with o(1) space
		//Time intensive at O((M * N) * (M + N)), and might be wrong if dummy is not well choosen
    public void setZeroes(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    for(int k=0;k<matrix.length;k++){
                        if(matrix[k][j]!=0){
                            matrix[k][j]=-3590905;    
                        }
                    }
                    for(int k=0;k<matrix[0].length;k++){
                        if(matrix[i][k]!=0){
                            matrix[i][k]=-3590905;    
                        }
                    }
                }
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==-3590905){
                    matrix[i][j]=0;
                }
            }
        }
    }
}

class Solution {
		//Leetcode solution using 0 extra space
		//Using sets for columns and rows with 0's
		//Space complexity of O(M+N) bc of the two sets
		//Time complexity of O(M * N)
  public void setZeroes(int[][] matrix) {
    int MODIFIED = -1000000;
    int R = matrix.length;
    int C = matrix[0].length;

    for (int r = 0; r < R; r++) {
      for (int c = 0; c < C; c++) {
        if (matrix[r][c] == 0) {
          // We modify the corresponding rows and column elements in place.
          // Note, we only change the non zeroes to MODIFIED
          for (int k = 0; k < C; k++) {
            if (matrix[r][k] != 0) {
              matrix[r][k] = MODIFIED;
            }
          }
          for (int k = 0; k < R; k++) {
            if (matrix[k][c] != 0) {
              matrix[k][c] = MODIFIED;
            }
          }
        }
      }
    }

    for (int r = 0; r < R; r++) {
      for (int c = 0; c < C; c++) {
        // Make a second pass and change all MODIFIED elements to 0 """
        if (matrix[r][c] == MODIFIED) {
          matrix[r][c] = 0;
        }
      }
    }
  }
}


class Solution {
		//Optimal solution by leetcode
		//We use the first index of every row and column for 
		//Saving is a row or column must be zeroed
		//Time complexity of O(M * N)
		//Space complexity of O(1)

  public void setZeroes(int[][] matrix) {
    Boolean isCol = false;
    int R = matrix.length;
    int C = matrix[0].length;

    for (int i = 0; i < R; i++) {

         // Since first cell for both first row and first column is the same i.e. matrix[0][0]
         // We can use an additional variable for either the first row/column.
         // For this solution we are using an additional variable for the first column
         // and using matrix[0][0] for the first row.
         if (matrix[i][0] == 0) {
           isCol = true;
         }
      
         for (int j = 1; j < C; j++) {
           // If an element is zero, we set the first element of the corresponding row and column to 0
           if (matrix[i][j] == 0) {
             matrix[0][j] = 0;
             matrix[i][0] = 0;
           }
         }
    }

    // Iterate over the array once again and using the first row and first column, update the elements.
    for (int i = 1; i < R; i++) {
      for (int j = 1; j < C; j++) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      }
    }

    // See if the first row needs to be set to zero as well
    if (matrix[0][0] == 0) {
      for (int j = 0; j < C; j++) {
        matrix[0][j] = 0;
      }
    }

    // See if the first column needs to be set to zero as well
    if (isCol) {
      for (int i = 0; i < R; i++) {
        matrix[i][0] = 0;
      }
    }
  }
}