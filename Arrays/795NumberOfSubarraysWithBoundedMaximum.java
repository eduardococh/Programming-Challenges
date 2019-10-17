class Solution {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int startIndex=0,endIndex=0;
        int result=0;
        for(int i=0;i<A.length;i++){
            if(A[i]>R){
                System.out.println("we enter "+startIndex+" "+i);
                result+=resolveSubarray(A,startIndex,i,L);
                startIndex=i+1;
            }
        }
        
        return result;
    }

    public int resolveSubarray(int[] array,int startIndex,int endIndex, int L){
        double result=0;
        int N=(endIndex-startIndex);
        result+=(N*(N+1))/2;
        boolean smallerNum=false;
        int numberOfSmaller=0;
        //System.out.println("our num is "+result);
        for(int i=startIndex;i<endIndex;i++){
            if(array[i]<L){
                numberOfSmaller++;
            }else{
                if(smallerNum){
                    N=numberOfSmaller;
                    result-=(N*(N+1))/2;
                    System.out.println("minus "+(N*(N+1))/2);
                    numberOfSmaller=0;
                    smallerNum=false;
                }
            }
        }
        return (int)result;
    }


}