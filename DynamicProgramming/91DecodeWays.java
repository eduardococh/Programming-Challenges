		//My brute force solution
        //Generate all combinations, if we start with 12045 we'll make our solution from
        //the sum of 2045 with 045, and so on
        //Terrible runtime of 1127ms better than only 5.01% O(2^N)
        //Terrible memory better than only 6% O(N)
class Solution {
    
    public int numDecodings(String s) {
        return generatePossibilities(s,0);
    }
    
    private int generatePossibilities(String s,int index){
        if(index>=s.length()) return 1;//if index is bigger than length
        if(s.charAt(index)=='0') return 0;
        if(index==s.length()-1) return 1;
        int sum=0;
        sum+=generatePossibilities(s,index+1);
        if(validDecode(s.charAt(index),s.charAt(index+1))){
            sum+=generatePossibilities(s,index+2);
        }
        return sum;
    }
    
    private boolean validDecode(char c1,char c2){
        int value=(c1-'0')*10+(c2-'0');
        if(value<=26) return true;
        return false;
    }
}    

        //My dp solution
        //Simple once you understand the brute force solution
        //Amazing runtime of 1ms better than 96.71% O(N)
        //Bad memory better than only 6% O(N)
class Solution {
    
    public int numDecodings(String s) {
        int dp[]=new int[s.length()];
        Arrays.fill(dp,-1);
        return generatePossibilities(s,0,dp);
    }
    
    private int generatePossibilities(String s,int index,int[] dp){
        if(index>=s.length()) return 1;//if index is bigger than length
        if(dp[index]!=-1) return dp[index];
        if(s.charAt(index)=='0') return 0;
        if(index==s.length()-1) return 1;
        int sum=0;
        sum+=generatePossibilities(s,index+1,dp);
        if(validDecode(s.charAt(index),s.charAt(index+1))){
            sum+=generatePossibilities(s,index+2,dp);
        }
        dp[index]=sum;
        return sum;
    }
    
    private boolean validDecode(char c1,char c2){
        int value=(c1-'0')*10+(c2-'0');
        if(value<=26) return true;
        return false;
    }
}    
    
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
