		//My first solution
		//Lot of flaws, see second one
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result=new ArrayList<String>();
        if(root==null) return result;
        result=generateBinaryTreePaths(root,result,new StringBuilder(""));  
        for(int i=0;i<result.size();i++){
            result.set(i,result.get(i).substring(0,result.get(i).length()-2));
        }
        return result;
    }
    
    public List<String> generateBinaryTreePaths(TreeNode root,List<String> result,StringBuilder path) {
        StringBuilder aux=new StringBuilder(path.toString()); 
        path.append(root.val+"->");
        if(root.left==null && root.right==null){
            result.add(path.toString());
            path.setLength(0);
            path.append(aux.toString());
            return result;
        }
        if(root.left!=null){
            result=generateBinaryTreePaths(root.left,result,path);
        }
        if(root.right!=null){
            result=generateBinaryTreePaths(root.right,result,path);
        }
        path.setLength(0);
        path.append(aux.toString());
        return result;
    }
}


		//My second solution
		//Same approach as first one but solved lot of flaws (logic of aux)
		//Bad runtime at 2ms better than only 36% (not exact i think) o(n)
		//Amazing memory better than 100% o(n)
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result=new ArrayList<String>();
        if(root==null) return result;
        result=generateBinaryTreePaths(root,result,new StringBuilder(""));
        return result;
    }
    
    public List<String> generateBinaryTreePaths(TreeNode root,List<String> result,StringBuilder path) {
        int aux=path.length();
        path.append(root.val);
        if(root.left==null && root.right==null){
            result.add(path.toString());
            path.delete(aux,path.length());
            return result;
        }
        path.append("->");
        if(root.left!=null){
            result=generateBinaryTreePaths(root.left,result,path);
        }
        if(root.right!=null){
            result=generateBinaryTreePaths(root.right,result,path);
        }
        path.delete(aux,path.length());
        return result;
    }
}


		//From leetcode's 1ms sample
		//Same as my approach but dfs does not return a list, it just modifies reference (which saves runtime)
		//Should be 1ms in runtime but is 2ms, so I'm not trusting this measure here
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>(  );
        if (root==null) return res;
        StringBuilder sb = new StringBuilder(  );
        dfs(root,res,sb);
        return res;
    }

    public void dfs(TreeNode root, List<String> res, StringBuilder sb){
        if (root==null) return;
        int temp = sb.length();
        if (root.left==null && root.right==null){
            sb.append( root.val );
            res.add( sb.toString() );
            sb.delete( temp,sb.length() );
        }
        sb.append( root.val+"->" );
        dfs(root.left,res,sb);
        dfs(root.right,res,sb);
        sb.delete( temp,sb.length() );
    }
}


		//Solution by leetcode's vimukthi
		//Very clear approach (Apparently in this case using string was not so bad)
		//Runtime of 2ms better than 36%
		//Best memory than 100%
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<String>();
        if (root != null) searchBT(root, "", answer);
        return answer;
    }
    private void searchBT(TreeNode root, String path, List<String> answer) {
        if (root.left == null && root.right == null) answer.add(path + root.val);
        if (root.left != null) searchBT(root.left, path + root.val + "->", answer);
        if (root.right != null) searchBT(root.right, path + root.val + "->", answer);
    }
}


		//Another very clever solution by leetcodes sanket07
		//Only using one method, it creates the string front to back
		//Starting by putting the leaf in the path and then appending parents
		
public List<String> binaryTreePaths(TreeNode root) {
        
        List<String> paths = new LinkedList<>();

        if(root == null) return paths;
        
        if(root.left == null && root.right == null){
            paths.add(root.val+"");
            return paths;
        }

         for (String path : binaryTreePaths(root.left)) {
             paths.add(root.val + "->" + path);
         }

         for (String path : binaryTreePaths(root.right)) {
             paths.add(root.val + "->" + path);
         }

         return paths;
        
    }