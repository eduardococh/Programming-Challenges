        //Average runtime of 5ms better than 54.35% 
        //Good memory of 37.3mb better than 96.08%
class Solution {
    public int longestValidParentheses(String s) {
        int res=0;
        boolean valids[]=new boolean[s.length()];
        Stack<Integer> stack=new Stack<Integer>();
        final int len=s.length();
        for(int i=0;i<len;i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }else{
                if(!stack.isEmpty()){
                    valids[i]=true;
                    valids[stack.pop()]=true;
                }
            }
        }
        int local=0;
        for(boolean b:valids){
            if(b){
                local++;
            }else{
                if(local>0){
                    if(local>res) res=local;
                    local=0;
                }
            }
        }
        if(local>0 && local>res) res=local;
        return res;
    }

}

        //DP solution
        //Amazing runtime of 1ms better than 100% O(N)
        //Good memory of 37.5 less than 88.24% O(N)
public class Solution {
    public int longestValidParentheses(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }
}

        //Constant space solution
        //Average runtime of 6ms better than 51.76% O(N)
        //Amazing memory of 36.5 mb better than 100%
        //Two passes, using left and right variables, very clever approach (but not the best runtime)
        //tradeoff of memory for runtime
public class Solution {

    public int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
}