class Solution {
    public int thirdMax(int[] nums) {
        int firstM=Integer.MIN_VALUE,secondM=Integer.MIN_VALUE,thirdM=Integer.MIN_VALUE;
        HashSet<Integer> numSet=new HashSet<Integer>();
        int diffNums=0;
        for(int num:nums){
            if(!numSet.contains(num)){
                diffNums++;
                if(num>firstM){
                    thirdM=secondM;
                    secondM=firstM;
                    firstM=num;
                }else if(num>secondM){
                    thirdM=secondM;
                    secondM=num;
                }else if(num>thirdM){
                    thirdM=num;
                }
                numSet.add(num);
            }
        }
        if(diffNums<3){
            return firstM;
        }
        return thirdM;
    }
}