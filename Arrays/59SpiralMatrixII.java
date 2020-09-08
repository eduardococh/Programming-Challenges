        //My solution
        //This problem is almost the same as the usual spiral matrix
        //Amazing runtime 0ms better than 100% O(M*N)
        //Good memory better than 82% O(1)
class Solution 
    public int[][] generateMatrix(int n) {
        int[][] res=new int[n][n];
        int top=0,bottom=n-1,left=0,right=n-1,cont=1;
        while(top<=bottom && left<=right){
            
            for(int j=left;j<=right;j++){
                res[top][j]=cont++;
            }
            top++;
            
            for(int i=top;i<=bottom;i++){
                res[i][right]=cont++;
            }
            right--;
            
            if(top<=bottom && left<=right){
                for(int j=right;j>=left;j--){
                    res[bottom][j]=cont++;
                }
                bottom--;

                for(int i=bottom;i>=top;i--){
                    res[i][left]=cont++;
                }
                left++;
            }
        }
        return res;
    }
}