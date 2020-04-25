        //My linear solution
        //Terrible runtime of 309ms O(W*T) where W is the number of packages and T the difference
        //between the biggest package lenght and the total sum of all the packages

class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int res=weights.length;
        int total=0,max=0;
        for(int n:weights){
            if(n>max) max=n;
            total+=n;
        }	
        for(int i=max;i<=total;i++){
            int nDays=getDays(i,weights,D);
            if(nDays<=D){
                return i;
            }
        }
        return res;
    }
    private int getDays(int weight,int w[],int D){
		int days=1;
		int currentPackage=0;
		int weightSoFar=0;
		while(currentPackage<w.length){
            if(weightSoFar+w[currentPackage]<=weight){
                weightSoFar+=w[currentPackage];
            }else{
                if(days>D) return Integer.MAX_VALUE;
                days++;
                weightSoFar=w[currentPackage];
            }
            currentPackage++;
        }
        return days;
    }

}

class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int res=weights.length;
        int total=0,max=0;
        for(int n:weights){
            if(n>max) max=n;
            total+=n;
        }	
        int low=max;
        int high=total;
        while(low<high){//binary searching for the lowest
            int mid=high-(high-low)/2;
            int nDays=getDays(mid,weights,D);
            if(nDays<=D){//right amount of days, could we go lower?
                int test=getDays(mid-1,weights,D);
                if(mid>max && getDays(mid-1,weights,D)==Integer.MAX_VALUE){//we're the lowest value possible withing D days
                    return mid;
                }else{
                    high=mid-1;
                }
            }else{//taking too long, increase weight capacity
                low=mid+1;
            }
        }
        return res;
    }
    private int getDays(int weight,int w[],int D){
		int days=1;
		int currentPackage=0;
		int weightSoFar=0;
		while(currentPackage<w.length){
            if(weightSoFar+w[currentPackage]<=weight){
                weightSoFar+=w[currentPackage];
            }else{
                days++;
                if(days>D) return Integer.MAX_VALUE;
                weightSoFar=w[currentPackage];
            }
            currentPackage++;
        }
        return days;
    }

}