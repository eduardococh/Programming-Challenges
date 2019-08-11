        //My solution (after viewing explanation of "formula")
        //does sum in pairs, and for odd numbers has an if
        //This problems follows the catalan numbers sequence 1,2,5,14,42,... 
        //sequence that appears in many problems, good to remember it, the reasoning is
        //that using dynamic programming to save subproblems, explained below

        /*Great explanation by leetcode's lizhu5058   
        Hope it will help you to understand :
            
            n = 0;     null   
            
            count[0] = 1
            
            
            n = 1;      1       
            
            count[1] = 1 
            
            
            n = 2;    1__       			 __2     
                        \					/                 
                        count[1]	   	count[1]	
            
            count[2] = 1 + 1 = 2
            
            
            
            n = 3;    1__				      __2__	                   __3
                        \		            /       \			      /		
                    count[2]		  count[1]    count[1]		count[2]
            
            count[3] = 2 + 1 + 2  = 5
            
            
            
            n = 4;    1__  					__2__					   ___3___                  
                        \				 /        \					  /		  \			
                    count[3]		 count[1]    count[2]		  count[2]   count[1]
            
                        __4				
                    /
                count[3]   
            
            count[4] = 5 + 2 + 2 + 5 = 14     
            

        And  so on...
        */
        //Amazing runtime of 0ms better than 100% O(N)
        //Bad memory of 32.8mb, better than only 5% O(N) this measure seems weird
        //Good enough solution, maybe not the most elegant of them
class Solution {
    public int numTrees(int n) {
        int dp[]=new int[n+1];  
        dp[0]=1;//this should be 0 but we're using it for multiplication so 1 does not affect the result
        dp[1]=1;
        for(int i=2;i<=n;i++){
            int sum=0;
            for(int j=0;j<i/2;j++){
                sum+=dp[j]*dp[i-j-1]*2;
            }
            if(i%2==1){
                sum+=dp[i/2]*dp[i/2];                
            }
            dp[i]=sum;
        }
        return dp[n];
    }
}


        //a more elegant solution in writing, but maybe slower than mine?
        //since here the inner loop goes through every number, in my solution is goes through 
        //half the numbers because of the symmetry, but this code seems so much simpler
        //Same runtime and memory as mine
public int numTrees(int n) {
    int [] G = new int[n+1];
    G[0] = G[1] = 1;
    
    for(int i=2; i<=n; ++i) {
    	for(int j=1; j<=i; ++j) {
    		G[i] += G[j-1] * G[i-j];
    	}
    }

    return G[n];
}