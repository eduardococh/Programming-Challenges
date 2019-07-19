		//My simple solution
		//Good runtime of 2ms better than 89.98% o(n*m)
		//Good memory better than 86.2% O(1)
		//A good approach.
class Solution {
    public int minPathSum(int[][] grid) {
        if(grid.length==0 || grid[0].length==0) return 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                grid[i][j]=grid[i][j]+getBigger(i,j,grid);
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
    
    public int getBigger(int i,int j,int[][] grid){
        if(i>0 && j>0){
            return Math.min(grid[i][j-1],grid[i-1][j]);
        }else if(i==0 && j==0){
            return 0;
        }else if(i==0){
            return grid[i][j-1];
        }else{
            return grid[i-1][j];
        }
    }
}


		//Dynamic programming solution
		//Same complexity as my solution, but faster
		//Runtime of 2ms better than 89.98% O(M*N)
		//Bad memory better than 31.24%
		//Interesting solution, pure dp i think
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i-1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[0] += grid[i][0];
                } else {
                    dp[j] = Math.min(dp[j-1], dp[j]) + grid[i][j];
                }
            }
        }
        return dp[n-1];
    }
}