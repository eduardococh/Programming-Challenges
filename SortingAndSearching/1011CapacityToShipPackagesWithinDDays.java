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