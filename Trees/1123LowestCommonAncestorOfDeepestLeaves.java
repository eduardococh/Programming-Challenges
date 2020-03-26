/**
 * My solution using depth first search
 * Do a preorder traversal of the tree, get the routes of all nodes
 * in the deepest level. With these routes go and check the common nodes
 * Bad runtime of 2ms better than only 17.94% O(N)
 * Amazing memory better than 100% ¿O(H)? where H is the height
 */
class Solution {
    
    int deepestLevel;
    
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        ArrayList<ArrayList<TreeNode>> deepest=new ArrayList<ArrayList<TreeNode>>();
        deepestLevel=0;
        searchDeepest(root,deepest,new ArrayList<TreeNode>(),0);
        return commonToAll(deepest);
    }
    
    public TreeNode commonToAll(ArrayList<ArrayList<TreeNode>> deepest){
        final int nRoutes=deepest.size();
        final int lenRoutes=deepest.get(0).size();
        TreeNode result=deepest.get(0).get(0);
        for(int i=0;i<lenRoutes;i++){
            boolean equals=true;
            TreeNode current=deepest.get(0).get(i);
            for(int j=1;j<nRoutes;j++){
                if(!deepest.get(j).get(i).equals(current)){
                    //System.out.println("we entered");
                    return result;
                }
            }
            result=current;
        }
        return result;
    }
    
    public void searchDeepest(TreeNode node,ArrayList<ArrayList<TreeNode>> deepest,ArrayList<TreeNode> route,int currentLevel){
        if(node==null) return;
        route.add(node);
        if(currentLevel==deepestLevel){
            deepest.add(new ArrayList(route));
        }else if(currentLevel>deepestLevel){
            deepestLevel=currentLevel;
            deepest.clear();
            deepest.add(new ArrayList(route));
        }
        searchDeepest(node.left,deepest,route,currentLevel+1);
        searchDeepest(node.right,deepest,route,currentLevel+1);
        route.remove(node);
    }
}