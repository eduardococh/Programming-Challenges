		//My solution, brute force
		//Bad runtime at 235ms better than only 19% O(N) for every query
		//Bad memory better than only 17% O(1) (note that array is a reference to nums and not a copy of it)
		//Bad simple solution
class NumArray {

    private int array[];
    
    public NumArray(int[] nums) {
        array=nums;
    }
    
    public int sumRange(int i, int j) {
        int res=0;
        for(int k=i;k<=j;k++){
            res+=array[k];
        }
        return res;
    }
}

        //One pass solution from leetcode 1ms samples
        //Amazing runtime better than 100% O(N)
        //Good memory better than 60% O(N)
        //Precompute sum up to every index i
        //when called by sumRange return all sums, doing validations
        //(i should be smaller than j, i bigger than 0 and j smaller than preSum.length)
        //this logis is inverted because using an OR is faster than AND
class NumArray {
    private int[] preSum;
    public NumArray(int[] nums) {
        preSum = new int[nums.length + 1];
        preSum[0] = 0;
        for(int i = 0; i < nums.length; i ++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        if(i > j || i < 0 || j > preSum.length - 1) 
            return 0;
        return preSum[j + 1] - preSum[i];
    }
}

		//Caching solution by leetcode
		//Do a precomputing of all posible sums and then just access them
		//Couldn't get to run it, but runtime should be o(n^2) in precomputing and o(1) in execution of queries 
		//Memory of O(N^2)
        //Not a good approach, bad runtime N^2, linear solutions are simpler
private Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();

public NumArray(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
        int sum = 0;
        for (int j = i; j < nums.length; j++) {
            sum += nums[j];
            map.put(Pair.create(i, j), sum);
        }
    }
}

public int sumRange(int i, int j) {
    return map.get(Pair.create(i, j));
}




		//A smarter caching solution by leetcode
		//Simple improvement by using a formula, only store N positions
		//Were every position is the cumulative sum
		//formula is: the sum from (i,j) is = sum[j+1] - sum[i]
		//or to the sum in next to j (where j has already been summed) remove the sum until i (were i has not been summed)	
		//Precomputation takes O(n) and queries O(1), runtime of 51ms better than 94.43%
		//Space complexity of 39.9MB O(N) better than 100
		//This is the best approach, the 100% does the same
class NumArray {

    private int[] sum;

    public NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}