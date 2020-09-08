    //My solution 
    //Simple 
    
class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0) return 0;
        int res=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    int local=searchForClosestRotten(i,j,grid);
                    if(local==0) return -1;//this fresh apple can't rot
                    if(local>res) res=local;
                }
                
            }
        }
        return res;
    }
    
    public int searchForClosestRotten(int stI,int stJ,int[][] grid){
        //it should be guaranteed that any position here is a good apple
        Queue<List<Integer>> toCheck=new LinkedList<List<Integer>>();
        toCheck.add(new ArrayList<Integer>(Arrays.asList(stI,stJ,0)));
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        //in BFS its guaranteed that the first rotten apple is the result
        while(toCheck.size()>0){
            List<Integer> currentPosition=toCheck.poll();
            int i=currentPosition.get(0);
            int j=currentPosition.get(1);
            int nextMinute=currentPosition.get(2)+1;
            visited[i][j]=true;
            if(i-1>=0){
                if(!visited[i-1][j]){
                    if(grid[i-1][j]==2) return nextMinute;
                    if(grid[i-1][j]==1) toCheck.add(new ArrayList<Integer>(Arrays.asList(i-1,j,nextMinute)));
                }
            }
            if(j-1>=0){
                if(!visited[i][j-1]){
                    if(grid[i][j-1]==2) return nextMinute;
                    if(grid[i][j-1]==1) toCheck.add(new ArrayList<Integer>(Arrays.asList(i,j-1,nextMinute)));
                }
            }
            if(i+1<grid.length){
                if(!visited[i+1][j]){
                    if(grid[i+1][j]==2) return nextMinute;
                    if(grid[i+1][j]==1) toCheck.add(new ArrayList<Integer>(Arrays.asList(i+1,j,nextMinute)));
                }
            }
            if(j+1<grid[0].length){
                if(!visited[i][j+1]){
                    if(grid[i][j+1]==2) return nextMinute;
                    if(grid[i][j+1]==1) toCheck.add(new ArrayList<Integer>(Arrays.asList(i,j+1,nextMinute)));
                }
            }
        }
        //we didnt found a rotten apple
        return 0;
    }
}