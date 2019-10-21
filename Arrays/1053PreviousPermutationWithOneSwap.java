        //Solution from leetcode's 0ms samples
        //Amazing runtime of 0ms better than 100% O(N)
        //Amazing memory better than 100% O(1)
        //Simple approach, find the first non decreasing number from last to first and
        //swap it with the first element smaller than swapIndex that is bigger than the number
        //after it, or with swapIndex+1 if we reach it and no number fills the other condition
class Solution {
    public int[] prevPermOpt1(int[] A) {
     /*
            case 1: 1 2 3 no solution 
                case 2: 3 2 1
                5, 5, 4, 6, 7 => 5, 7, 4, 6, 9
                5, 9, 4, 7, 6 => 5, 9, 
                5, 1 , 5 , 4, 6, 7
                3, 1, 1, 3 
                swap A: if (A[i] <= A[i-1]) swapA= A[i-1]; if swap[i] = A[n-1] return;
                swap B: 
                from last to first scan: 
                go up and find the peek
        */
        
        int n = A.length;
        
        if (n == 1) return A;

        int swapIndex = n;

        //FIRST LOOP
        //finds the index of the first element that is bigger than the element after it
        //in this case it will find number 9 this will be swap index
        //  |
        //1,9,4,6,7,8

        //go backwards from last index to second index and find the first index where i is smaller than i-1
        //we dont go to 0 since every loop covers i-1
        for (int i = n - 1; i >= 1; i--) {
            if (A[i] < A[i-1]) {
                swapIndex = i - 1;
                break;
            }
        }
        //the numbers are continuously decreasing, eg. 1,2,3 so there's no smaller permutation
        if (swapIndex == n) return A;

        //SECOND LOOP 
        
        //finds the index of the element to be swapped
        //  |       |
        //1,9,4,6,7,8


        //go from last index until one index above swapIndex 
        for (int i = n - 1; i > swapIndex; i--) {
            //if im swapIndex+1 (last iteration of this loop) 
            //OR
            //im smaller than swap index
            //AND im bigger than previous index (this one might seem counterintuitive since in the first
            //loop we asked explicitly about this, but it works for cases where there are repeated numbers
            //like the famous 3,1,1,3->1,3,1,3 otherwise outputs wrong answer 1,1,3,3)
            if (i == swapIndex + 1 || ( A[i] < A[swapIndex] && A[i] > A[i-1] ) ) {
                int temp = A[i];
                A[i] = A[swapIndex];
                A[swapIndex] = temp;
                return A;
            }
        }
        //this case should not be entered if input is in the right constraints
        //it would output an array n length of pure 0's
        return new int[n];
    }
}