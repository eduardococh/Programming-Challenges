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


        //Linked hashmap approach from leetcode's 54ms samples 
        //Would be advisable to use it in this problem or any other problem
        //that might need it, maybe in an interview this would be very simple but
        //it shows knowledge
        //Very good runtime (54ms, in my case took 60ms)
        //Bad memory 58.6mb better than 31.90%
class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }
    
    public int get(int key) {
        return super.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        super.put(key, value);
    }
    
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
