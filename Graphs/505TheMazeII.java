class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if(maze==null || maze.length==0 || maze[0].length==0) return 0;
        boolean[][] visited=new boolean[maze.length][maze[0].length];
        return dfs(maze,start,destination,0,visited);
    }
    
    public int dfs(int[][] maze, int[] start, int[] destination,int distance,boolean[][] visited){
        //position 0 is i and 1 is j
        if(start[0]==destination[0] && start[1]==destination[1]) return distance;
        if(visited[start[0]][start[1]]){//we have visited this place
            return -1;
        }
        visited[start[0]][start[1]]=true;
        int shortestDistance=Integer.MAX_VALUE;
        
        //go down
        int i=start[0]+1;
        int j=start[1];
        if(i<maze.length && maze[i][j]==0){
            while(i<maze.length-1 && maze[i+1][j]==0){
                i++;
            }
            //we're in the last empty space
            int down=dfs(maze,new int[]{i,start[1]},destination,distance+(i-start[0]),visited);
            if(down!=-1 && down<shortestDistance) shortestDistance=down;
        }
        
        //go up
        i=start[0]-1;
        j=start[1];
        if(i>=0 && maze[i][j]==0){
            while(i>0 && maze[i-1][j]==0){
                i--;
            }
            //we're in the last empty space
            int up=dfs(maze,new int[]{i,start[1]},destination,distance+(start[0]-i),visited);
            if(up!=-1 && up<shortestDistance) shortestDistance=up;
        }
        
        //go right
        i=start[0];
        j=start[1]+1;
        if(j<maze[0].length && maze[i][j]==0){
            while(j<maze[0].length-1 && maze[i][j+1]==0){
                j++;
            }
            //we're in the last empty space
            int right=dfs(maze,new int[]{start[0],j},destination,distance+(j-start[1]),visited);
            if(right!=-1 && right<shortestDistance) shortestDistance=right;
        }
        
        //go left
        i=start[0];
        j=start[1]-1;
        if(j>=0 && maze[i][j]==0){
            while(j>0 && maze[i][j-1]==0){
                j--;
            }
            //we're in the last empty space
            int left=dfs(maze,new int[]{start[0],j},destination,distance+(start[1]-j),visited);
            if(left!=-1 && left<shortestDistance) shortestDistance=left;
        }
        visited[start[0]][start[1]]=false;
        return shortestDistance==Integer.MAX_VALUE?-1:shortestDistance;
    }
}