        //My solution
        //Patchy, full of fixes, but works well
        //Good runtime of 4ms better than 87.33% O(K)
        //Amazing memory better than 100% O(num)
class Solution {
    public String removeKdigits(String num, int k) {
        if(k==0) return num;
        StringBuilder sb=new StringBuilder(num);
        while(sb.length()>0 && k>0){
            int min=sb.charAt(0);
            int index=1;
            boolean zeroes=false;
            while(index<sb.length() && sb.charAt(index)=='0'){
                sb.deleteCharAt(index);
                zeroes=true;
            }
            if(zeroes){
                k--;
                sb.deleteCharAt(0);
                continue;
            }
            while(index<sb.length() && sb.charAt(index)==min){
                index++;
            }
            if(index==sb.length()) index--;
            if(sb.charAt(index)<sb.charAt(0)){
                sb.deleteCharAt(0);
            }else{
                char currentMax=sb.charAt(index++);
                while(index<sb.length() && sb.charAt(index)>currentMax){
                    currentMax=sb.charAt(index++);
                }
                index--;
                if(index==-1) index++;
                sb.deleteCharAt(index);    
            }
            k--;
        }
        if(sb.length()==0) return "0";
        return sb.toString();
    }
}

        //Stack solution by leetcode
        //Same runtime and memory as my solution
class Solution {
  public String removeKdigits(String num, int k) {
    LinkedList<Character> stack = new LinkedList<Character>();
        
    for(char digit : num.toCharArray()) {
      while(stack.size() > 0 && k > 0 && stack.peekLast() > digit) {
        stack.removeLast();
        k -= 1;
      }
      stack.addLast(digit);
    }
        
    /* remove the remaining digits from the tail. */
    for(int i=0; i<k; ++i) {
      stack.removeLast();
    }
        
    // build the final string, while removing the leading zeros.
    StringBuilder ret = new StringBuilder();
    boolean leadingZero = true;
    for(char digit: stack) {
      if(leadingZero && digit == '0') continue;
      leadingZero = false;
      ret.append(digit);
    }
        
    /* return the final string  */
    if (ret.length() == 0) return "0";
    return ret.toString();
  }
}