        //Same problem as LC 1011
        //Same binary search as used in 1011
        //Amazing runtime of 0ms better than 100% O(M*Log(N)) where N is the sum of nums
        //Bad memory better than 15.63%
class Solution {
    public int splitArray(int[] nums, int m) {
        int res=nums.length;
        int total=0,max=0;
        for(int n:nums){
            if(n>max) max=n;
            total+=n;
        }	
        int low=max;
        int high=total;
        while(low<high){//binary searching for the lowest
            int mid=low+(high-low)/2;
            int nDays=getDays(mid,nums,m);
            if(nDays<=m){//right amount of days, could we go lower?
                high=mid;
            }else{//taking too long, increase weight capacity
                low=mid+1;
            }
        }
        return low;
    }
    private int getDays(int weight,int w[],int D){
		int days=1;
		int currentPackage=0;
		int weightSoFar=0;
		while(currentPackage<w.length){
            if(weightSoFar+w[currentPackage]<=weight){
                weightSoFar+=w[currentPackage];
            }else{
                days++;
                if(days>D) return Integer.MAX_VALUE;
                weightSoFar=w[currentPackage];
            }
            currentPackage++;
        }
        return days;
    }
}