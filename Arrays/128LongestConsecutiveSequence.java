class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Integer> fronts=new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> backs=new HashMap<Integer,Integer>();
        int longestSoFar=0;
        for(int num:nums){
            addToFrontOrBack(fronts,backs,num,longestSoFar);
        }
        return longestSoFar;
    }
}