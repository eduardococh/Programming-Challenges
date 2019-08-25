class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result=new ArrayList<Integer>();
        Arrays.sort(nums);
        int cont=1,i=0;
        while(i<nums.length){
            while(cont<nums[i]){
                result.add(cont);
                cont++;
            }
            while(i<nums.length && cont==nums[i]){
                i++;
            }
            cont++;
        }
        while(cont<=nums.length){
            result.add(cont);
            cont++;
        }
        return result;
    }
}