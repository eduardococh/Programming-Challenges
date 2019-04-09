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

class Solution {
		//Faster solution, beating 96.58 in runtime but only 28.30 in memory
    public boolean isPalindrome(String s) {
        char[] strArr = s.toCharArray();
        int i = 0, j = strArr.length -1;
        while(i < j){
            if(!Character.isLetterOrDigit(strArr[i]))
                i ++;
            else if(!Character.isLetterOrDigit(strArr[j]))
                j --;
            else if(Character.toLowerCase(strArr[i]) == Character.toLowerCase(strArr[j])){
                i ++;
                j --;
            }
            else
                return false;
        }
        return true;
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
