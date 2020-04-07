		//My recursive and time limit exceded solution
		//BAD runtime at O(S^N)
		//Normal memory at O(N) (stack is at most N)
class Solution {
    public int coinChange(int[] coins, int amount){
        Arrays.sort(coins);
        int nCoins[]=new int[coins.length];
        return generateChanges(coins,nCoins,amount,0,Integer.MAX_VALUE);
    }
    
    public int generateChanges(int[] coins,int[] nCoins, int amount, int currentAmount, int currentMin){
        if(currentAmount==amount){
            int result=0;
            for(int i=0;i<nCoins.length;i++){
                result+=nCoins[i];
            }
            if(result<currentMin){
                return result;       
            }
        }
        if(currentAmount>amount){
            return -1;
        }
        for(int i=coins.length-1;i>=0;i--){
            try {
                Math.addExact(currentAmount, coins[i]);
                currentAmount+=coins[i];
            } catch (ArithmeticException e) {
                continue;
            }
            nCoins[i]++;
            int result=generateChanges(coins,nCoins,amount,currentAmount,currentMin);
            nCoins[i]--;
            currentAmount-=coins[i];
        }
        if(currentMin!=Integer.MAX_VALUE){
            return currentMin;
        }else{
            return -1;
        }
    }
}

		//Top down dynamic programming solution by leetcode
		//Bad runtime at 27ms O(S*N) where S is the amount (we will do the process for i->n times) multiplied 
		//by N that is coin values, since for every S you'll process N coins
		//and good memory better than 99.94% O(S) where we save every S 
		//Interesting approach but bottom up is better
		//So is a recursive method, variable rem can be understood as remaining
		//So every recursion will decrease remaining in a coin value, if the result
		//from that is bigger than -1 and smaller than min then we set min to that value
		//we do this for every coin in this recursion and then ask if min is different than integer
		//max val (which means that at least 1 combination is valid) and save it to count array
		//then return this count array value
public class Solution {

    public int coinChange(int[] coins, int amount) {        
        if (amount < 1) return 0;
        return coinChange(coins, amount, new int[amount]);
    }

    private int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) return -1;
        if (rem == 0) return 0;
        if (count[rem - 1] != 0) return count[rem - 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min)
                min = 1 + res;
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }
}



		//Bottom up solution by leetcode
		//In theory same runtime as top bottom but in submission is takes 15ms, almost half 
		//Same memory at O(S) better than 99.94
		//So for every amount posible from 1 to N we fill an array with amount+1, and calculate the result
		//asking if the value of the coin in j is equal or smaller than i, if true we get the minimum

		//Easy to understand with example i think
		//For amount=11 and coins = [5,11]
		//0  = 0		
		//1  = 12
		//2  = 1
		//3  = 12
		//4  = 2
		//5  = 1
		//6  = 3
		//7  = 2
		//8  = 4
		//9  = 3
		//10 = 2
		//11 = 4
		
		//very clever solution actually
public class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;             
        int[] dp = new int[amount + 1];  
        Arrays.fill(dp, max);  
        dp[0] = 0;   
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}


		//From leetcode's sample 5ms
		//We do optimize by inverting cycles, calculating dp[i] for every coint from their value to amount
		//A little counterintuitive i think, but it works wonders
		//Doing this we avoid calculation for imposible values (like if the coin is 10 dont calculate up to 9)
		// With runtime of 5ms, better than 98.86%
		//Same memory as all others
		//Interesting using arrays.fill is took an extra ms to run, which i didnt expected

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0) return 0;
        int[] dp = new int[amount+1];
        dp[0] = 0;
        
        for(int i = 1; i <= amount; i++){
            dp[i] = amount + 1;
        }
        
        for(int coin : coins){
            for(int i = coin; i <= amount; i++){
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        
        if(dp[amount] >= amount + 1)
            return -1;
        else 
            return dp[amount];
    }
}