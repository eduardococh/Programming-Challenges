		//Solution by leetcode's sim5
		//Really easy and elegant solution
		//Amazing runtime of 0ms better than 100% O(n)
		//Great memory of 38.8mb better than 95.70% o(1)
  
public boolean increasingTriplet(int[] nums) {
        // start with two largest values, as soon as we find a number bigger than both, while both have been updated, return true.
        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= small) { small = n; } // update small if n is smaller than both
            else if (n <= big) { big = n; } // update big only if greater than small but smaller than big
            else return true; // return if you find a number bigger than both
        }
        return false;
    }