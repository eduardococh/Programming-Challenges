//My HashMap sequence building approach
//Runtime O(N) 45ms better than 43.83%
//Memory O(N) better than 78%

//ISSUES, I did not analize the problem well at the beggining (like so many times)
//didn-t know we would have repeated numbers OR negatives, which change the algorithm and made me do a suboptimal solution
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        
        HashMap<Integer,Integer> headers=new HashMap<Integer,Integer>();
        int longestSoFar=0;
        
        for(int num:nums){
            boolean singleEntry=true;
            if(headers.containsKey(num)) continue;
            
            if(headers.containsKey(num+1) && headers.get(num+1)<Integer.MAX_VALUE){
                singleEntry=false;
                headers.put(num,headers.get(num+1));
                headers.put(headers.get(num+1),num);
                if(Math.abs(headers.get(num)-num)>1){
                    headers.put(num+1,Integer.MAX_VALUE);
                }
                if(Math.abs(headers.get(num)-num)>longestSoFar){
                    longestSoFar=Math.abs(headers.get(num)-num);
                }
            }
            
            if(headers.containsKey(num-1) && headers.get(num-1)<Integer.MAX_VALUE){
                singleEntry=false;
                if(headers.containsKey(num) && headers.get(num)<Integer.MAX_VALUE){//Im joining two sequences
                    int header1=headers.get(num-1);
                    int header2=headers.get(num);//will get the end of the sequence we just formed above
                    if(Math.abs(header1-header2)>longestSoFar){
                        longestSoFar=Math.abs(header1-header2);
                    }
                    headers.put(num-1,Integer.MAX_VALUE);
                    headers.put(num,Integer.MAX_VALUE);
                    headers.put(header1,header2);
                    headers.put(header2,header1);
                    
                }else{//end of a sequence
                    headers.put(num,headers.get(num-1));
                    headers.put(headers.get(num-1),num);
                    if(Math.abs(headers.get(num)-num)>1){
                        headers.put(num-1,Integer.MAX_VALUE);
                    }
                    if(Math.abs(headers.get(num)-num)>longestSoFar){
                        longestSoFar=Math.abs(headers.get(num)-num);
                    }
                }
            }
            
            if(singleEntry){
               headers.put(num,num); 
            }
            
        }
        return longestSoFar+1;
    }
}