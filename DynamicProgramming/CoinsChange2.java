//My solution using 2D dynamic programming array
//Can be brought down to 1D since we only ask for the previous row
//Runtime of O(N*C)
//Memory of O(N*C)
class Solution {
    public int change(int n, int[] denoms) {
        if(n==0) return 1;
        if(denoms.length==0) return 0;
		int[][] dp=new int[n+1][denoms.length];
		for(int j=0;j<denoms.length;j++){
			dp[0][j]=0;
			for(int i=1;i<=n;i++){
				if(denoms[j]<=i) dp[i][j]+=dp[i-denoms[j]][j];
				if(j>0) dp[i][j]+=dp[i][j-1];
				if(i==denoms[j]) dp[i][j]++;
			}
		}
        return dp[n][denoms.length-1];
    }
}