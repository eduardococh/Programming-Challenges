        //My solution
        //Terrible runtime at 89ms better than 7.29% O(N Log N) for contructor because of sorting
        //O(Log N) for generating the random index, because of the binary search for lower and upper bounds
        //Amazing runtime better than 100% O(N)
class Solution {
    
    private int[][] nums;

    public Solution(int[] nums) {
        this.nums=new int[nums.length][2];
        int j=0;
        for(int num:nums){
            this.nums[j][0]=num;
            this.nums[j][1]=j++;
        }
        Arrays.sort(this.nums, (a, b) -> Integer.compare(a[0], b[0]));//STUDY COMPARES
    }
    
    public int pick(int target) {
        //binary search for the leftmost bound
        int left=left(target);
        //binarySearch for the rightmost bound
        int right=right(target);
        //System.out.println(right);
        return nums[(int)(Math.random()*(right+1-left))+left][1];
    }
    
    public int left(int target){
        int start=0,end=nums.length-1;
        while(start<end){
            int mid=end-(end-start)/2;
            if(nums[mid][0]==target && (mid==0 || nums[mid-1][0]!=target)) return mid;//this is the leftmost target
            if(nums[mid][0]==target){//target but not leftmost
                end=mid-1;
            }else if(nums[mid][0]<target){//target is bigger, search right
                start=mid+1;
            }else{//target is smaller, search left
                end=mid-1;
            }
        }
        return start;
    }
    
    public int right(int target){
        int start=0,end=nums.length-1;
        while(start<end){
            int mid=end-(end-start)/2;
            if(nums[mid][0]==target && (mid==nums.length-1 || nums[mid+1][0]!=target)) return mid;//this is the right target
            if(nums[mid][0]==target){//target but not rightmost
                start=mid+1;
            }else if(nums[mid][0]<target){//target is bigger, search right
                start=mid+1;
            }else{//target is smaller, search left
                end=mid-1;
            }
        }
        return start;
    }
}


        //Reservoir sampling solution from leetcode's 45ms samples
        //Amazing runtime btter than 100%
        //Amazing memory better than 100%
        //The algorithm is good, but in my opinion a tradeoff of memory for time, since time complexity of
        //pick is O(N) versus O(Log N) with a sorted list and binary search
class Solution {
    
    Random random;
    int[] copy;

    public Solution(int[] nums) {
        random = new Random();
        copy = nums;
    }
    
    public int pick(int target) {
        int count = 0;
        int result = 0;
        
        for(int i = 0; i < copy.length;i++) {
            if(target == copy[i]){
                count++;

                //random.nextInt(upperBound) will generate a random number from 0(inclusive) to upperBound(exclusive)
                //adding all occurrences of the target to a pool of random supply, where every arriving node has the
                //same chance of being chosen as the ones before and after
                if(random.nextInt(count) == 0){
                    result = i;
                }
            }
        }
        return result;
    }
}