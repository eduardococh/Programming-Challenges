class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0) return new int[]{-1,-1};
        int left=0;
        int right=nums.length-1;
        while(left<right){
            int med=left+(right-left)/2;
            if(nums[med]==target){
                //WE FOUND NUM
                int r1=med;
                while(nums[r1]==target){
                    if(r1==0){
                        break;
                    }
                    r1--;
                }
                int r2=med;
                while(nums[r2]==target){
                    if(r2==nums.length-1){
                        break;
                    }
                    r2++;
                }
                if(nums[r1]!=target){
                    r1++;
                }
                if(nums[r2]!=target){
                    r2--;
                }
                return new int[]{r1,r2};
            }
            if(nums[med]<target){//it means target is to the right
                left=med+1;
            }else{//med is bigger than target, target is to the left
                right=med;
            }
        }
        if(nums[left]==target){
            return new int[]{left,left};
        }
        return new int[]{-1,-1};
    }
}