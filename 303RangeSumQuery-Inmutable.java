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

class NumArray {

    private int[] data;

    public NumArray(int[] nums) {
        data = nums;
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += data[k];
        }
        return sum;
    }
}