class NumArray {

    private int array[];
    
    public NumArray(int[] nums) {
        array=nums;
    }
    
    public int sumRange(int i, int j) {
        int res=0;
        for(int k=i;k<=j;k++){
            res+=array[k];
        }
        return res;
    }
}