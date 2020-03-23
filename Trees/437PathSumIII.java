/*
    My recursive brute force solution
    For every node keep a sum of the values so far and start a new sum with value 0
    this way we can keep the count of every possible sum
    Good runtime of 12ms better than 66.27% (posterior submissions have terrible runtimes of 26ms)
    Time complexity of O(N Log N) for a balanced tree, since every node will be touched by d nodes
    above him (d for depth), this depth will be log of N for a balanced tree
    Time complexity of O(N^2) for the worse case in an umbalanced tree
    The number of methods duplicates every level in depth
    Good memory better than 90% (same ) Not sure
 */
class Solution {
    public int pathSum(TreeNode root, int sum) {
        return pathCounter(root,sum,0,0,true);
    }
    
    public int pathCounter(TreeNode node,int sum, int result, int soFar,boolean first){
        if(node==null) return result;
        soFar+=node.val;
        if(soFar==sum) {
            result++;
        }
        //we add the variable "first" because we only want to restart counter at 0 once per node
        //if we don't add this condition, the second level will have one method with 0 per node
        //then the third level will have two methods with 0 (which is repeating the same work)
        //the fourth four 0 methods and so on
        if(first){
            result=pathCounter(node.right,sum,result,0,true);
            result=pathCounter(node.left,sum,result,0,true);
        }
        result=pathCounter(node.right,sum,result,soFar,false);
        result=pathCounter(node.left,sum,result,soFar,false);
        return result;
    }
}


    /*
        HashMap solution by CTCI
        Use a hashMap to save the current sum of the parents for every node, if a child node current sum minus
        the target sum is equal to any of it's parents current sum it means there is a path from the parent to
        this child with sums to the target. 
        The condition of runningSum==targetSum is a special case where the path starts in the root node
        Amazing time complexity of 2ms better than 100% O(n)
        Good memory better than 56.82% O(N) 
    */
class Solution {
    public int pathSum(TreeNode root, int sum) {
        return countPathsWithSum(root, sum, 0, new HashMap<Integer, Integer>());
    }
    
    public static int countPathsWithSum(TreeNode node, int targetSum, int runningSum, HashMap<Integer, Integer> pathCount) {
		if (node == null) return 0; // Base case
		
		runningSum += node.val;
		
		/* Count paths with sum ending at the current node. */
		int sum = runningSum - targetSum;
		int totalPaths = pathCount.getOrDefault(sum, 0);
		
		/* If runningSum equals targetSum, then one additional path starts at root. Add in this path.*/
		if (runningSum == targetSum) {
			totalPaths++;
		}

		/* Add runningSum to pathCounts. */
		incrementHashTable(pathCount, runningSum, 1);
		
		/* Count paths with sum on the left and right. */
		totalPaths += countPathsWithSum(node.left, targetSum, runningSum, pathCount);
		totalPaths += countPathsWithSum(node.right, targetSum, runningSum, pathCount);
		
		incrementHashTable(pathCount, runningSum, -1); // Remove runningSum
		return totalPaths;
	}
	
	public static void incrementHashTable(HashMap<Integer, Integer> hashTable, int key, int ) {
		int newCount = hashTable.getOrDefault(key, 0) + delta;
		if (newCount == 0) { // Remove when zero to reduce space usage
			hashTable.remove(key);
		} else {
			hashTable.put(key, newCount);
		}
	}
}