		//My solution with a two pointers approach
		//Good runtime
class Solution {
    public int maxArea(int[] height) {
        int start=0,end=height.length-1,maxCap=0;
        while(start<end){
            int currentCap=Math.min(height[start],height[end])*(end-start);
            if(currentCap>maxCap){
                maxCap=currentCap;
            }
            if(height[start]<height[end]){
                start++;
            }else{
                end--;
            }
        }
        return maxCap;
    }
}