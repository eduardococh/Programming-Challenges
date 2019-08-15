class LRUCache {
    
    private HashMap<Integer,Integer> myMap;
    private List<Integer> priority;
    private final int capacity;
    private int currentCapacity;
    public LRUCache(int capacity) {
        priority=new ArrayList<Integer>();
        myMap=new HashMap<>();
        this.capacity=capacity;
        currentCapacity=0;
    }
    
    public int get(int key) {
        if(myMap.containsKey(key)){
            priority.remove(new Integer(key));
            priority.add(0,key);
            return myMap.get(key);
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(myMap.containsKey(key)){
            myMap.put(key,value);
            priority.remove(new Integer(key));
            priority.add(0,key);
        }else{
            if(priority.size()==capacity){
                myMap.remove(priority.get(priority.size()-1));
                priority.remove(priority.size()-1);
                myMap.put(key,value);
                priority.add(0,key);
            }else{
                myMap.put(key,value);
                priority.add(0,key);
            }    
        }
    }
}
