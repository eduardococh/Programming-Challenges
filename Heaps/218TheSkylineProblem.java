        //Solution from sample 3ms solution
        //AMAZING runtime 3ms better than 99.97% O(N) since we loop every building once
        //Amazing memory better than ~98% O(N) since heightHeap could be N length
        //Comments with triple slash we're included in solution
        //Complex solution, worth reading all comments to understand it
        //The big picture is that is adds the tallest building that it finds to result, then if a building is 
        //smaller than the tallest building it will be added to the heap, when a new tallest building or a building
        //completely separated from a block appears it empties the heap and adds all their points, including the
        //imaginary building MIN,MAX,0 for some cases, it repeats this for all buildings and after the for loop
        //if the heap still contains buildings it empties it and finally it adds a final 0 if prev height
        //is not 0 (as prev usuall)
class Solution {

public List<List<Integer>> getSkyline(int[][] buildings) {
        //ENTRY FORMAT Left, Right, Height

        //Create result
        List<List<Integer>> res = new ArrayList<>();

        //Create pq ordered by height from taller to smaller, if heights are equal then by left point
        //from smaller to highest left 
        PriorityQueue<int[]> heightHeap = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return a[2] == b[2] ? a[0] - b[0] : b[2] - a[2];
            } 
        });
        
        //previous building, left is the min value and right is the max value, height of 0
        //this variable should be named previous tallest, as it only save's the tallest building at every point in
        //the skyline for every block or the last building after emptying the heap
        int[] pre = new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, 0};

        //For every building
        for(int[] b : buildings) {
            
            //While heap is not empty and current building (b) left is smaller than pre right (that means
            //this new building is totally separated from the previous tallest)
            //This while executes every time a tallest building does not overlap with the previous talles building
            //every time it executes is creates the skyline with the buildings smaller than both pre and b
            //and finally sets pre as the current heighest
            while(!heightHeap.isEmpty() && b[0] > pre[1]) { /// totally separated
                //get me the highest building in heap
                int[] curHeighest = heightHeap.poll();
                //if this new building right is equal or smaller than to previous building right continue
                if(curHeighest[1] <= pre[1]) continue;
                //if this new building right is bigger than previous building right it means it extends
                //the skyline, add the previous building right and current building height
                res.add(Arrays.asList(pre[1], curHeighest[2])); 
                //currentHeighest is now previous building
                pre = curHeighest;
            }

            //Next condition is important, if the building it tallest than previous building it will be automatically
            //added to our response, if it is smaller it will NOT be added to solution here, it will be added to 
            //solution in the while for the end of a block, and also it will not be considered previous building
            //previous building's are only the tallest, if there's a tall building and next 3 are smaller those three
            //will be added to heap, if the fourth building is taller it will be the new prev building
            //then in the end of the block 
            
            //if current building height is bigger than previous building height
            if(b[2] > pre[2]) {
                
                //if current building left is equal to previous building left
                //added "&& res.length()>0" to original solution since remove breaks with -2147483648 in first building
                if(b[0] == pre[0] && res.length()>0) { /// we always make sure pre is the last element in the res
                    /// if b[0] and pre[0] overlap but b is higher than pre, then we track the point in b not pre
                    //this is necessary since input is not ordered by height, only by left
                    //so two or more points with the same left but unordered height could appear and break
                    res.remove(res.size() - 1);
                }
                
                //we add current building left and height
                res.add(Arrays.asList(b[0], b[2])); /// highest point possibly has a pos in result;
                
                //if current building right is smaller than previous building right IMPORTANTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT
                //previous building will continue to right, add it to heap, because then pre will be us
                if(b[1] < pre[1]) {
                    //we add PREVIOUS building, not current 
                    heightHeap.offer(pre); ///prev building covers more length, need to add into heightheap for future.
                }
                pre = b;
            }
            //else, current building height is equal or smaller than previous building height
                //if current building right is bigger than previous building right
            else if(b[1] > pre[1]) {
                //current building height is same as previous building IMPORTANTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT
                if(b[2] == pre[2]) {
                    //set previous building right to current building right (extending prev building right)
                    pre[1] = b[1];
                }
                //else, current building height is not the same than the previous building (so it is smaller)
                else {
                    heightHeap.offer(b);
                }
            }//else current building right is smaller or equal than previous building, and is less height
             //it means current building is totally covered by previous, nothing to add to skyline
        }

        //we looped through all the buildings and our heap is not empty
        while(!heightHeap.isEmpty()) {
            //get the tallest building, if there's a tie get the leftmost tallest
            int[] cur = heightHeap.poll();
            //if current building right is smaller or equal than previous building continue
            if(cur[1] <= pre[1]) continue;
            //if current building right is bigger than previous right
            //add to result previous right (building end) with current height
            res.add(Arrays.asList(pre[1], cur[2]));
            pre = cur;
        }
        
        //if previous building height is not 0, add their right with height of 0
        if(pre[2] > 0) {
            res.add(Arrays.asList(pre[1], 0));
        }
        return res;
    }
}



        //My attempt at a solution that does not work
        //With more work it will probably do
class Solution{
    
    class Building implements Comparable<Building>{
        int left;
        int right;
        int height;
        
        public Building(int left,int right,int height){
            this.left=left;
            this.right=right;
            this.height=height;
        }
        
        @Override
        public int compareTo(Building build) {
            //increasing order this,other (a,b)
            //decreasiong order other,this (b,a)
            if(this.left==build.left){
                return build.height-this.height;
            }else{
                return this.left-build.left;
            }
        }
    }
    
    public List<List<Integer>> getSkyline(int[][] buildings) {
        //Left,Right,Height
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        int len=buildings.length;
        int blockEnd=buildings[0][1];
        //Comparator<Building> myComp=(a, b)->Integer.valueOf(a.height)-Integer.valueOf(b.height);
        /*Comparator<Building> myComp = new Comparator<Building>() {
            @Overrid
            public int compare(Building e1, Building e2) {
                return (int) e1.getHeight() - e2.getHeight();
            }
        };*/
        
        PriorityQueue<Building> block=new PriorityQueue<>();
        block.add(new Building(buildings[0][0],buildings[0][1],buildings[0][2]));
        for(int i=1;i<len;i++){
            //System.out.println(buildings[i][0]);
            if(buildings[i][0]<=blockEnd){
                Building temp=new Building(buildings[i][0],buildings[i][1],buildings[i][2]);
                block.add(temp);
                if(buildings[i][1]>blockEnd) blockEnd=buildings[i][1];
            }else{
                craftSkyline(block,result);
                blockEnd=buildings[i][1];
                block=new PriorityQueue<Building>();
                block.add(new Building(buildings[i][0],buildings[i][1],buildings[i][2]));
            }
        }
        craftSkyline(block,result);
        return result;
    }
    
     public void craftSkyline(PriorityQueue<Building> block,List<List<Integer>> result){
        //Building leftmostBuilding=block.poll();
        //int currentHeight=highestBuilding.height;
        //result.add(new ArrayList<Integer>(Arrays.asList(highestBuilding.left,currentHeight)));
        while(!block.isEmpty()){
            //System.out.println(block.poll().height+" height");
            highestBuilding=block.poll();
            if(highestBuilding.left<leftmost){
                result.add(0,new ArrayList<Integer>(Arrays.asList(leftmost,highestBuilding.height)));
                leftmost=highestBuilding.left;
                result.add(0,new ArrayList<Integer>(Arrays.asList(leftmost,highestBuilding.height)));
            }
        }
    }
}






