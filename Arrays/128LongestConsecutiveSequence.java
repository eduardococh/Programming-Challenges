class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        
        HashMap<Integer,Integer> headers=new HashMap<Integer,Integer>();
        int longestSoFar=0;
        
        for(int num:nums){
            boolean singleEntry=true;
            
            if(headers.containsKey(num+1)){
                //System.out.println("single into "+num);
                singleEntry=false;
                headers.put(num,headers.get(num+1));
                headers.put(headers.get(num+1),num);
                if(Math.abs(headers.get(num)-num)>1){
                    headers.remove(num+1);
                }
                if(Math.abs(headers.get(num)-num)>longestSoFar){
                    longestSoFar=Math.abs(headers.get(num)-num);
                }
            }
            
            if(headers.containsKey(num-1)){
                singleEntry=false;
                if(headers.containsKey(num)){//Im joining two sequences
                    //System.out.println("joining at "+num);
                    int header1=headers.get(num-1);
                    int header2=headers.get(num);//will get the end of the sequence we just formed above
                    if(Math.abs(header1-header2)>longestSoFar){
                        longestSoFar=Math.abs(header1-header2);
                    }
                    headers.remove(num-1);
                    headers.remove(num);
                    headers.put(header1,header2);
                    headers.put(header2,header1);
                    
                }else{//end of a sequence
                    //System.out.println("single into "+num);
                    headers.put(num,headers.get(num-1));
                    headers.put(headers.get(num-1),num);
                    if(Math.abs(headers.get(num)-num)>1){
                        headers.remove(num-1);
                    }
                    if(Math.abs(headers.get(num)-num)>longestSoFar){
                        longestSoFar=Math.abs(headers.get(num)-num);
                    }
                }
            }
            
            if(singleEntry){
               //System.out.println("only in "+num);
               headers.put(num,num); 
            }
            
        }
        return longestSoFar+1;
    }
}