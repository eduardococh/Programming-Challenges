		//My approach, valid I guess, faster than 100% and better memory than 100%
class Solution {
    public int mySqrt(int x) {
        return (int)Math.sqrt(x*1.0);
    }
}



		//Binary search solution
		
public int mySqrt(int x) {
    if(x <= 1) return x;
    int left = 1, right = x;
    while(left < right) {
        int mid = left + (right - left) / 2;
        if(mid <= x / mid) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }
    return left - 1;
}



		//Newtons method by leetcode's StefanPochmann
		//Faster than 100% runtime of O(lg(x))
		//Memory better than 100%
		//While we have not found r value, r = (r + x/r) / 2  
				if x=20
				   r = (20 + 20/20)/2 = 10.5 = 10 * 10 bigger than 20
				   r = (10 + 20/10)/2 = 6 * 6 bigger than 20
				   r = (6  + 20/6 )/2 = 4.66 = 4 * 4 not bigger than 20
class Solution {
    public int mySqrt(int x) {
        long r = x;
        while (r*r > x)
            r = (r + x/r) / 2;
        return (int) r;
    }
}