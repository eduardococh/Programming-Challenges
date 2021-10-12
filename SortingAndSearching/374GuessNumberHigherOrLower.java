/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */



		//My solution with binary search
		//Better runtime than 100%
		//Better memory than 100%
		//Really not much to improve (maybe saving guess result in a variable instead
		//of two calls, but is memory vs runtime)
		//Good solution

public class Solution extends GuessGame {

    public int guessNumber(int n) {

        int low=0,high=n;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(guess(mid)==0) return mid;
            if(guess(mid)==1){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return 0;
    }

}

    //Second attempt (part of leetcode daily challenges)
    //Solved quickly with binary search
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int current=n/2;
        int low=1,high=n;
        while(guess(current)!=0){
            if(guess(current)<0){//num is lower
                high=current-1;
            }else{//num is higher
                low=current+1;
            }
            current=low+(high-low)/2;
        }
        return current;
    }
}