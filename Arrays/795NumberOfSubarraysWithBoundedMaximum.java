        //My solution
        //Divide input into subarrays based on numbers bigger than R
        //once i have a subarray just calculate the "potential" number
        //and then use the numbers smaller than L to substract them from
        //potencial number
        //Simple solution in my opinion, but my code is lenghy
        //FUNDAMENTAL: Use formula N*(N+1)/2 to get the total number
        //of potential results
        //Average runtime at 4ms better than 34.44% O(N)
        //Best memory than 100% O(1)
class Solution {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int startIndex=0,endIndex=0;
        int result=0;
        for(int i=0;i<A.length;i++){
            if(A[i]>R){
                result+=resolveSubarray(A,startIndex,i-1,L);
                startIndex=i+1;
            }else if(i==A.length-1){
                result+=resolveSubarray(A,startIndex,i,L);
            }
        }
        
        return result;
    }

    public int resolveSubarray(int[] array,int startIndex,int endIndex, int L){
        double result=0;
        int N=(endIndex-startIndex)+1;
        result+=(N*(N+1))/2;
        boolean smallerNum=false;
        int numberOfSmaller=0;
        for(int i=startIndex;i<=endIndex;i++){
            if(array[i]<L){
                numberOfSmaller++;
                smallerNum=true;
            }else{
                if(smallerNum){
                    N=numberOfSmaller;
                    result-=(N*(N+1))/2;
                    numberOfSmaller=0;
                    smallerNum=false;
                }
            }
        }
        if(smallerNum){
            N=numberOfSmaller;
            result-=(N*(N+1))/2;
            numberOfSmaller=0;
            smallerNum=false;
        }
        return (int)result;
    }


}

        //Leetcode's solution
        //First count all numbers smaller or equal than R, this will be your "potential"
        //then cound all numbers smaller or equal than L-1, this will be the one giving result
        //This solution is super simple and elegant, maybe not so logical as the one above
        //Amazing runtime better than 97.79% O(N)
        //Amazing memory better than 100% O(1)
class Solution {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        return count(A, R) - count(A, L - 1);
    }
    
    public int count(int[] A, int bound) {
        int cur = 0, res = 0;
        for (int num : A) {
            cur = num <= bound ? cur + 1 : 0;
            res += cur;
        }
        return res;
    }
}