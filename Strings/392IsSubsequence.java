        //My solution
        //Search for every character of s in t, if all are found result
        //is true, simple
        //Good runtime of 9ms O(t) better than 83.03%
        //Average memory better than ~60% O(t)
class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length()==0) return true;
        int indexS=0;
        for(char current:t.toCharArray()){
            if(current==s.charAt(indexS)){
                indexS++;
                if(indexS==s.length()) return true;
            }
        }
        return false;
    }
}


        //Much clever solution from leetcode's 0ms sample
        //Go through every char in s (smaller string) and use indexOf
        //method of java, if the character is not found it will return -1 and
        //then you can return false, else return true
        //Amazing runtime better than 100% O(S)
        //Amazing memory better than 100% O(1)
        //NOTE: indexOf method can have two parameters, the second defines 
        //the index to start the search from, this avoids finding the same character twice
        //and when j is set to 0 the program ends, so it is not possible to find the same a
        //and break the logic, index j only goes forward
class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            j = t.indexOf(s.charAt(i), j);
            if (j < 0) {
                return false;
            }
            j++;
        }
        return true;
    }
}