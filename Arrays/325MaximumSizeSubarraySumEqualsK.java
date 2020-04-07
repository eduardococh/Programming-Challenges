        //My brute force solution
        //Start with the biggest possible array and then try smaller arrays conmbinations
        //Terrible runtime 1200ms+ better than only 5% o(N^2)
        //Terrible memory better than only 5%
        //Not really a good approach but it works
class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        final int len=nums.length;
        int sum=0,permSum=0;
        for(int num:nums) sum+=num;
        permSum=sum;
        if(sum==k) return len;
        for(int size=len-1;size>=1;size--){
            sum=permSum;
            for(int delete=len-1;delete>=size;delete--){//delete N numbers from back of array
                sum-=nums[delete];
            }
            if(sum==k) return size;
            for(int i=0;i<len-size;i++){//slide window from 0 to len-size
                sum-=nums[i];
                sum+=nums[size+i];
                if(sum==k) return size;
            }
        }
        return 0;
    }
}

