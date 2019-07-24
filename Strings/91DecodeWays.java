		//My solution
		//Took me long time because I started programming before really 
		//understanding problem
		//Key to solve it is the preprocessing of the string, the 0's are a special
		//case, when you find a zero, remove the number before it, leave the zero
		//so later we can do the main processing for the problem and not consider
		//those 0's numbers
		//Bad runtime at 253ms faster than 5.57% O(2^S) TERRIBLE
		//Amazing memory at 34.7mb better than 100%
class Solution {    
    
    public int numDecodings(String s) {
        if(s.length()==0 || s.charAt(0)=='0') return 0;i
        StringBuilder processedSt=new StringBuilder(s);
        List<Integer> beforeZerosToBeDeleted=new ArrayList<Integer>();
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)<=48){
                if(s.charAt(i-1)<=48  || s.charAt(i-1)>=51){
                    return 0;
                }else{
                    beforeZerosToBeDeleted.add(i);
                }
            }
        }
        int shorter=0;
        for(Integer index:beforeZerosToBeDeleted){
            processedSt.deleteCharAt(index-shorter-1);
            shorter++;
        }
        return checkCombinations(processedSt,1,0);
    }
    
    public int checkCombinations(StringBuilder s, int result,int start/*,boolean zero*/){
        for(int i=start;i<s.length();i++){
            if(s.charAt(i)==48 || (i+1<s.length() && s.charAt(i+1)==48)){
                continue;
            }
            if(i+1<s.length() && s.charAt(i)<51 && (s.charAt(i)==49 || (s.charAt(i)==50 && s.charAt(i+1)<=54))){
                result++;
                result=checkCombinations(s,result,i+2);
            }
        }
        return result;
    }
}

		//Dynamic programming solution from leetcode yfcheng
		//The way it works is simple, we start the first two positions and then start doing the calculus
		//
public int numDecodings(String s) {
    if(s == null || s.length() == 0) {
      return 0;
    }
    int n = s.length();
    int[] dp = new int[n];

    dp[0] = s.charAt(0) != '0' ? 1 : 0;

    for(int i = 1; i < n; i++) {
      int first = Integer.valueOf(s.substring(i, i+1));
      int second = Integer.valueOf(s.substring(i-1, i+1));
      if(first >= 1 && first <= 9) {
        dp[i] += dp[i-1];
      }
      if(second >= 10 && second <= 26) {
	if(i>=2){
          dp[i] += dp[i-2];
	}else{
          dp[i] += dp[i-2];
        }
      }
    }

    return dp[n-1];
  }


class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0)        
            return 0;

        
        char[] sArr = s.toCharArray();
        int cur  = (sArr[sArr.length - 1] == '0') ? 0 : 1;
        int next = 1;
        int tmp = 0;
        for (int i = sArr.length - 2; i >= 0; i--){
            if (sArr[i] == '0'){
                next = cur;
                cur = 0;
            }else{
                tmp = cur;
                if ((sArr[i] - '0') * 10 + sArr[i + 1] - '0' < 27){
                    cur += next;
                }
                next = tmp;
            }
        }

        return cur;
    }
}