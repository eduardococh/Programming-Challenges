		//My solution, using list partition
		//Bad runtime at 17ms better than only 9.24% o(N*N)
		//Terrible memory at 81.8mb, worse than 99% O(2^N)
		//not sure about both big o measures
		//binary search is obviously not a binary search, think it was not worth it 
		//because you had to clone and order array
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0){
            return null;
        }

        if(preorder.length==1){
            return new TreeNode(preorder[0]);
        }
        int middlePre=preorder[0];
        TreeNode root=new TreeNode(preorder[0]);
        int middleIn=binarySearch(inorder,middlePre);
        
        root.left=buildTree(Arrays.copyOfRange(preorder, 1, 1+middleIn),Arrays.copyOfRange(inorder,0,middleIn));
        
        root.right=buildTree(Arrays.copyOfRange(preorder, 1+middleIn,preorder.length),Arrays.copyOfRange(inorder,middleIn+1,inorder.length));
        return root;
    }
    
    public int binarySearch(int[] arr,int target){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==target){
                return i;
            }
        }
        return -1;
    }
}

		//Hash map approach, from leetcode's sample 2ms
		//2ms faster than 97.37%
		//41.7mb less than only 6.75%
		//HashMap in inorder array avoids the runtime to search in the array, 
		//good improvement that could be applied to my approach
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap();
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        
        return build(preorder,map,0,0,inorder.length-1);
    }
    
    
    TreeNode build(int []pre, Map<Integer,Integer> map, int ps, int is, int ie)
    {
        if(ps>=pre.length || is>ie) return null;
        
        TreeNode cur = new TreeNode(pre[ps]);
        int ix = map.get(pre[ps]);
        cur.left = build(pre,map,ps+1,is,ix-1);
        cur.right = build(pre,map,ps+1+(ix-is),ix+1,ie);
        return cur;
    }
}

		//Recursive approach, from leetcode's sample 36964kb
		//In my submission runtime was great at 1ms, better than 100%
		//memory was 39mb, less than only 13% but i got it from 36.9mb sample
		//So again memory measure is not exact in leetcode
		//Best approach so far
		//Very simple and elegant,

		//How it works, it creates the tree using only preoder array, inorder array is used to check tree structure only

		//First it creates left nodes with preorder, until preorder[n] is equal to the first inorden element, when they are equal it
		//"creates" a null left and goes to the right, every time it goes right it increases inorder counter by one, then on the right
		//it will create a node ONLY if STOP variable is not null and STOP.VAL is not equal to inorder[m], this "stop" is the real trick,
		//stop will contain the father node of a left child, when the child is left (if the father is a right children it will not be stop node,
		//stop nodes are only fathers of left children, if the father is right children stop will be the first left children of any node), so for example if you are
		//the right child of a node, your stop will be the left father of your father, filling left is simple, filling right needs to check for stop
		//brillian algorithm. Unknown author since i found it on samples, credits to unkown author

		//Example    1
		//      2          3      
		//   4    5     6     7
		//  8 9 10 11 12 13 14 15

		//Lets say we are checking if we can create node 11, stop will be node 1 because 5 and 2 are right fathers, and the first left father is 1
		//Or for node 13 6 cant be stop because it is a right father, so 13 stop is 3 because it is the first left father
		//And node 15 will have stop == null because there's not a single left father in their ascendance 

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
	//Sent both traversals and an array of {0,0}
        return build(preorder, inorder, new int[2], null);
    }

    private TreeNode build(int[] preorder, int[] inorder, int[] indexes, TreeNode stop) {
	
        if (indexes[0] >= preorder.length || (stop != null && stop.val == inorder[indexes[1]])) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[indexes[0]++]);
        node.left = build(preorder, inorder, indexes, node);
        indexes[1]++;
        node.right = build(preorder, inorder, indexes, stop);
        return node;
    }
}