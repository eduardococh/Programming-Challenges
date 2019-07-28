		//My solution
		//Simple approach
		//Good runtime at 7ms faster than 75.53% O(M*N)
		//Amazing memory better than 99.30% O(1)
class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    if(i==0 || grid[i-1][j]==0){
                        perimeter++;
                    }
                    if(j==0 || grid[i][j-1]==0){
                        perimeter++;
                    }
                    if(i==grid.length-1 || grid[i+1][j]==0){
                        perimeter++;
                    }
                    if(j==grid[0].length-1 || grid[i][j+1]==0){
                        perimeter++;
                    }
                }
            }
        }
        return perimeter;
    }
}

		//6ms solution from leetcode's samples
		//Small improvement (when I ran it also took 7ms)
		//The improvement is adding 4 and then only asking two questions, 
		//unlike mine that does 4 questions
		//Should be better than mine
		//Runtime of 6ms (7 in my run) O(M*N)
		//Same memory as me
class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    perimeter += 4;
                    if (j < grid[0].length - 1 && grid[i][j+1] == 1) {
                        perimeter -= 2;
                    }
                    if (i < grid.length - 1 && grid[i+1][j] == 1) {
                        perimeter -= 2;
                    }
                }
            }  
        }
        return perimeter;
    }
}