		//My solution, pretty obvious
		//Average runtime at 2ms faster than 51% O(n)?
		//Average memory less than 43% O(n)?
class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> mySet=new HashSet<>();
        while(n!=1){
            String nString=String.valueOf(n);
            n=0;
            for(char c:nString.toCharArray()){
                n+=Math.pow(c-'0',2);
            }
            if(mySet.contains(n)){
                return false;
            }else{
                mySet.add(n);
            }
        }
        return true;
    }
}

		//Recursive solution from leetcode 0ms sample
		//Great runtime at 0ms better than 100%
		//Average memory less than 59% (but this measure is weird)
		//Matematical problem, so not getting to much into details
class Solution {
    public boolean isHappy(int n) {
        if(n==1) return true;
        if(n<6) return false;
        int sum=0;
        while(n>0){
            sum+=(n%10)*(n%10);
            n=n/10;
        }
        return isHappy(sum);
    }
}
