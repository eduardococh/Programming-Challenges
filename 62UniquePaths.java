		//My solution
		//Great runtime at 0ms better than 100% o(m*n)
		//Bad memory at  32.4mb better than only 34.90% o(m*n)
		//Fast and direct solution, in the memory department is not very safe measure
		//Since I run another solution from leetcode's 99% memory solutions and it was same as me
class Solution {
    public int uniquePaths(int m, int n) {
        if(m==0 || n==0) return 0;
        int[][] mat=new int[m][n];
        for(int i=0;i<m;i++){
            mat[i][0]=1;
        }
        for(int i=0;i<n;i++){
            mat[0][i]=1;
        }
        return generatePaths(mat);
    }
    
    public int generatePaths(int[][] mat){
        for(int i=1;i<mat.length;i++){
            for(int j=1;j<mat[0].length;j++){
                mat[i][j]=mat[i-1][j]+mat[i][j-1];
            }
        }
        return mat[mat.length-1][mat[0].length-1];
    }
}

		//From leetcode's sample 99% memory
		//Same as me, just adds an if into cycle to assign 1's
		//So for very big cases mine would be faster
		//And memory wise when i sent it memory was bad as mine
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] mat = new int[m][n];
        for (int y = 0; y < n; y++) 
            for (int x = 0; x < m; x++) 
                mat[x][y] = (x == 0 || y == 0) ? 1 : (mat[x-1][y] + mat[x][y-1]);             
	return mat[m-1][n-1];
    }
}
