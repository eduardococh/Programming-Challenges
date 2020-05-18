		//My solution, pretty easy
		//Sort the strings and find the one that's different, or if you dont
		//find it is the last one of t
		//bad runtime better than only 29% O(N log(N))
		//bad memory better than 1%? O(S+T)
class Solution {
    public char findTheDifference(String s, String t) {
        if(t.length()==0) return '?';
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        for(int i=0;i<s.length();i++){
            if(sArr[i]!=tArr[i]){
                return tArr[i];
            }
        }
        return tArr[t.length()-1];
    }
}


		//Standard solution that should have been used
		//Faster than sorting strings and simple
		//Average runtime of 2ms better than 44%
		//Great memory better than 99.04%
		//Takes a big supossition of a 128 ascii code, that could
		//Be different
class Solution {
    public char findTheDifference(String s, String t) {
        
        int[] chars = new int[128];
        for (int i = 0;i<s.length();i++)
            chars[s.charAt(i)]++;
        
        for (int j = 0;j<t.length();j++){
            chars[t.charAt(j)]--;
            if (chars[t.charAt(j)] == -1)
                return t.charAt(j);
        }
            
        return t.charAt(0);

    }
}




		//Bit manipulation solution, simple to understand but
		//not trivial to come up
		//0ms runtime better than 100% O(S)
		//Bad memory better than 10% O(1)?
class Solution {
    public char findTheDifference(String s, String t) {
        
        int ans = t.charAt(t.length()-1);
        for (int i = 0;i<s.length();i++){
            ans = ans^s.charAt(i);
            ans = ans^t.charAt(i);
        }

        return (char) ans;

    }
}