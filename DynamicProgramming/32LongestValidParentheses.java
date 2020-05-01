        //My solution using stack and array
        //Average runtime of 5ms better than 54.35% 
        //Good memory of 37.3mb better than 96.08%
        //A good solution, simple to implement and understand 
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

        //My dp solution
        //Average runtime of 65.73% O(N)
        //Bad memory better than only 5% O(N)
        //Recursively solve for positions, from inward to outward
class Solution {
    
    int dp[];
    int len;
    
    public int longestValidParentheses(String s) {
        dp=new int[s.length()];
        len=s.length();
        for(int i=0;i<len;i++){
            validateSubstrings(s,dp,i);   
        }
        int res=0,soFar=0;
        for(int status:dp){
            if(status==1){
                soFar++;
                if(soFar>res) res=soFar;
            }else{
                soFar=0;
            }
        }
        return res;
    }
    
    private int validateSubstrings(String s,int dp[],int index){
        if(index>=len) return len+1;
        if(dp[index]!=0) return len+1;//we already solved this position
        if(s.charAt(index)==')'){
            dp[index]=2;//2 means that parenthesis is not valid
            return len+1;
        }//else I'm (
        int searchIndex=index+1;
        while(searchIndex<len){
            if(s.charAt(searchIndex)==')'){
                dp[index]=1;
                dp[searchIndex]=1;
                return searchIndex+1;
            }else{//keep searching
                searchIndex=validateSubstrings(s,dp,searchIndex);
            }
        }
        dp[index]=2;
        return len+1;
    }
}

        //DP solution
        //Amazing runtime of 1ms better than 100% O(N)
        //Good memory of 37.5 less than 88.24% O(N)
        //When you find a closing parentheses check if there's an inmediate opening parentheses
        //if yes add two to your position, else check for the next element in dp 
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