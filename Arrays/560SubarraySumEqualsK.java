public class Solution {
		//Brute force o(n3) time limit exceded and o(1) memory
		//"Easy" approach but not optimal at all
        //Start from every index [0-5]
        //End in every index plus [1,2,...]
        //Do the sum from start to end
        //This is not really the most logical and most would have the second solution   
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            for (int end = start + 1; end <= nums.length; end++) {
                int sum = 0;
                for (int i = start; i < end; i++)
                    sum += nums[i];
                if (sum == k)
                    count++;
            }
        }
        return count;
    }
}

        //Probably the solution most will come up with, instead of the first solution
        //Bad runtime of 231ms better than 11.39%O(N^2) (this runtime varies wildy, 231 is the smaller found)
        //Bad memory better than 5% O(1)
        //Visually it goes
        //[4,-5,6,7] (checks 4 subarrays)
        //  [-5,6,7] (checks 3 subarrays)
        //     [6,7] (checks 2 subarrays)
        //       [7] (checks 1 subarray)
public class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum=0;
            for (int end = start; end < nums.length; end++) {
                sum+=nums[end];
                if (sum == k)
                    count++;
            }
        }
        return count;
    }
}

    
		//Best solution, understanging this is key, o(n) runtime and o(n) memory
		//So we store sum in a hashmap, and whenever we repeat a sum we add it to the count
		//We put the first   map.put(0, 1); so we can consider the number k itself
        //Good runtime of 13ms better than 43.59% O(N)
public class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap < Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}