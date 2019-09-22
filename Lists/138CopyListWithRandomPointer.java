        //My recursive solution
        //Based on leetcode's solution
        //Good runtime of 1ms faster than 73.88% O(N)
        //Amazing memory of 99.07% O(N)
        //Treat list as a graph, use visited hashMap as a way to save
        //which nodes have already been visited and starting from first and going to
        //next node and to random node recursively, if we visit a node that has already
        //been created we link to the reference to that node in visitedNodes
        //visited nodes holds the relationship between every node and their copy
        //NOTE: as leetcode's solution i used "this" keyword, but the program works well
        //without it so it probably is just for extra clarificacion
class Solution {
    
    HashMap<Node,Node> visitedNodes=new HashMap<Node,Node>();
    
    public Node copyRandomList(Node head) {
        
        if(head==null){
            return null;
        }
        
        if(this.visitedNodes.containsKey(head)){
            return this.visitedNodes.get(head);
        }
        
        Node newNode=new Node();
        newNode.val=head.val;
        
        this.visitedNodes.put(head,newNode);
        
        newNode.next=this.copyRandomList(head.next);
        newNode.random=this.copyRandomList(head.random);
        
        return newNode;
    }
}


        //Iterative approach by leetcode
        //Same runtime and memory as recursive
        //I think recursive is clearer and easier than this one
        //It goes through every node one using next field, for every node
        //it creates their next and random, if these nodes already exists it links the
        //reference using the hashmap, like the recursive approach
public class Solution {
  
  HashMap<Node, Node> visited = new HashMap<Node, Node>();

  public Node copyRandomList(Node head) {

    if (head == null) {
      return null;
    }

    Node oldNode = head;

    Node newNode = new Node(oldNode.val);
    this.visited.put(oldNode, newNode);

    while (oldNode != null) {
      newNode.random = this.getClonedNode(oldNode.random);
      newNode.next = this.getClonedNode(oldNode.next);

      oldNode = oldNode.next;
      newNode = newNode.next;
    }
    return this.visited.get(head);
  }

  public Node getClonedNode(Node node) {

    if (node != null) {
      if (this.visited.containsKey(node)) {

        return this.visited.get(node);
      } else {
        this.visited.put(node, new Node(node.val, null, null));
        return this.visited.get(node);
      }
    }
    return null;
  }
}