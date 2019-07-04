		//My solution
		//Simple and direct
		//Good runtime better than 75.94% O(n+m)
		//Amazing memory better than 99.15% O(1)
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length()>magazine.length()){
            return false;
        }
        int letters[]=new int[26];
        for(int i=0;i<magazine.length();i++){
            letters[magazine.charAt(i)-97]++;
        }
        for(int i=0;i<ransomNote.length();i++){
            letters[ransomNote.charAt(i)-97]--;
            if(letters[ransomNote.charAt(i)-97]<0){
                return false;
            }
        }
        return true;
    }
}


		//Good simple improvement, use .toCharArray(), avoid multiple charAt's
		//Great runtime of 2ms better than 98.62%
		//Amazing memory better than 99.13% 
		//0ms solution is not so trivial so not going to cover it

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] list = new int[26];
        for(char c:magazine.toCharArray()){
            list[c-'a']++;
        }
        for(char c: ransomNote.toCharArray()){
            list[c-'a']--;
            if(list[c-'a']<0) return false;
        }
        return true;
    }
}