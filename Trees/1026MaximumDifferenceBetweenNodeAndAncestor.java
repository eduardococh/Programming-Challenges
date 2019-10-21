        //My solution
        //Have a minHeap and maxHeap to save maximum ancestor and minimum ancestor
        //Terrible runtime at 30ms better than only 11.72% O(N log N) since for the worst case
        //the tree could be a line of N length and for every node it will take log N to insert
        //Terrible memory better than only 5.55% O(N) 
        //The first solution that came to my mind, but a big overkill to have a min and max heaps
        //which could be done with two variables
class Solution {
    
    int max=0;
    
    public int maxAncestorDiff(TreeNode root) {
        PriorityQueue<Integer> maxAncestors=new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minAncestors=new PriorityQueue<>();
        if(root==null) return max;
        maxAncestors.add(root.val);
        minAncestors.add(root.val);
        return maxAncestorDiffHelper(root,maxAncestors,minAncestors);
    }
    
    public int maxAncestorDiffHelper(TreeNode root, PriorityQueue<Integer> maxAncestors,PriorityQueue<Integer> minAncestors){
        if(root==null) return max;
        if(Math.abs(maxAncestors.peek()-root.val)>max) max=Math.abs(maxAncestors.peek()-root.val);
        if(Math.abs(minAncestors.peek()-root.val)>max) max=Math.abs(minAncestors.peek()-root.val);
        maxAncestors.add(root.val);
        minAncestors.add(root.val);
        maxAncestorDiffHelper(root.left,maxAncestors,minAncestors);
        maxAncestorDiffHelper(root.right,maxAncestors,minAncestors);
        maxAncestors.remove(root.val);
        minAncestors.remove(root.val);
        return max;
    }
}

        //My solution using only max and min variables
        //Way better and more elegant than the heap solution
        //Good runtime of 1ms better than 39.92% O(N)
        //Amazing memory better than 100% O(N) since the recursion stack could 
        //reach length of N
class Solution {
    
    int max=0;
    
    public int maxAncestorDiff(TreeNode root) {
        if(root==null) return max;
        int maxAnc=root.val;
        int minAnc=root.val;
        maxAncestorDiffHelper(root,maxAnc,minAnc);
        return max;
    }
    
    public void maxAncestorDiffHelper(TreeNode root,int maxAnc,int minAnc){
        if(root==null) return;
        if(Math.abs(maxAnc-root.val)>max) max=Math.abs(maxAnc-root.val);
        if(Math.abs(minAnc-root.val)>max) max=Math.abs(minAnc-root.val);
        if(root.val>maxAnc) maxAnc=root.val;
        if(root.val<minAnc) minAnc=root.val;
        maxAncestorDiffHelper(root.left,maxAnc,minAnc);
        maxAncestorDiffHelper(root.right,maxAnc,minAnc);
    }
}