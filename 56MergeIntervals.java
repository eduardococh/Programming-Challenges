		//My solution
		//Big surprise as a great algorithm (but complex?)
		//Runtime of 
class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==0) return new int[][]{};
        if(intervals.length==1) return intervals;
        
        ArrayList<int[]> intervalsList=new ArrayList<int[]>();
        int[] currentInterval=intervals[0];
        intervalsList.add(currentInterval);
        
        for(int i=1;i<intervals.length;i++){
            currentInterval=intervals[i];
            
            int j=0;
            while(j<intervalsList.size()){
                boolean isNewInterval=true;
                int intervalToTest[]=intervalsList.get(j);
                //If first or second of current interval is in interval to test, this interval belongs to 
                //another one
                if(((currentInterval[0]>=intervalToTest[0] && currentInterval[0]<=intervalToTest[1]) 
                   ||
                   (currentInterval[1]>=intervalToTest[0] && currentInterval[1]<=intervalToTest[1] ))
                  ||
                    ((intervalToTest[0]>=currentInterval[0] && intervalToTest[0]<=currentInterval[1]) 
                   ||
                   (intervalToTest[1]>=currentInterval[0] && intervalToTest[1]<=currentInterval[1] ))){
                    
                    isNewInterval=false;
                    //Lower bound can only be lower than lower bound, same with high bound
                    if(currentInterval[0]<intervalToTest[0]){
                        //intervalsList.get(j)[0]=currentInterval[0];
                    }else{
                        currentInterval[0]=intervalToTest[0];
                    }
                    if(currentInterval[1]>intervalToTest[1]){
                        intervalsList.get(j)[1]=currentInterval[1];
                    }else{
                        currentInterval[1]=intervalToTest[1];
                    }
                }
                
                if(isNewInterval==false){
                    //System.out.println("we remove "+intervalsList.get(j)[0]+" "+intervalsList.get(j)[1]);
                    intervalsList.remove(j);
                }else{
                    j++;
                }
            }
            intervalsList.add(currentInterval);
        }
        
        int[][] finalRes=new int[intervalsList.size()][2];
        for(int i=0;i<intervalsList.size();i++){
            finalRes[i][0]=intervalsList.get(i)[0];
            finalRes[i][1]=intervalsList.get(i)[1];
        }
        
        return finalRes;
    }
}