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