        //My solution
        //Brute force, after long time spent on a better solution
        //i sent this one and it worked great
        //Amazing runtime of 3ms better than 99.52% O((M*N)^2)
        //Amazing memory of 40.7mb better than 100%
        //
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0){
            return 0;
        }
        int max=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='1'){
                    
                    max=solvePosition(max,matrix,i,j);
            
                    /*for(int k=0;k<matrix.length;k++){
                        for(int l=0;l<matrix[0].length;l++){
                            System.out.print(matrix[k][l]);
                        }
                        System.out.println();
                    }*/
                }
            }
        }
        return max*max;
    }
    
    private int solvePosition(int max,char[][] matrix,int i,int j){
        int currentMax=1;
        boolean addLayer=true;
        while(addLayer){
            //Are we in bounds?
            if(i+currentMax>=matrix.length || j+currentMax>=matrix[0].length) break;
            
            for(int k=0;k<=currentMax;k++){
                //vertical check
                if(matrix[i+currentMax][j+k]=='0'){
                    addLayer=false;
                    /*for(int l=i+currentMax;l>=i;l--){
                        matrix[l][j+k]='0';
                    }*/
                }
                
                //horizontal check
                if(matrix[i+k][j+currentMax]=='0'){
                    addLayer=false;
                    /*for(int l=j+currentMax;l>=j;l--){
                        matrix[i+k][l]='0';
                    }*/
                }
            }
            if(addLayer){
                currentMax++;
            }
        }
        if(currentMax>max){
            return currentMax;
        }else{
            return max;    
        }
    }
}


        //Dynamic programming approach from leetcode
        //Amazing logic, brilliant
        //To my surprise runs slower than my brute force, ran my brute force twice with 3ms
        //and both dp gave me 4ms, so, weird
        //So here we have a dp array that saves the maximum length of their square
        //Amazing runtime 4ms better than 95.34% O(M*N)
        //Amazing memory better than 100% O(M*N)
public class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[][] dp = new int[rows + 1][cols + 1];
        int maxsqlen = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
                }
            }
        }
        return maxsqlen * maxsqlen;
    }
}
        //Optimized dp where we only use N memory space from leetcode's
        //Initially the dp array contains all 0's. 
        //As we scan the elements of the original matrix across a row,
        // we keep on updating the dp array as per the equation d
        //p[j]=min(dp[j-1],dp[j],prev)dp[j]=min(dp[j−1],dp[j],prev),
        // where prev refers to the old dp[j-1]dp[j−1]. For every row, 
        //we repeat the same process and update in the same dp array.
        //Again it is surprising that my brute force ran faster but it is that way
        //Runtime same as first dp
        //Memory of 39.9mb (better of all 3 solutions) 
public class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[] dp = new int[cols + 1];
        int maxsqlen = 0, prev = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }
        return maxsqlen * maxsqlen;
    }
}