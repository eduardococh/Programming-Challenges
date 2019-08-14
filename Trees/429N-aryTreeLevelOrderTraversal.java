/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
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