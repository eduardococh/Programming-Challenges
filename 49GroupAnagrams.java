class Solution {
		//My solution, brute force terrible runtime of 441ms (worse than 99%) and complex
		//runtime of O(S*L) S=array length , L=max length of a string in strings
		//Memory usage 43.7 better than 47.33% as O(S*L)
		
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answer=new ArrayList<List<String>>();
        int chars[][]=new int[strs.length][26];
        int position[]=new int[strs.length];
        int currentCounter=0;
        for(int i=0;i<strs.length;i++){
            
            String str=strs[i];
            final int length=str.length();
            //FILL ARRAY
            for(int j=0;j<str.length();j++){
                char character=str.charAt(j);
                chars[i][character-'a']++;
            }
            //VERIFY IF THIS STRING ARRAY IS EQUAL TO SOME OTHER STRING ARRAY
            boolean isEqual=false;
            for(int k=0;k<i;k++){
                if(i!=k && Arrays.equals(chars[i],chars[k])){
                    position[i]=position[k];
                    isEqual=true;
                }
            }
            if(isEqual==false){
                position[i]=currentCounter;
                currentCounter++;
            }
        }
        for(int i=0;i<currentCounter;i++){
            List<String> list=new ArrayList<String>();
            for(int j=0;j<strs.length;j++){
                if(position[j]==i){
                    list.add(strs[j]);
                }
            }
            answer.add(list);
        }
        return answer;
    }
}


class Solution {
		//Leetcode Categorize sorted string in map approach
		//Good runtime at O(S L log(L)) giving 10ms, faster than 78.54% and
		//Good memory at O(SL) giving 42.6mb better than 70.07%
		//Worth noting the use of Arrays.sort(ca); which i lacked for this approach
		//Convert string to char array and sort it, then compare it and add
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}

class Solution {
		//Second approach by leetcode, similar to mine O(S*L) but uses hashmap to do comparisons
		//Which is way faster, but not faster than first approach at 29ms, faster than only 16%
		//Memory of O(S*L) better than only 17.20%
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}
