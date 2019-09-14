        //Leetcode's article solution
        //Bad rating at 2.02 start
        //Average runtime at 29ms faster than 58.50% O(N)
        //Amazing memory better than 100% O(1)
        //Average simple dynamic programming solution
        //(~hops & 1) returns 1 for pair numbers (0,2,6,...) and 0 for none numbers
        //that's why hops%2 does not work (it does the inverse, 0 for pairs and 1 for nones)
        //So it uses only 2 slots of memory, it saves n-1 result in either 0 or 1 and current result in 0
class Solution {
    public int knightDialer(int N) {
        int MOD = 1_000_000_007;
        int[][] moves = new int[][]{
            {4,6},{6,8},{7,9},{4,8},{3,9,0},
            {},{1,7,0},{2,6},{1,3},{2,4}};

        int[][] dp = new int[2][10];
        Arrays.fill(dp[0], 1);
        for (int hops = 0; hops < N-1; ++hops) {
            Arrays.fill(dp[~hops & 1], 0);
            for (int node = 0; node < 10; ++node)
                for (int nei: moves[node]) {
                    dp[~hops & 1][nei] += dp[hops & 1][node];
                    dp[~hops & 1][nei] %= MOD;
                }
        }

        long ans = 0;
        for (int x: dp[~N & 1])
            ans += x;
        return (int) (ans % MOD);
    }
}


        //DP solution from leetcode's 0ms sample
        //Fast, there's a faster 0ms implementation but is not so trivial
        //This takes a lot of lines, but it is clear to understand
        //It takes "considerably" more memory than first approach, since here dp has 5001 spaces
        //but it is nothing big, since when submitted memory is still better than 100%
        //Amazing runtime 1ms better than 99.88% O(N)
        //Amazing memory better than 100% O(N) (here n is limited to 5000 so it's not big deal, otherwise
        //an approach like in the first solution with ~num & 1 would've been better)
class Solution {
    private static long[][] dp = new long[5001][];
    static final int MOD = 1000000000 + 7;

    //
    static {
        long[] firstJump = new long[10];
        Arrays.fill(firstJump, 1);
        dp[1] = firstJump;
    }


    public int knightDialer(int N) {
        long[] possibles = computeFor(N);
        int result = 0;
        for (long possible : possibles) {
            result += possible;
            result %= MOD;
        }
        return result;
    }


    private long[] computeFor(int N) {
        if (dp[N] != null) {
            return dp[N];
        } else if (dp[N - 1] == null) {
            computeFor(N - 1);
        }
        computeN(N);
        return dp[N];
    }

    private void computeN(int N) {
        long[] previous = dp[N - 1];
        long[] next = new long[10];
        next[0] = (previous[5] + previous[7]) % MOD;
        next[1] = (previous[6] + previous[8]) % MOD;
        next[2] = (previous[3] + previous[7]) % MOD;
        next[3] = (previous[2] + previous[8] + previous[9]) % MOD;
        next[5] = (previous[0] + previous[6] + previous[9]) % MOD;
        next[6] = (previous[1] + previous[5]) % MOD;
        next[7] = (previous[0] + previous[2]) % MOD;
        next[8] = (previous[1] + previous[3]) % MOD;
        next[9] = (previous[3] + previous[5]) % MOD;
        dp[N] = next;
    }
}