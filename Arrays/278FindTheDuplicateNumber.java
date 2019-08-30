        //My brute force solution
        //Bad runtime of 232ms O(N^2) (the rules said it SHOULD be lower than this, so it's not
        //necessarily against rules), still not a good approach, better than only 5.04%
        //Bad memory better than only 37.29%
class Solution {
    public int findDuplicate(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int cont=0;
            for(int j=0;j<nums.length;j++){
                if(nums[j]==i) cont++;
            }
            if(cont>1){
                return i;
            }
        }
        return -1;
    }
}

        //There's a solution using sorting (N Log(N))
        //And a Set (N), but bot are explicity forbidden and easy to come up

        //Leetcode's solution
        //Cycle detection approach
        //Amazing runtime at 0ms better than 100% O(N)
        //Average memory better than 42.37%
        //
class Solution {
    public int findDuplicate(int[] nums) {
        // Find the intersection point of the two runners.
        int tortoise = nums[0];
        int bunny = nums[0];
        do {
            tortoise = nums[tortoise];
            bunny = nums[nums[bunny]];
        } while (tortoise != bunny);

        // Find the "entrance" to the cycle.
        int ptr1 = nums[0];
        int ptr2 = tortoise;
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }

        return ptr1;
    }
}