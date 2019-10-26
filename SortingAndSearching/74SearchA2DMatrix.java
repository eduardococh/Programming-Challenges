class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low=0,high=matrix.length-1;
        int middle=low+(high-low)/2;
        int len=matrix.length;
                //if im bigger than target go lower
        while(low<high && (matrix[middle][0]>target ||
                //if im smaller than target and next is also smaller (we can go up)
              middle+1<len && matrix[middle][0]<target && matrix[middle+1][0]<=target)){
            System.out.println("middle is in "+middle+" high "+high+" low "+low);
            if(matrix[middle][0]<=target && middle+1<len && (matrix[middle+1][0]>target )) break;
            if(matrix[middle][0]>target){
                high=middle-1;
            }else{
                low=middle+1;
            }            
            middle=(low+(high-low))/2;
        }
        System.out.println("middle is in "+middle);
        return false;
    }
}