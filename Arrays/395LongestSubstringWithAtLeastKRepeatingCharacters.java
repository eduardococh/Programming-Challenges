        //My approach splitting string by invalid characters
        //Bad runtime of 119ms better than only 17.52% O(N^2)
        //Terrible memory
        //A good simple approach, could be more efficient
class Solution {
    public int longestSubstring(String s, int k) {
        int[] letters=new int[26];
        for(char car:s.toCharArray()){
            letters[car-'a']++;
        }
        final int len=s.length();
        int beforePartition=0,afterPartition=0;
        boolean partition=false;
        for(int i=0;i<len;i++){
            int current=s.charAt(i)-'a';
            if(letters[current]>0 && letters[current]<k){//current index is not valid(this car appears less than k times)
                beforePartition=longestSubstring(s.substring(0,i),k);                
                afterPartition=longestSubstring(s.substring(i+1,s.length()),k);
                partition=true;
                break;
            }
        }
        if(!partition){//all characters are valid
            return s.length();
        }
        return beforePartition>afterPartition?beforePartition:afterPartition;
    }
}


        //My same approach, but gets rid of StringBuilder and uses indexes instead
        //Amazing runtime 0ms better than 100% 
class Solution {
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        if (k<2) return s.length();
        return helper(s, 0, s.length(), k);
    }

    public int helper(String s, int l, int r, int k) {
        if (l>=r) return 0;
        
        // build freq map
        int[] freq = new int[26];
        for (int i=l; i<r; i++) freq[s.charAt(i)-'a']++;
        
        // check if valid
        boolean valid = true;
        for (int i=0; i<26 && valid; i++) if (freq[i] > 0 && freq[i] < k) valid = false;
        if (valid) return r-l;
        
        // if not for each invalid character start a new split search
        int best = 0, start=l;
        for (int i=l; i<r; i++) {
            if (freq[s.charAt(i) -'a'] < k) {
                best = Math.max(best, helper(s, start, i, k));
                start = i+1;
            }
        }
        best = Math.max(best, helper(s, start, r, k));
        return best;
    }
}

        //Sliding window 2 pointer approach from leetcode sniffsky
        //
public class Solution {
    public int longestSubstring(String s, int k) {
        char[] str = s.toCharArray();
        int[] counts = new int[26];
        int h, i, j, idx, max = 0, unique, noLessThanK;
        
        for (h = 1; h <= 26; h++) {
            Arrays.fill(counts, 0);
            i = 0; 
            j = 0;
            unique = 0;
            noLessThanK = 0;
            while (j < str.length) {
                if (unique <= h) {
                    idx = str[j] - 'a';
                    if (counts[idx] == 0)
                        unique++;
                    counts[idx]++;
                    if (counts[idx] == k)
                        noLessThanK++;
                    j++;
                }
                else {
                    idx = str[i] - 'a';
                    if (counts[idx] == k)
                        noLessThanK--;
                    counts[idx]--;
                    if (counts[idx] == 0)
                        unique--;
                    i++;
                }
                if (unique == h && unique == noLessThanK)
                    max = Math.max(j - i, max);
            }
        }
        
        return max;
    }
}