		//My solution
		//Big surprise as a great algorithm (but complex?) took me long to make
		//Runtime of 2ms better than 99.88% 
		//Memory of o(n) and 38mb better than 99%
		//Good choice to go
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

		//Solution using sorting
		//Sort by first index and then just run in o(n)
		//Interesting sorting method using lambda in array sort
		//Bad runtime at 37 ms better than only 34
		//Good memory at 38.mb better than 99.21
class Solution {
	public int[][] merge(int[][] intervals) {
		if (intervals.length <= 1)
			return intervals;

		// Sort by ascending starting point
		Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

		List<int[]> result = new ArrayList<>();
		int[] newInterval = intervals[0];
		result.add(newInterval);
		for (int[] interval : intervals) {
			if (interval[0] <= newInterval[1]) // Overlapping intervals, move the end if needed
				newInterval[1] = Math.max(newInterval[1], interval[1]);
			else {                             // Disjoint intervals, add the new interval to the list
				newInterval = interval;
				result.add(newInterval);
			}
		}

		return result.toArray(new int[result.size()][]);
	}
}