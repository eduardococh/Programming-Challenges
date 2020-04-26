        //My solution
        //Good runtime of 127ms better than 88.35%
        //Average memory better than 66.67%
class Solution {
    public int longestArithSeqLength(int[] A) {
        HashMap<Integer,ArrayList<Integer>> positions=new HashMap<>();
        int index=0;
        int res=0;
        for(int num:A){
            if(positions.containsKey(num)){
                ///CHECK THIS WIFFDFDFDFDF
                ArrayList temp=positions.get(num);
                temp.add(index);
                positions.put(num,temp);
            }else{
                positions.put(num,new ArrayList<Integer>(Arrays.asList(index)));
            }
            index++;
        }
        for(int i=0;i<A.length;i++){
            for(int j=i+1;j<A.length;j++){
                int difference=A[i]-A[j];
                int temp=getSubsequence(j,difference,A,positions,2);
                if(temp>res) res=temp;
            }
        }
        return res;
    }
    
    private int getSubsequence(int currentIndex,int difference,int[] nums,HashMap<Integer,ArrayList<Integer>> positions,int resSoFar){
        int nextNum=nums[currentIndex]-difference;
        int res=0;
        if(positions.containsKey(nextNum)){
            for(Integer possibleIndex:positions.get(nextNum)){
                if(possibleIndex>currentIndex){
                    int temp=getSubsequence(possibleIndex,difference,nums,positions,resSoFar+1);
                    if(temp>res) res=temp;
                }
            }
        }
        return res>resSoFar?res:resSoFar;
    }
}