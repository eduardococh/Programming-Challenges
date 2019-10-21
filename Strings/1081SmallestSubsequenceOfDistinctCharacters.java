        //By tacoman
class Solution {
    public String smallestSubsequence(String text) {
        StringBuilder sb = new StringBuilder(); 
        Stack<Character> st = new Stack<>();
        boolean[] visited = new boolean[26]; 
        int[] counts = new int[26];
        for(char ch : text.toCharArray()) counts[ch-'a']++; 
        for(char ch : text.toCharArray()) {
            counts[ch-'a']--; 
            if(visited[ch-'a']) continue; 
            while(!st.isEmpty() && st.peek() > ch && counts[st.peek()-'a'] > 0) {     
                visited[st.pop()-'a'] = false;
            }
            st.push(ch); 
            visited[ch-'a'] = true;
        }
        while(!st.isEmpty()) sb.append(st.pop()); 
        sb.reverse(); 
        return new String(sb); 
    }
}