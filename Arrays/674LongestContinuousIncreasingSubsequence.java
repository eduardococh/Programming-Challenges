        //My solution
        //Simple, easy
        //Amazing runtime of 1ms better than 99.49% O(N)
        //Bad memory better than only 5% O(1)
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums==null) return 0;
        if(nums.length<2) return nums.length;
        int res=0,temp=1;
        final int len=nums.length;
        
        for(int i=1;i<len;i++){
            if(nums[i]<=nums[i-1]){
                if(temp>res) res=temp;
                temp=0;
            }
            temp++;
        }
        if(temp>res) res=temp;
        return res;
    }
}