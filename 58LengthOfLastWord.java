		//My first approach with string tokenizer, simple and faster than 100%
		//but seems that strTokenizer is no longer recommended (better to use string split)
		//but it is twice as fast as string split so ? Scanner also an option
		//Great runtime at 0ms better than 100% O(N)
		//But memory intensive, only better than 19%
import java.util.StringTokenizer; 
class Solution {
    public int lengthOfLastWord(String s) {
        StringTokenizer token=new StringTokenizer(s);
        String currentToken="";
        while(token.hasMoreTokens()){
            currentToken=token.nextToken();
        }
        return currentToken.length();
    }
}

		//My second approach, thought would be more optimal but its worse,
		//more thinking came into it,
		//bad runtime at 4ms, better than only 13%
		//Bad memory, better than only 18%
class Solution {
    public int lengthOfLastWord(String s) {
        StringTokenizer token=new StringTokenizer(s);
        String currentToken="";
        int startOfStr=0;
        int endOfStr=0;
        for(int i=0;i<s.length();i++){
            if(i>0 && s.charAt(i-1)==' ' && s.charAt(i)!=' '){
                startOfStr=i;
            }
            if((i==s.length()-1 && s.charAt(i)!=' ') ||
               (i<s.length()-1 && s.charAt(i)!=' ' && s.charAt(i+1)==' ')){
                endOfStr=i+1;
            }
        }
        return endOfStr-startOfStr;
    }
}


		//More approaches with better memory appear in leetcode samples
		//but tried some and didnt get good memory results (this measure in leetcode is tricky)
		//Worth reviewing split approach

class Solution {
    public int lengthOfLastWord(String s) {
        String[] split = s.split(" ");
        if(split.length==0) return 0;
        else{
        	return split[split.length-1].length();
        }
    }
}	
