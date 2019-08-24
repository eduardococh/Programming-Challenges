class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0){
            return 0;
        }
        int max=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='1'){
                    
                    //System.out.println("were in "+i+" "+j+" "+matrix[i][j]);
                    max=solvePosition(max,matrix,i,j);
                    //System.out.println("Max is "+max);
            
                    /*for(int k=0;k<matrix.length;k++){
                        for(int l=0;l<matrix[0].length;l++){
                            System.out.print(matrix[k][l]);
                        }
                        System.out.println();
                    }*/
                }
            }
        }
        return max*max;
    }
    
    private int solvePosition(int max,char[][] matrix,int i,int j){
        int currentMax=1;
        boolean addLayer=true;
        while(addLayer){
            //Are we in bounds?
            if(i+currentMax>=matrix.length || j+currentMax>=matrix[0].length) break;
            
            for(int k=0;k<=currentMax;k++){
                //vertical check
                //System.out.println("v checking "+(i+currentMax)+" "+(j+k)+" "+matrix[i+currentMax][j+k]);
                if(matrix[i+currentMax][j+k]=='0'){
                    addLayer=false;
                    /*for(int l=i+currentMax;l>=i;l--){
                        matrix[l][j+k]='0';
                    }*/
                }
                
                //horizontal check
                //System.out.println("h checking "+(i+k)+" "+(j+currentMax)+" "+matrix[i+k][j+currentMax]);
                if(matrix[i+k][j+currentMax]=='0'){
                    addLayer=false;
                    /*for(int l=j+currentMax;l>=j;l--){
                        matrix[i+k][l]='0';
                    }*/
                }
            }
            if(addLayer){
                currentMax++;
            }
        }
        if(currentMax>max){
            return currentMax;
        }else{
            return max;    
        }
    }
}