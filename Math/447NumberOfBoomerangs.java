class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int result=0;
        double[][] distances=new double[points.length*points.length][3];
        int index=0;
        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                distances[index][0]=Math.sqrt(Math.pow(Math.abs(points[i][0]-points[j][0]),2)+Math.pow(Math.abs(points[i][1]-points[j][1]),2));
                //System.out.println(distances[index][0]);
                distances[index][1]=i;
                distances[index][2]=j;
                index++;
            }
        }
        
        for(int i=0;i<index;i++){
            for(int j=0;j<index;j++){
                if(i==j) continue;
                if(distances[i][0]==distances[j][0] &&
                  (distances[i][1]==distances[j][1] || distances[i][2]==distances[j][2] || distances[i][2]==distances[j][1] || distances[i][1]==distances[j][2])){
                    result++;
                }
            }
        }
        /*for(int i=0;i<points.length;i++){
            for(int j=0;j<points.length;j++){
                for(int k=0;k<points.length;k++){
                    if(i==j || j==k || k==i) continue;
                    double pointIJ=(Math.sqrt(Math.pow(Math.abs(points[i][0]-points[j][0]),2)+Math.pow(Math.abs(points[i][1]-points[j][1]),2)));
                    double pointIK=(Math.sqrt(Math.pow(Math.abs(points[i][0]-points[k][0]),2)+Math.pow(Math.abs(points[i][1]-points[k][1]),2)));
                    //System.out.println(" "+pointIJ);
                    //System.out.println(" "+pointIK);
                    if(pointIJ==pointIK){
                        //System.out.println("i "+i+" j "+j+" k "+k);
                        result++;
                    }
                }
            }    
        }*/
        return result;
    }
}