        //Surprinsingly simple solution from leetcode's 0ms samples
        //I spent two hours trying to do this simple thing
        //The principle behind how simple it is is that when none numbers
        //appear in pairs they can be multiplied to a positive, and when none numbers
        //apear in none ocations the maximum can be calculated by right or left
        //This is apparently faster than even the dp solution explored below
        //Amazing runtime better than 100% O(N)
        //Amazing memory better than 100% O(N)
class Solution {
    public int maxProduct(int[] nums) {
        
        int product = 1;
        int max = Integer.MIN_VALUE;
        
        if(nums.length == 0 || nums == null) {
            return 0;
        }
        
        //left to right
        for(int i = 0; i < nums.length; i++) {
            product *= nums[i];
            if(product > max) {
                max = product;
            }
            
            if(product == 0) {
                product = 1;
            }
        }
        
        //right to left
        product = 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            product *= nums[i]; 
            if(product > max) {
                 max = product; 
            }
            
            if(product == 0) {
                product = 1;
            }
        
        }
        return max; 
        
    }
}

        //Solution by leetcode's mzchen 
        //Dynamic programming approach
        //It self explains with commentaries provided  by mzchen
        //Amazing runtime better than 99%
        //Amazing memory better than 100%
int maxProduct(int A[], int n) {
    // store the result that is the max we have found so far
    int r = A[0];

    // imax/imin stores the max/min product of
    // subarray that ends with the current number A[i]
    for (int i = 1, imax = r, imin = r; i < n; i++) {
        // multiplied by a negative makes big number smaller (10*-2=-20),
        // small number bigger                               (5*-2=-10)
        // so we redefine the extremums by swapping them
        if (A[i] < 0)
            swap(imax, imin);

        // max/min product for the current number is either the current number itself
        // or the max/min by the previous number times the current one
        imax = max(A[i], imax * A[i]);
        imin = min(A[i], imin * A[i]);

        // the newly computed max value is a candidate for our global result
        r = max(r, imax);
    }
    return r;
}
/* Working java solution from approach above
class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] < 0){
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax*nums[i], nums[i]);
            imin = Math.min(imin*nums[i], nums[i]);
            
            max = Math.max(max, imax);
        }
        return max;
    }
}*/
        //Another dp approach similar to the one above
        //by leetcode's compound
        //Here we make use of an array maxherepre and minherepre which exemplifies the
        //dp better than above (but the arrays are not necessary, as seen above)
        //We need to calculate maximum and minimum for every position since a negative 
        //number will make a high number (max) a small number (min), but with another
        //negative could become the biggest number
        //So for every position we calculate the biggest number (previous min and max) multiplied
        //by the current number, and we get the max and min for every position, and then compare it
        //to max so far 
public int maxProduct(int[] A) {
    if (A.length == 0) {
        return 0;
    }
    
    int maxherepre = A[0];
    int minherepre = A[0];
    int maxsofar = A[0];
    int maxhere, minhere;
    
    for (int i = 1; i < A.length; i++) {
        maxhere = Math.max(Math.max(maxherepre * A[i], minherepre * A[i]), A[i]);
        minhere = Math.min(Math.min(maxherepre * A[i], minherepre * A[i]), A[i]);
        maxsofar = Math.max(maxhere, maxsofar);
        maxherepre = maxhere;
        minherepre = minhere;
    }
    return maxsofar;
}


//My ugly solution
//Runtime O(N)
//Memory O(1)
class Solution {
    public int maxProduct(int[] nums) {
        int res=Integer.MIN_VALUE;
        int prevZero=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                if(res==Integer.MIN_VALUE) res=0;
                int subarray=processSubarray(prevZero,i-1,nums);
                prevZero=i+1;
                if(subarray>res)  res=subarray;
                
            }else if(i==nums.length-1){
                int subarray=processSubarray(prevZero,i,nums);
                if(subarray>res)  res=subarray;
                
            }
        }
        return res;
    }
    
    public int processSubarray(int start,int end,int[] nums){
        //System.out.println(start+" "+end);
        int negatives=0;
        for(int i=start;i<=end;i++){
            if(nums[i]<0){
                negatives++;
            }
        }
        if(negatives%2==0){//even negs
            int res=nums[start];
            for(int i=start+1;i<=end;i++){
                res*=nums[i];
            }
            return res;
        }else{//odd negs
            if(negatives==1) negatives=0;
            int currentNegs=negatives;
            //System.out.println("odd "+currentNegs);
            int resL=nums[start];
            if(nums[start]<0) currentNegs--;
            for(int i=start+1;i<=end;i++){
                if(nums[i]<0) {
                    currentNegs--;
                    if(currentNegs<=0) break;
                }
                resL*=nums[i];
            }
        
            currentNegs=negatives;
            int resR=nums[end];
            if(nums[end]<0) currentNegs--;
            for(int i=end-1;i>=start;i--){
                if(nums[i]<0) {
                    currentNegs--;
                    if(currentNegs<=0) break;
                }
                //System.out.println(nums[i]+" by "+resR);
                resR*=nums[i];
            }
            if(resL>resR){
                return resL;
            }else{
                return resR;
            }
        }
    }
}