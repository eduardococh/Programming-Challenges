        //My Solution
        //Average
class Solution {
    public String reverseWords(String s) {
        String words[]=s.split(" ");
        StringBuilder result=new StringBuilder("");
        for(String word:words){
            result.append(new StringBuilder(word).reverse()+" ");
        }
        return result.toString().substring(0,result.length()-1);
    }
}