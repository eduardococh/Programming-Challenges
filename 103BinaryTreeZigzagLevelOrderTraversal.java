		//My solution
		//Very clear in logic, use a stack to keep record and depending on direction
		//fill stack
		//In usual tree traversal we use queue to keep our order, since here order will
		//be inverted a stack will get the work better
		//there are problably more elegant solutions
		//Good runtime of 1ms better than 82.23% O(N) //this runtime is debatable, since I ran a sample
		//0ms solutionn from leetcode and it also ran in 1ms
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

		//Recursive solution from leetcode's sample 0ms, but when I ran it run in 1ms, so 
		//the same as mine
		
		//so this solution goes level by level adding at the beggining and end of the level depending on
		//pair or none
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, res, 0);
        return res;
    }
    
    public void helper(TreeNode root, List<List<Integer>> list, int level){
        
        if(root == null) return;
        if(list.size() <= level){
            list.add(new ArrayList<Integer>());
        }
        
        
        //List<Integer> res = list.get(level);
        if(level % 2 == 0) list.get(level).add(root.val);
        else list.get(level).add(0, root.val);
        
        helper(root.left, list, level + 1);
        helper(root.right, list, level + 1);
    }
}