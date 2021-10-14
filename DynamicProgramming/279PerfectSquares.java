        //My solution, dynamic programming approach
        //Followed same principle as the "Coin Change" problem, so you'll see coin word here
        //Not the most elegant approach, I would suggest using the one after this
        //Bad runtime at 32ms better than only 35.04% ¿O(N*C)? where N is the number and 
        //C is the number of coins
        //Bad memory better than only 18.05%
        //
        //So there's a Static dynamic solution, a mathematical solution based
        //on lagrange's four square theorem and a BFS solution, according to leetcode's zhukov.
        //The math and static dp approaches are something that would not be expected in an
        //interview I think, the dynamic programming would be good enough so I'll stick to it
class Solution {
    public int numSquares(int n) {
        if(n==1) return 1;
        List<Integer> perfectSquares=new ArrayList<Integer>();
        int i=1;
        while(i*i<=n){
            perfectSquares.add(i*i);
            i++;
        }
        int numOfPS=perfectSquares.size();
        int dp[]=new int[n+1];
        for(i=1;i<=n;i++){
            int psIndex=0;
            int currentCoin=perfectSquares.get(0);
            int smallestCoinN=Integer.MAX_VALUE;
            while(i-currentCoin>=0 && psIndex<numOfPS){
                if(dp[i-currentCoin]+1<smallestCoinN){
                    dp[i]=dp[i-currentCoin]+1;
                    smallestCoinN=dp[i];
                }
                psIndex++;
                if(psIndex==numOfPS) break;
                currentCoin=perfectSquares.get(psIndex);
            }
        }
        return dp[n];
    }
}


        //A more elegant dynamic programming solution from leetcode's sample 20ms
        //Good runtime at 20ms better than 76.13%
        //Same memory as my approach
        //You loop from 1 through N and in an inner loop j generate the squares
        //using j*j, here you choose the smallest dp[i-j*j] (all the posible "coins")
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);             
            }
        }
        return dp[n];
    }
}

//Second attempt, went for coin change approach as soon as I saw problem
class Solution {
    public int numSquares(int n) {
        int perfectSquares[]=getPerfectSquares(n);
        int dp[]=new int[n+1];
        for(int i=1;i<=n;i++){
            int currentSquare=0;
            int smallerSoFar=Integer.MAX_VALUE;
            while(currentSquare<perfectSquares.length && perfectSquares[currentSquare]<=i){
                if(dp[i-perfectSquares[currentSquare]]+1<smallerSoFar){
                    smallerSoFar=dp[i-perfectSquares[currentSquare]]+1;
                }
                currentSquare++;
            }
            dp[i]=smallerSoFar;
        }
        return dp[n];
    }
    
    public int[] getPerfectSquares(int limit){
        ArrayList<Integer> squares=new ArrayList<Integer>();
        int i=1;
        while(i*i<=limit){
            squares.add(i*i);
            i++;
        }
        int perfectSquares[]=new int[squares.size()];
        for(int j=0;j<squares.size();j++){
            perfectSquares[j]=squares.get(j);
        }
        return perfectSquares;
    }
}