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