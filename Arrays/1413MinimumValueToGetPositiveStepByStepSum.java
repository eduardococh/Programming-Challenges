    //Brute Force solution
    //Terible runtime 2ms better than only 11% O(N)
    //Terrible memory better than only 5%
    class Solution {
        public int minStartValue(int[] nums) {
            int minVal=1;
            while(true){
                int i=0;
                int currentVal=minVal;
                for(i=0;i<nums.length;i++){
                    currentVal+=nums[i];
                    if(currentVal<1){
                        break;
                    }
                }
                if(i==nums.length){
                    return minVal;
                }
                minVal++;
            }
        }
    }