        //My solution
        //Good runtime of 2ms better than 82.37% O(N) where N is number of words
        //Good memory better than ~70% O(N)
        //Really simple, split the words by space, which leaves empty words (happens
        //when we have two or more spaces together)
class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        String arr[]=s.split(" ");
        StringBuilder st=new StringBuilder();
        for(int i=arr.length-1;i>=0;i--){
            if(!arr[i].equals("")){
                //System.out.println(arr[i].trim());
                st.append(arr[i].trim()+" ");    
            }
        }
        return st.toString().trim();
    }
}


        //From leetcode's 0ms samples
        //Good runtime and memory
        //The manual fast solution, 
        //Go char by char, when you have empty spaces pass (second while)
        //then use lastIndex of, specifing length, which will give you the start of the word
        //then just append this to result
class Solution {
    public String reverseWords(String s) {
                s=s.trim();
        int len = s.length()-1;
        StringBuilder ans = new StringBuilder();
        while(len >= 0){
            while(len>=0 && s.charAt(len)==' ') len--;
            int index = s.lastIndexOf(' ', len);
            if(index == -1){
                ans.append(s.substring(0,len+1));
            }else{
                ans.append(s.substring(index+1, len+1)).append(" ");
            }
            len = index - 1;
        }
        return ans.toString();
    }
}