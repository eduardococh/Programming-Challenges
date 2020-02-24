        //My solution
        //Amazing runtime better than 99.87% O(n)
        //Terrible memory better than 7% but this 
        //Same approach as leetcode linear approach
class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        final int len=words.length;
        int index1=-1,index2=-1,shortest=Integer.MAX_VALUE;
        for(int i=0;i<len;i++){
            if(words[i].equals(word1)){
                index1=i;
            }else if(words[i].equals(word2)){
                index2=i;
            }
            if(index1!=-1 && index2!=-1 && Math.abs(index1-index2)<shortest) shortest=Math.abs(index1-index2);
        }
        return shortest;
    }
}