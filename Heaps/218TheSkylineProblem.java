        //Solution from sample 3ms solution
        //AMAZING runtime 3ms better than 99.97% O()
        //
        //Comments with triple slash we're included in solution
class Solution {

public List<List<Integer>> getSkyline(int[][] buildings) {
        //ENTRY FORMAT Left, Right, Height

        //Create result
        List<List<Integer>> res = new ArrayList<>();

        //Create pq ordered by height, if heights are equal then by left point 
        PriorityQueue<int[]> heightHeap = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return a[2] == b[2] ? a[0] - b[0] : b[2] - a[2];
            } 
        });
        
        //previous block of buildings, left is the min value and right is the max value, height of 0
        int[] pre = new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, 0};

        //For every building
        for(int[] b : buildings) {
            
            //While heap is not empty and current building (b) left is smaller than pre right (that means
            //this new building is totally separated from the previous block)
            while(!heightHeap.isEmpty() && b[0] > pre[1]) { /// totally separated
                //get me the highest building in heap
                int[] curHeighest = heightHeap.poll();
                //if this new building right is equals or smaller than to previous building continue
                if(curHeighest[1] <= pre[1]) continue;
                //if this new building right is bigger than previous building right it means it extends
                //the skyline, add the previous building right and current building left
                res.add(Arrays.asList(pre[1], curHeighest[2]));
                //currentHeighest is now previous building
                pre = curHeighest;
            }
            
            //if current building height is bigger than previous building height
            if(b[2] > pre[2]) {
                
                //if current building left is equal to previous building left
                if(b[0] == pre[0]) { /// we always make sure pre is the last element in the res
                    /// if b[0] and pre[0] overlap but b is higher than pre, then we track the point in b not pre
                    res.remove(res.size() - 1);
                }
                
                //we add current building left and height
                res.add(Arrays.asList(b[0], b[2])); /// highest point possibly has a pos in result;
                
                //if current building right is smaller than previous building right
                if(b[1] < pre[1]) {
                    heightHeap.offer(pre); ///prev building covers more length, need to add into heightheap for future.
                }
                pre = b;
            }
            //if current building height is equal or smaller than previous
                //we ask is current building right is bigger than previous building right
            else if(b[1] > pre[1]) {
                //current building height is same as previous building
                if(b[2] == pre[2]) {
                    pre[1] = b[1];
                }
                //current building height is not the same than the previous building
                else {
                    heightHeap.offer(b);
                }
            }
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






