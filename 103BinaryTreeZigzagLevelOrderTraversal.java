		//My solution
		//Very clear in logic, use a stack to keep record and depending on direction
		//fill stack
		//In usual tree traversal we use queue to keep our order, since here order will
		//be inverted a stack will get the work better
		//there are problably more elegant solutions
		//Good runtime of 1ms better than 82.23% O(N)
		//Amazing memory of 36.1mb better than 99.97% O(N)
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        if(root==null) return result;
        Stack<TreeNode> currentLevel=new Stack();
        //true right false left
        boolean direction=true;
        currentLevel.push(root);
        while(!currentLevel.isEmpty()){
            List<Integer> current=new ArrayList<Integer>();
            Stack<TreeNode> nextLevel=new Stack();
            if(direction){
                while(!currentLevel.isEmpty()){
                    TreeNode temp=currentLevel.pop();
                    current.add(temp.val);
                    if(temp.left!=null){
                        nextLevel.push(temp.left);
                    }
                    if(temp.right!=null){
                        nextLevel.push(temp.right);
                    }
                    direction=false;
                }
            }else{
                while(!currentLevel.isEmpty()){
                    TreeNode temp=currentLevel.pop();
                    current.add(temp.val);
                    if(temp.right!=null){
                        nextLevel.push(temp.right);
                    }
                    if(temp.left!=null){
                        nextLevel.push(temp.left);
                    }
                    direction=true;
                }
            }  
            result.add(current);
            currentLevel=nextLevel;
        }
        return result;
    }
}