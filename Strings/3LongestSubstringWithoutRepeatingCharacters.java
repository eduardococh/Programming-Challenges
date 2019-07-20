class Solution {
		//My solution O(S^2), actually not as bad as i though for a kinda brute force
		//Doing better than 86% in runtime
		//Bad memory being better than only 20% O(1) or o(m) m=charset, i dont know?
		//
    public int lengthOfLongestSubstring(String s) {
        int letters[]=new int[110];
        int currentLongest=0,result=0;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                
                char current=s.charAt(j);
                if(letters[current-32]==0){
                    letters[current-32]++;
                    currentLongest++;
                }else{
                    if(currentLongest>result){
                        result=currentLongest;
                    }
                    letters=new int[102];
                    currentLongest=0;
                    break;

                }   
            }
        }
        if(currentLongest>result){
            result=currentLongest;
        }
        return result;
    }
}

public class Solution {
		//Leetcode's sliding window approach, runtime of O(2N)= O(N), better than 79%
		//in the worst case every character will be visited twice by i and j
		//Space complexity of O(min(m,n)) memory better than 38.98%
		//My mid brute force algorithm did better than this one surprisingly
		//important to note that my algorithm assumes input from ' ' to 'Z', leetcodes answer do not
		//assume this, thats why my algotithm was faster

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {

            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                ans = Math.max(ans, j - i);
            }else {
                set.remove(s.charAt(i));
                i++;
            }

        }
        return ans;
    }
}

public class Solution {
		//Optimized sliding window with hashmaps (no input range assumed)
		//Rutime 8ms better than 86%
		//Memory of O(min(m,n))
		//i need to use more math.max
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}


public class Solution {	
		//Leetcode optimized sliding window with arrays (assumes ascii 128 input)
		//Faster than 99.90% o(n)
		//Memory better than 43.14% O(m) m=size of charset

    public int lengthOfLongestSubstring(String s) 
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }
}
