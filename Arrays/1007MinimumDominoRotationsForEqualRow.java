        //My solution
        //First loop gets the number that's more common
        //Second loop checks if this number is common to all dominoes 
        //and the number of rotations
        //Amazing runtime at 3ms better than 99.74% O(N)
        //Good memory better than 87.50% O(1)
class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int num1=A[0],num2=B[0];
        int countA=0,countB=0;
        final int len=A.length;
        int iterate=0;

        for(int i=1;i<len;i++){
            if(num1!=A[i] && num1!=B[i]){//num1 is not my number
                num1=num2;
                break;
            }
            if(num2!=A[i] && num2!=B[i]){//num2 is not my number
                break;
            }
        }

        for(int i=0;i<len;i++){
                //one valid
                if( num1!=(A[i]) && num1!=(B[i])){
                    return -1;
                }
                if(A[i]==B[i]) continue; 
                if(num1==(A[i])) countA++;
                if(num1==(B[i])) countB++;
        }
        return Math.min(countA,countB);
    }
}