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


		//Simulation of the spiral approach by leetcode
		//This implementation does not seem the clearest to me but
		//i should try to do the simulation myself
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List ans = new ArrayList();
        if (matrix.length == 0) return ans;
        int R = matrix.length, C = matrix[0].length;
        boolean[][] seen = new boolean[R][C];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int r = 0, c = 0, di = 0;
        for (int i = 0; i < R * C; i++) {
            ans.add(matrix[r][c]);
            seen[r][c] = true;
            int cr = r + dr[di];
            int cc = c + dc[di];
            if (0 <= cr && cr < R && 0 <= cc && cc < C && !seen[cr][cc]){
                r = cr;
                c = cc;
            } else {
                di = (di + 1) % 4;
                r += dr[di];
                c += dc[di];
            }
        }
        return ans;
    }
}