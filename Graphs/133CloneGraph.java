        //My solution using recursion and a map
        //Amazing runtime 1ms better than 100% O(N)
        //On march 24 I sent a similar solution and now it always runs in 26ms or more
        //Looks like test cases changed
        //Good memory better than 80% O(N)
        //Simple solution a lot like cloning a tree
class Solution {
    
    HashMap<Node,Node> mapping=new HashMap<Node,Node>();
    
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        
        if(mapping.containsKey(node)) return mapping.get(node);
        
        Node newNode=new Node(node.val);
        newNode.neighbors=new ArrayList<Node>();
        mapping.put(node,newNode);
        
        int len=node.neighbors.size();
        for(int i=0;i<len;i++){
            newNode.neighbors.add(cloneGraph(node.neighbors.get(i)));
        }
        
        return newNode;
    }
}

        //Iterative solution from leetcode's 2ms samples
        //Runtime a little worse than with recursion
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<Node>();
        HashMap<Node, Node> map = new HashMap<>();
        queue.offer(node);
        map.put(node, createNewNode(node));
        while(!queue.isEmpty()) {
            Node currentNode = queue.poll();
            for (Node neighbor: currentNode.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, createNewNode(neighbor));
                    queue.offer(neighbor);
                } 
                map.get(currentNode).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
    
    private Node createNewNode(Node node) {
        return new Node(node.val, new ArrayList<Node>());
    }
}