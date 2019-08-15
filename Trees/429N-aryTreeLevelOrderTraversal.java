        //My solution
        //Very simple and straightforward
        //Bad runtime at 4ms worse than 10.87% O(N)
        //Good memory 46.4mb better than 77.50% O(N)
        //Could be improved
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        if(root==null) return result;
        Queue<Node> myQueue=new LinkedList<Node>();
        myQueue.add(root);
        List<Integer> currentLevel=new ArrayList<>();
        int nextLevelNodes=0,thisLevelNodes=1;
        
        while(!myQueue.isEmpty()){
            Node currentNode=myQueue.poll();
            currentLevel.add(currentNode.val);
            nextLevelNodes+=currentNode.children.size();
            for(int i=0;i<currentNode.children.size();i++){
                myQueue.add(currentNode.children.get(i));
            }
            thisLevelNodes--;
            if(thisLevelNodes==0){
                thisLevelNodes=nextLevelNodes;
                nextLevelNodes=0;
                result.add(new ArrayList(currentLevel));
                currentLevel.clear();
            }
        }
        return result;
    }
}

        //Iterative solution
        //Bit more elegant than mine, avoid a levelCounter
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList();
        
        if(root==null) return list;
        
        Queue<Node> queue = new LinkedList();
        
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            
            List<Integer> subList = new ArrayList();
            for(int i=0; i<size; i++){
                Node curr = queue.poll();
                subList.add(curr.val);
                
                for(Node item: curr.children){
                    queue.offer(item);
                }
            }
            list.add(subList);            
        }
        return list;
        
    }
}

        //Recursive solution from leetcode's 1ms sample
        //Amazing runtime of 1ms better than 100%
        //Bad memory 49.9mb better than 17.50%
        //Interesting approach but bad memory
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        
        List<List<Integer>> mList = new ArrayList<>();
        int firstLevel = 0;
        
        Recurse(root, firstLevel, mList);
        
        return mList;
    }
    
    public void Recurse(Node n, int level, List<List<Integer>> mList) {
        
        if (n == null) {
            return;
        }
        
        if (mList.size() == level) {
            mList.add(new ArrayList<>());
        }
        
        mList.get(level).add(n.val);
        
        for (Node a : n.children) {
            Recurse(a, level + 1, mList);
        }        

    }
}