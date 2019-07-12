
		//My initial solution with binary search
		//Actually not sooo bad, but not great
		//Runtime of 6ms better than 29.70% O(N LOG (N))
		//Good memory of 42.4 mb better than 99.9% or 100% o(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0 || matrix[0].length==0) return false;
        if(target<matrix[0][0] || target>matrix[matrix.length-1][matrix[0].length-1]){
            return false;   
        }
        for(int i=0;i<matrix.length;i++){
            int left=0,right=matrix[0].length-1;
            while(left<=right){
                int middle=left+(right-left)/2;
                if(matrix[i][middle]==target){
                    return true;
                }
                if(matrix[i][middle]<target){
                    left=middle+1;
                }else{
                    right=middle-1;
                }
            }
        }
        return false;
    }
}


		//Leetcode's 5ms solution
		//Amazing logic and trivial could be said
		//Start in the last row first column, and start going down the rows until
		//your row is smaller than target (meaning target now is bigger so should be in this row)
		//then search every column in your row until you find the one, you could do a 'zig-zag' pattern
		//until you find it, because it asks for a > and < it insures that true is returned only when
		//the number is found (useful for negative numbers for example, my approach starting from 0 failed 
		//Because of this
		//Runtime of 5ms better than 100% o(M+N)
		//Memory of 43.8 better than 99.1% o(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // start our "pointer" in the bottom-left
        int row = matrix.length-1;
        int col = 0;

        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            } else { // found it
                return true;
            }
        }

        return false;
    }
}