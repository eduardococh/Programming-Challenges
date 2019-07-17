		//My solution with a two pointers approach
		//Good runtime of 2ms better than 94.10% O(N)
		//Good memory of 39.5mb better than 95.70% O(1)
		//Smart approach, might have little improvements as seen on 1ms solution
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


		//Solution from leetcode's 1ms sample
		//Amazing runtime of 1ms better than 100%
		//Good memory same as mine
		//Same approach as me, only difference is that he does not uses math.min
		//He only uses >=
		//Good
class Solution {
    public int maxArea(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        
        int maxArea = 0;
        int left = 0;
        int right = height.length -1;
        while(left < right) {
            int area = 0;
            if (height[left] <= height[right]) {
                area = (right -left) * height[left];
                left++;
            } else {
                area = (right -left) * height[right];
                right--;
            }
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }
}

		//Brute force solution, I did not bother to run it
public class Solution {
    public int maxArea(int[] height) {
        int maxarea = 0;
        for (int i = 0; i < height.length; i++)
            for (int j = i + 1; j < height.length; j++)
                maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
        return maxarea;
    }
}