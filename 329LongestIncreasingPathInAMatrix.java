class Solution {
    //Code with debugs for viewing process of matrix filling
    static int longest[][];
    
    
    public int longestIncreasingPath(int[][] matrix) {
        int longestSec=0;
        int answer=0;
        longest=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                int temp=findPath(matrix,i,j,0);
                if(temp>answer){
                    answer=temp;
                }
            }
        }
        return ++answer;
    }
    
    public static int findPath(int[][] mat, int i, int j,int answer){
        int tempAnswer=answer;
        //Up 
        if(i>0 && mat[i-1][j]>mat[i][j]){
            //System.out.println("Im in up "+i+" "+j+" "+(answer+1));
            int temp;
            if(longest[i-1][j]!=0){
                temp=tempAnswer+longest[i-1][j];
            }else{
                temp=findPath(mat,i-1,j,tempAnswer);
                temp++;
                longest[i-1][j]=temp;
                System.out.println();
                for(int m=0;m<longest.length;m++){
                    for(int n=0;n<longest[0].length;n++){
                        System.out.print(longest[m][n]+",");
                    }
                    System.out.println();
                }
                System.out.println();
            }
            if(temp>answer){
                answer=temp;
            }
        }
        //Down
        if(i<mat.length-1 && mat[i+1][j]>mat[i][j]){
            //System.out.println("Im in down "+i+" "+j+" "+(answer+1));
            int temp;
            if(longest[i+1][j]!=0){
                temp=tempAnswer+longest[i+1][j];
            }else{
                temp=findPath(mat,i+1,j,tempAnswer);
                temp++;
                longest[i+1][j]=temp;
                System.out.println();
                for(int m=0;m<longest.length;m++){
                    for(int n=0;n<longest[0].length;n++){
                        System.out.print(longest[m][n]+",");
                    }
                    System.out.println();
                }
                System.out.println();
            }
            if(temp>answer){
                answer=temp;
            }
        }
        //Left
        if(j>0 && mat[i][j-1]>mat[i][j]){
            //System.out.println("Im in left "+i+" "+j+" "+(answer+1));
            int temp;
            if(longest[i][j-1]!=0){
                temp=tempAnswer+longest[i][j-1];
            }else{
                temp=findPath(mat,i,j-1,tempAnswer);
                temp++;
                longest[i][j-1]=temp;
                System.out.println();
                for(int m=0;m<longest.length;m++){
                    for(int n=0;n<longest[0].length;n++){
                        System.out.print(longest[m][n]+",");
                    }
                    System.out.println();
                }
                System.out.println();
            }
            if(temp>answer){
                answer=temp;
            }
        }
        //Right
        if(j<mat[0].length-1 && mat[i][j+1]>mat[i][j]){
            //System.out.println("Im in right "+i+" "+j+" "+(answer+1));
            int temp;
            if(longest[i][j+1]!=0){
                temp=tempAnswer+longest[i][j+1];
            }else{
                temp=findPath(mat,i,j+1,tempAnswer);
                temp++;
                longest[i][j+1]=temp;
                System.out.println();
                for(int m=0;m<longest.length;m++){
                    for(int n=0;n<longest[0].length;n++){
                        System.out.print(longest[m][n]+",");
                    }
                    System.out.println();
                }
                System.out.println();
            }
            if(temp>answer){
                answer=temp;
            }
        }
        return answer;
    }
}
/*
class HelloWorld {

    int longest[][];

	public static void main(String args[]) {
		
	}

    public static int findPath(int[][] mat, int i, int j,int answer){
        //Up 
        if(i>0 && mat[i-1][j]>mat[i][j]){
            if(longest[i-1][j]!=0){
                int temp=answer+longest[i-1][j]
            }else{
                int temp=findPath(mat,i-1,j,answer++);
            }
            if(temp>answer){
                answer=temp;
            }
        }
        //Down
        if(i<mat.length-1 && mat[i+1][j]>mat[i][j]){
            int temp=findPath(mat,i+1,j,answer++);
            if(temp>answer){
                answer=temp;
            }
        }
        //Left
        if(j>0 && mat[i][j-1]>mat[i][j]){
            
            int temp=findPath(mat,i,j-1,answer++);
            if(temp>answer){
                answer=temp;
            }
        }
        //Right
        if(j<mat[0].length-1 && mat[i][j+1]>mat[i][j]){
            int temp=findPath(mat,i,j+1,answer++);
            if(temp>answer){
                answer=temp;
            }
        }
        return answer;
    }
}*/
