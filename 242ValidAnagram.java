class Solution {
		//My solution, not very good runtime, better than 9%
		//not very good memory, less usage than 33.67%
		//o(n) runtime, o(n) memory
		//Took me 16 minutes to complete
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> letters=new HashMap<Character,Integer>();
        if(s.length()!=t.length()){
            return false;
        }
        for(int i=0;i<s.length();i++){
            if(letters.get(s.charAt(i))==null){
                letters.put(s.charAt(i),1);
            }else{
                letters.put(s.charAt(i),letters.get(s.charAt(i)) + 1);
            }
        }
        for(int i=0;i<s.length();i++){
            if(letters.get(t.charAt(i))==null || letters.get(t.charAt(i))<1){
                return false;
            }else{
                letters.put(t.charAt(i),letters.get(t.charAt(i)) - 1);
            }
        }
        return true;
    }

}
///Solution by leetode, sort array and compare, not very optimal, o(nlogn) runtime and o(1) (o(n) in java)
public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
        return false;
    }
    char[] str1 = s.toCharArray();
    char[] str2 = t.toCharArray();
    Arrays.sort(str1);
    Arrays.sort(str2);
    return Arrays.equals(str1, str2);
}

//Prefered solution by leetcode (and most comments)
//Hash table using an array (very optimal) o(n) time and o(1) space, because the table size
//will stay the same no matter n (26 length)
//And what if it was unicode? it could be up to one million different signs, that would be hard for an array, 
//so in that case a hash table is recommended
// faster than 71% less memory than 70.6%
 public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
        return false;
    }
    int[] counter = new int[26];
    for (int i = 0; i < s.length(); i++) {
        counter[s.charAt(i) - 'a']++;
        counter[t.charAt(i) - 'a']--;
    }
    for (int count : counter) {
        if (count != 0) {
            return false;
        }
    }
    return true;
}