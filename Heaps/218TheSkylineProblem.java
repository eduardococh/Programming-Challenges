class Solution {

public List<List<Integer>> getSkyline(int[][] buildings) {

        List<List<Integer>> res = new ArrayList<>();

        PriorityQueue<int[]> heightHeap = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return a[2] == b[2] ? a[0] - b[0] : b[2] - a[2];
            } 
        });
        
        int[] pre = new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
        
        for(int[] b : buildings) {
            
            while(!heightHeap.isEmpty() && b[0] > pre[1]) { // totally separated
                int[] curHeighest = heightHeap.poll();
                if(curHeighest[1] <= pre[1]) continue;
                res.add(Arrays.asList(pre[1], curHeighest[2]));
                pre = curHeighest;
            }
            
            if(b[2] > pre[2]) {
                if(b[0] == pre[0]) { // we always make sure pre is the last element in the res
                    // if b[0] and pre[0] overlap but b is higher than pre, then we track the point in b not pre
                    res.remove(res.size() - 1);
                }
                res.add(Arrays.asList(b[0], b[2])); // highest point possibly has a pos in result;
                if(b[1] < pre[1]) {
                    heightHeap.offer(pre); //previous covers more length, need to add into heightheap for furture.
                }
                pre = b;
            }
            else if(b[1] > pre[1]) {
                if(b[2] == pre[2]) {
                    pre[1] = b[1];
                }
                else {
                    heightHeap.offer(b);
                }
            }
        }
        while(!heightHeap.isEmpty()) {
            int[] cur = heightHeap.poll();
            if(cur[1] <= pre[1]) continue;
            res.add(Arrays.asList(pre[1], cur[2]));
            pre = cur;
        }
        
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






