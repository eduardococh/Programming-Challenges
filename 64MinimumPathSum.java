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