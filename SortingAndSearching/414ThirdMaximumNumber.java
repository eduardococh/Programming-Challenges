        //My solution, more complex than most since I put myself a constraint to only use
        //integers, a double would have helped with detecting if returning maximum or third
        //maximum, which took me a lot with this constraint
        //Average runtime of 3ms better than 54.40%
        //Good memory better than ~90%
        //Complex approach because of my added constraint
class Solution {
    public int thirdMax(int[] nums) {
        int firstM=Integer.MIN_VALUE,secondM=Integer.MIN_VALUE,thirdM=Integer.MIN_VALUE;
        HashSet<Integer> numSet=new HashSet<Integer>();
        int diffNums=0;
        for(int num:nums){
            if(!numSet.contains(num)){
                diffNums++;
                if(num>firstM){
                    thirdM=secondM;
                    secondM=firstM;
                    firstM=num;
                }else if(num>secondM){
                    thirdM=secondM;
                    secondM=num;
                }else if(num>thirdM){
                    thirdM=num;
                }
                numSet.add(num);
            }
        }
        if(diffNums<3){
            return firstM;
        }
        return thirdM;
    }
}

        //From leetcode's 0ms solution
        //Actually there's no need for a heap as I thought (but one could be used)
        //They use long which makes the task of return 1st or 3rd simpler
        //Good runtime better than 88.69% O(N)
        //Good memory better than ~99% O(1)
class Solution {
    public int thirdMax(int[] nums) {
        long max1 = Long.MIN_VALUE,max2 = Long.MIN_VALUE,max3 = Long.MIN_VALUE;
        
        for(int num:nums)
        {
            if(num>max1)
            {
                max3 = max2;
                max2 = max1;
                max1 = num;
            }
            else if(num < max1 && num > max2)
            {
                max3 = max2;
                max2 = num;
            }
            else if(num < max2 && num > max3)
            {
                max3 = num;
            }
        }

        return (max3 == Long.MIN_VALUE || max2 == max3) ? (int)max1 : (int)max3;
    }
}


        //Solution using a heap (prority queue)
        //Works but it is not as fast
        //Bad runtime at 7ms faster than 16.93% O(N)
        //Amazing memory better than 100% O(N) (set can contain up to N numbers, so not very sure why memory is so good)
public class Solution {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!set.contains(i)) {
                pq.offer(i);
                set.add(i);
                if (pq.size() > 3) {
                    set.remove(pq.poll());
                }
            }
        }
        if (pq.size() < 3) {
            while (pq.size() > 1) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}