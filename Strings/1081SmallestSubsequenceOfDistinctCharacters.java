        //Greedy algorithm by leetcode's tacoman
        //Amazing runtime of 2ms better than 91.88% O(N)
        //Amazing memory better than 100% o(n)
        //The algorithm might not be so obvious, but once you understand it it's amazing
        //really simple and fast
        //duplicate of https://leetcode.com/problems/remove-duplicate-letters/
class Solution {
    public String smallestSubsequence(String text) {
        StringBuilder sb = new StringBuilder(); 
        Stack<Character> st = new Stack<>();
        boolean[] visited = new boolean[26]; 
        int[] counts = new int[26];
        //count every letter number of times
        for(char ch : text.toCharArray()) counts[ch-'a']++; 

        //for every letter
        for(char ch : text.toCharArray()) {
            //reduce my count by one
            counts[ch-'a']--; 
            //if I have already visited this letter continue;
            if(visited[ch-'a']) continue; 
            //if I have not visited this letter('I'm the first time my letter appears')
            //while stack is not empty AND the next element in the stack is bigger letter than me
            //AND count for this bigger letter is bigger than me
            while(!st.isEmpty() && st.peek() > ch && counts[st.peek()-'a'] > 0) {     
                //unvisit all letters bigger than me
                visited[st.pop()-'a'] = false;
            }
            //add me to the stack
            st.push(ch); 
            //set me visited
            visited[ch-'a'] = true;
        }
        //add all letters that could be left in the array
        while(!st.isEmpty()) sb.append(st.pop()); 
        sb.reverse(); 
        return new String(sb); 
    }
}