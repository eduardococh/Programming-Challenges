        //Leetcode's solution
        //Amazing runtime 0ms better than 100% O(N)
        //Good memory better than 48% O(1)
        //Go from backward to forward and search for the first number that decreases
        //like in [8,5,3,2,7,4,1] you will find 2, then start a search for the next bigger number
        //which will be 7 for this example, swap both numbers and then reverse the array
        //from the found position forward
public class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
        
        
        //My solution using priority queue
        //Complex, based on the approach used in LC 1053
        //Bad runtime better than only 6.39% O(N)
        //Average memory better than 46% O(N)
class Solution {
    public void nextPermutation(int[] nums) {
        //default min queue
        PriorityQueue<Integer> prioQ=new PriorityQueue<>();
        final int len=nums.length;
        int startNum=-1,startIndex=-1;
        int nextNum=-1;
        boolean inSequence=false;
        for(int i=0;i<len-1;i++){
            if(nums[i]<nums[i+1]){
                startNum=nums[i];
                startIndex=i;
                nextNum=nums[i+1];
                prioQ=new PriorityQueue();
                prioQ.add(startNum);
                inSequence=true;
            }else{
                if(inSequence){
                    prioQ.add(nums[i]);
                    if(nums[i]-startNum<1) continue;
                    if(nextNum-startNum>nums[i]-startNum){
                        nextNum=nums[i];
                    }
                }else{
                    prioQ.add(nums[i]);
                }
            }
        }
        prioQ.add(nums[len-1]);
        if(!inSequence){
            for(int i=0;i<len;i++){
                nums[i]=prioQ.poll();
            }
            return;
        }
        if(nums[len-1]-startNum>0){
            if(nextNum-startNum>nums[len-1]-startNum){
                nextNum=nums[len-1];
            }    
        }
        nums[startIndex]=nextNum;
        while(!prioQ.isEmpty()){
            int current=prioQ.poll();
            if(current==nextNum) {
                nextNum=-1;
                continue;
            }
            nums[++startIndex]=current;
        }
    }
}