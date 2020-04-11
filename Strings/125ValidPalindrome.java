class Solution {
		//My solution, not good beating only 27% of solutions and
		//better runtime than only 7.28%
		//Took me 10min
		//O(n) runtime and 
    public boolean isPalindrome(String s) {
        String sMin=s.toLowerCase();
        String sClean=sMin.replaceAll("[^A-Za-z0-9]", "");
        final int length=sClean.length();
        for(int i=0;i<length/2;i++){
            if(sClean.charAt(i)!=sClean.charAt(length-i-1)){
                return false;
            }
        }
        return true;
    }
}

        //My second try at this problem
        //Good runtime of 2ms better than 97.48% O(N)
        //Bad memory better than only 97.48% O(1)
class Solution {
    public boolean isPalindrome(String s) {
        int start=0,end=s.length()-1;
        s=s.toLowerCase();
        while(start<end){
            while(start<end && !isValid(s.charAt(start))) {
                start++;
            }
            while(end>start && !isValid(s.charAt(end))){
                end--;
            }
            if(s.charAt(start)!=s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
    
    public boolean isValid(char c){
        if(c>='0' && c<='9') return true;
        if(c>='a' && c<='z') return true;
        return false;
    }
}

		//Good runtime 96 memory 55 
class Solution {
    public boolean isPalindrome(String s) {
        char[] c = s.toLowerCase().toCharArray();
        int i=0,j=c.length-1;
        while(i<j){
		//while is not alphanumeric
            while(i<j && (c[i]<'0' || c[i]>'z' || ('9'<c[i] && c[i]<'a')))
                i++;
            while(i<j && (c[j]<'0' || c[j]>'z' || ('9'<c[j] && c[j]<'a')))
                j--;
            
            if(c[i++] != c[j--])
                return false;
        }
        return true;
    }
}
