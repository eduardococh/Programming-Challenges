		//My solution
		//Amazing runtime of 1ms better than 100% o(n*m)
		//Great memory less than 95.29% o(m*n) or o(1)?
		//Good approach, simple, programmed in a few seconds, simple 
		//Many call it BFS, backtracking?
class Solution {
    public int numIslands(char[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    count++;
                    deleteIsland(i,j,grid);
                }
            }
        }
        return count;
    }
    
    public void deleteIsland(int i,int j, char[][] grid){
        grid[i][j]='2';
        if(i>=1 && grid[i-1][j]=='1'){
            deleteIsland(i-1,j,grid);
        }
        if(j>=1 && grid[i][j-1]=='1'){
            deleteIsland(i,j-1,grid);
        }
        if(i<=grid.length-2 && grid[i+1][j]=='1'){
            deleteIsland(i+1,j,grid);
        }
        if(j<=grid[0].length-2 && grid[i][j+1]=='1'){
            deleteIsland(i,j+1,grid);
        }
    }
}


		//Other valid solution, same approach as me buut simplifies desition making
public class Solution {

private int n;
private int m;

public int numIslands(char[][] grid) {
    int count = 0;
    n = grid.length;
    if (n == 0) return 0;
    m = grid[0].length;
    for (int i = 0; i < n; i++){
        for (int j = 0; j < m; j++)
            if (grid[i][j] == '1') {
                DFSMarking(grid, i, j);
                ++count;
            }
    }    
    return count;
}

private void DFSMarking(char[][] grid, int i, int j) {
    if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
    grid[i][j] = '0';
    DFSMarking(grid, i + 1, j);
    DFSMarking(grid, i - 1, j);
    DFSMarking(grid, i, j + 1);
    DFSMarking(grid, i, j - 1);
}
}