        //My solution using sliding window
        //Simple and fast, all the best solutions use this approach
        //Good runtime of 4ms better than 78.30% O(N) (if we consider the array check to be constant time)
        //Bad memory better than only 7.69% O(1)
        //Similar to 438FindAllAnagramsInAString
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        final int len1=s1.length(),len2=s2.length();
        if(len1>len2) return false;
        char small[]=new char[26];
        char big[]=new char[26];
        for(int i=0;i<len1;i++){
            small[s1.charAt(i)-'a']++;
            big[s2.charAt(i)-'a']++;
        }
        if(Arrays.equals(small,big)) return true;
        for(int i=len1;i<len2;i++){
            big[s2.charAt(i)-'a']++;
            big[s2.charAt(i-len1)-'a']--;
            if(Arrays.equals(small,big)) return true; 
        }
        return false;
    } 
}

        //Leetcode's optimized solution (something I tried to do in problem 438)
public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }
        int count = 0;
        for (int i = 0; i < 26; i++)
            if (s1map[i] == s2map[i])
                count++;
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            int r = s2.charAt(i + s1.length()) - 'a', l = s2.charAt(i) - 'a';
            if (count == 26)
                return true;
            s2map[r]++;
            if (s2map[r] == s1map[r])
                count++;
            else if (s2map[r] == s1map[r] + 1)
                count--;
            s2map[l]--;
            if (s2map[l] == s1map[l])
                count++;
            else if (s2map[l] == s1map[l] - 1)
                count--;
        }
        return count == 26;
    }
}