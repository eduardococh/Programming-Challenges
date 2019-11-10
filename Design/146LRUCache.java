        //My 2nd time solution
        //Bad runtime of 92ms better than only 12.37%
        //Memory better than around 70%
        //Use a hashMap as normal and a list as priority record
class LRUCache {
    
    HashMap<Integer,Integer> map;
    ArrayList<Integer> order;
    final int capacity;

    public LRUCache(int capacity) {
        map=new HashMap<>();
        order=new ArrayList<>();
        this.capacity=capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            order.remove(new Integer(key));
            order.add(key);
            return map.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        map.put(key,value);
        if(order.contains(key)){
            order.remove(new Integer(key));
        }
        order.add(key);
        if(order.size()==capacity+1){
            map.remove(order.get(0));
            order.remove(0);
        }
    }
}

        //Linked hashmap approach from leetcode's 54ms samples 
        //Would be advisable to use it in this problem or any other problem
        //that might need it, maybe in an interview this would be very simple but
        //it shows knowledge
        //AMAZING runtime of 13ms better than 99.97%
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

        //Double linked list approach with help of hashMap
        //From leetcode's sample 13ms solutions
        //Double linked list helps with the order, hashMap makes access
        //constant, this makes for a very efficient algorithm
        //When you put a value you query the map, if it returns null you add key to map
        //if it exists you delete the node from their position (deleting in double linked lists
        //takes O(1) time, and since you access it using hash map makes it all O(1)), once deleted
        //you put it at the head.
        //getting is simple, you query, dont exists return -1, exists, send it 
        //toHead (which involves deleting and adding to head)
        //AMAZING runtime better than 99%
class LRUCache {

    
    class Node{
        Node pre, post;
        int key, val;
    }
    
    Map<Integer,Node> map;
    int count;
    int capacity;
    Node head, tail;
    
    public void addNode(Node n)
    {
        n.pre = head;
        n.post = head.post;
        head.post.pre = n;
        head.post = n;
    }
    
    public void remNode(Node n)
    {
        Node pre = n.pre;
        Node post = n.post;
        pre.post = post;
        post.pre = pre;
    }
    
    public void toHead(Node n)
    {
        remNode(n);
        addNode(n);
    }
    
    public Node popTail()
    {
        Node t = tail.pre;
        remNode(t);
        return t;
    }
    
    public LRUCache(int capacity) {
     this.map = new HashMap<>();
        this.count = 0;
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.post = tail;
        tail.pre = head;
        head.pre = null;
        tail.post = null;
    }
    
    public int get(int key) {
        Node n = map.get(key);
        if(n==null)
            return -1;
        toHead(n);
        return n.val;
    }
    
    public void put(int key, int value) {
        Node n = map.get(key);
        if(n==null)
        {
            n = new Node();
            n.key = key;
            n.val = value;
            map.put(key,n);
            addNode(n);
            count++;
            if(count>capacity)
            {
                Node t = popTail();
                map.remove(t.key);
                count--;
            }
            
        }
        else
        {
            n.val = value;
            toHead(n);
        }
    }
}



     
        //My forgettable 1st solution 
        //not worth viewing, better runtime than only 5.47%
        /*
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
*/