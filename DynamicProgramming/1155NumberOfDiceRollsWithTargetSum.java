//My brute force NOT solution
//Time limit exceeded
//Horrible runtime O(D^F)
//Memory of O(D)
class Solution {
    public int numRollsToTarget(int d, int f, int target) {
        int values[]=new int[d];
        Arrays.fill(values,1);
        return bruteForceSolution(values,f,target,0);
    }
    
    public int bruteForceSolution(int[] values,int f,int target,int dice){
        if(dice>=values.length){
            //System.out.println(values[0]+" r "+values[1]);
            if(dicesSum(values)==target){
                return 1;
            }else{
                return 0;
            }
        }
        int res=0;
        for(int i=1;i<=f;i++){
            res+=bruteForceSolution(values,f,target,dice+1);
            values[dice]=i+1;
        }
        values[dice]=1;
        return res;
    }
    
    public int dicesSum(int values[]){
        int res=0;
        for(int num:values){
            res+=num;
        }
        return res;
    }
}