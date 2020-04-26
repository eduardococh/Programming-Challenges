        //Same problem as LC410
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

        //Binary Search Solution
        //Average runtime 9ms better than 43.2% O(Log(T)*W)
        //we execute W at most Log(T) times, where T is total sum of all packages
        //Good memory better than 76.92%
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
            int mid=low+(high-low)/2;
            int nDays=getDays(mid,weights,D);
            if(nDays<=D){//right amount of days, could we go lower?
                high=mid;
            }else{//taking too long, increase weight capacity
                low=mid+1;
            }
        }
        return low;
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