        //My solution
        //Search for the row linear time and do binary search inside row
        //Amazing runtime better than 100% O(N + Log M)
        //Terrible memory better than only 6.06%
        //Ok solution, not better 
        //A obvious improvement is to pass if(==) to the end, so first ask for < 
        //then ask for > and if is none of those it is equal
        //REMEMBER YOU CAN USE Arrays.binarySearch(arr,key);
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return false;
        int row=0;
        int len=matrix.length;

        for(int i=0;i<len;i++){
            if(matrix[row][0]>target){
                row--;
                break;
            }else{
                row++;
            }
        }
        if(row==len) row--;
        if(row<0) row=0;

        int low=0,high=matrix[0].length;
        while(low<=high && low<matrix[0].length){
            int middle=low+(high-low)/2;
            if(matrix[row][middle]==target) return true;
            if(matrix[row][middle]>target){
                high=middle-1;
            }else{
                low=middle+1;
            }
        }
        return false;
    }
}

        //Double binary search solution based on leetcode's Oldman09
        //with a better formula
        //Do a binary search on rows and then on columns
        //Search row method is a typical binary search
        //Search column is a little different, you have to ask
        //if the number is between first and last position
        //of the corresponding row
class Solution {
    public boolean searchMatrix(int[][] matrix, int target){
        if(matrix.length == 0 || matrix[0].length==0) return false;
        int top = 0;
        int down = matrix.length - 1;
        int col = matrix[0].length - 1;
        while(top <= down){
            int mid = down + (top - down) / 2;
            //it takes O(logM) to find the row that has target
            if(matrix[mid][0] <= target && matrix[mid][col] >= target){
                return searchRow(matrix,mid,target); //O(logN)
            }
            if(matrix[mid][col] < target){
                top = mid + 1;
            }
            if(matrix[mid][0] > target){
                down = mid -1;
            }
        }
        return false;
    }
    
    public boolean searchRow(int[][] matrix, int rowIndex, int target){
        int left = 0;
        int right = matrix[rowIndex].length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(matrix[rowIndex][mid] < target){
                left = mid + 1;
            }else if(matrix[rowIndex][mid] > target){
                right = mid - 1;
            }else{
                return true;
            }
        }
        return false;
    }
}