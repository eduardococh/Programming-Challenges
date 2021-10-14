//My complex solution using recursivity, biggest so far, parent
//Runtime of 1ms better than 36% O(N)
//Memory better than 30% O(N)
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder,new int[]{0},new int[]{preorder[0]},preorder[0]);
    }
    
    public TreeNode bstFromPreorder(int[] preorder,int[] index,int[] biggestSoFar,int parent){
        if(index[0]>=preorder.length) return null;
        //first item is root
        TreeNode root=new TreeNode(preorder[index[0]]);
        if(root.val>biggestSoFar[0]) biggestSoFar[0]=root.val;
        index[0]++;
        
        //if next is smaller, that is left son
        if(index[0]<preorder.length && preorder[index[0]]<root.val){
            
            root.left=bstFromPreorder(preorder,index,biggestSoFar,root.val);
        }
        
        
        if(index[0]<preorder.length && parent>preorder[index[0]]){
            root.right=bstFromPreorder(preorder,index,biggestSoFar,parent);   
        }
        if(index[0]<preorder.length && preorder[index[0]]>biggestSoFar[0] && root.val==biggestSoFar[0]){
            root.right=bstFromPreorder(preorder,index,biggestSoFar,parent); 
        }
        
        return root;
    }
}

//Possible improvement, create root, then for all values smaller send to left, and all bigger to right, preorder
//means smallers will come before biggers