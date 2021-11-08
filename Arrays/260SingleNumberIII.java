//My solution using hashmap
//Bit manipulation can solve this O(1) memory but that is not relevant for interviews (mostly)
//Bad runtime better tha 38% O(N)
//Bad memory better than 35% O(N)
class Solution {
    public int[] singleNumber(int[] nums) {
        Set<Integer> set=new HashSet<Integer>();
        int[] res=new int[2];
        for(int num:nums){
            if(set.contains(num)){
                set.remove(num);
            }else{
                set.add(num);
            }
        }
        int i=0;
        for(Integer num:set){
            res[i++]=num;
        }
        return res;
    }
}