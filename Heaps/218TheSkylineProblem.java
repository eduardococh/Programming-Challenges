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
            return this.height-build.height;
        }
    }
    
    public List<List<Integer>> getSkyline(int[][] buildings) {
        //Left,Right,Height
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        int len=buildings.length;
        int blockEnd=buildings[0][1];
        //Comparator<Building> myComp=(a, b)->Integer.valueOf(a.height)-Integer.valueOf(b.height);
        /*Comparator<Building> myComp = new Comparator<Building>() {
            @Override
            public int compare(Building e1, Building e2) {
                return (int) e1.getHeight() - e2.getHeight();
            }
        };*/
        
        PriorityQueue<Building> block=new PriorityQueue<>();
        block.add(new Building(buildings[0][0],buildings[0][1],buildings[0][2]));
        for(int i=1;i<len;i++){
            if(buildings[i][0]<blockEnd){
                Building temp=new Building(buildings[i][0],buildings[i][1],buildings[i][2]);
                block.add(temp);
                if(buildings[i][1]>blockEnd) blockEnd=buildings[i][1];
            }else{
                craftSkyline(block,result);
                block=new PriorityQueue<Building>();
                if(i+1<len){
                    blockEnd=buildings[i+1][1];
                    block=new PriorityQueue<Building>();
                    block.add(new Building(buildings[i+1][0],buildings[i+1][1],buildings[i+1][2]));
                }
            }
        }
        return result;
    }
    
    public void craftSkyline(PriorityQueue<Building> block,List<List<Integer>> result){
        
    }
}






