        //My iterative solution
        //It is long at 40 lines but I believe is really clear and can
        //be understood with just a view
        //Amazing runtime 0ms O(N*M) better than 100%
        //(it appears all solutions achieve 0ms)
        //Amazing memory better than 100% O(1)
        //the fix at the end of removing is valid I believe, another possible
        //fix would have been an intermediate if as shown in comment below
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result=new ArrayList<Integer>();
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return result;
        int top=0,bottom=matrix.length-1;
        int left=0,right=matrix[0].length-1;
        while(top<=bottom && left<=right){
            int columnIndex=left;
            while(columnIndex<=right){
                result.add(matrix[top][columnIndex]);
                columnIndex++;
            }
            top++;
            int rowIndex=top;
            while(rowIndex<=bottom){
                result.add(matrix[rowIndex][right]);
                rowIndex++;
            }
            right--;
            //possible fix to avoid removing items at the end
            //if(top<=bottom && left<=right){
            columnIndex=right;
            while(columnIndex>=left){
                result.add(matrix[bottom][columnIndex]);
                columnIndex--;
            }
            bottom--;
            rowIndex=bottom;
            while(rowIndex>=top){
                result.add(matrix[rowIndex][left]);
                rowIndex--;
            }
            left++;
        }
        while(result.size()>(matrix.length)*(matrix[0].length)){
            result.remove(result.size()-1);
        }
        return result;
    }
}
        
        
        //My recursive solution
		//Amazing runtime at 0ms better than 100% O(m*n) (almost all or all have same rt)
		//Amazing memory at 34.4mb better than 99.62% 
		//A complex solution, at least compared with the iterative ones
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result=new ArrayList<Integer>();
        if(matrix.length==0 || matrix[0].length==0) return result;
        return spiral(matrix,result,0,0,matrix[0].length-1,matrix.length-1);
    }
    
    public List<Integer> spiral(int[][] matrix,List<Integer> result,int startX,int startY,int endX, int endY){
        
        //System.out.println("Hello "+endX+" "+startX+" "+endY+" "+startY);
        if(endX<startX || endY<startY) return result; 
        //
        for(int i=startX;i<=endX;i++){
            result.add(matrix[startY][i]);
        }
        for(int i=startY+1;i<endY;i++){
            result.add(matrix[i][endX]);
        }
        if(endY!=startY){
            for(int i=endX;i>=startX;i--){
                result.add(matrix[endY][i]);
            }    
        }
        if(endX!=startX){
            for(int i=endY-1;i>startY;i--){
                result.add(matrix[i][startY]);
            }
        }
        
        
        return spiral(matrix,result,startX+1,startY+1,endX-1,endY-1);
    }
}

		//Leetcode's layer by layer solution
		//Same runtime and memory as mine
		//Almost same approach, but they do it iterativetely
		//Same difficulty
class Solution {
    public List < Integer > spiralOrder(int[][] matrix) {
        List ans = new ArrayList();
        if (matrix.length == 0)
            return ans;
        int r1 = 0, r2 = matrix.length - 1;
        int c1 = 0, c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            for (int c = c1; c <= c2; c++) ans.add(matrix[r1][c]);
            for (int r = r1 + 1; r <= r2; r++) ans.add(matrix[r][c2]);
            if (r1 < r2 && c1 < c2) {
                for (int c = c2 - 1; c > c1; c--) ans.add(matrix[r2][c]);
                for (int r = r2; r > r1; r--) ans.add(matrix[r][c1]);
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return ans;
    }
}

        //Iterative solution from mock interview
        //Clear code that worked almost at first time with minimal improvements
        //Amazing runtime of 0ms
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result=new ArrayList<Integer>();
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return result;
        int startRow=0;
        int endRow=matrix.length-1;
        int startColumn=0;
        int endColumn=matrix[0].length-1;
        while(startRow<=endRow && startColumn<=endColumn){

            for(int i=startColumn;i<=endColumn;i++){
                result.add(matrix[startRow][i]);
            }
            startRow++;

            for(int i=startRow;i<=endRow;i++){
                    result.add(matrix[i][endColumn]);
            }
            endColumn--;

            if(startRow>endRow || startColumn>endColumn){
                break;
            }

            for(int i=endColumn;i>=startColumn;i--){
                result.add(matrix[endRow][i]);
            }
            endRow--;


            for(int i=endRow;i>=startRow;i--){
                result.add(matrix[i][startColumn]);
            }
            startColumn++;
        }
        return result;
    }
}