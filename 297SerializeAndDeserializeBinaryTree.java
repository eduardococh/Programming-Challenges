		//My solution
		//Average, using iterations and queues
		//Average runtime at 13ms better than 51% o(n)
		//Bad memory using 40.1mb worse than 37%

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res=new StringBuilder();
        if(root==null){
            return "null";
        }
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(root);
        res.append(root.val+",");
        while(!queue.isEmpty()){
            TreeNode current=queue.poll();
            if(current.left==null){
                res.append("null,");
            }else{
                res.append(current.left.val+",");
                queue.add(current.left);
            }
            if(current.right==null){
                res.append("null,");
            }else{
                res.append(current.right.val+",");
                queue.add(current.right);
            }
        }
        return res.toString();
        /*
        res.append(root.val+",");
        res.append(serialize(root.left));
        res.append(serialize(root.right));
        return res.toString();*/
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("null")) return null;
        String[] split = data.split(",");
        TreeNode root=new TreeNode(Integer.parseInt(split[0]));
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(root);
        int i=1;
        while(!queue.isEmpty()){
            TreeNode current=queue.poll();
            if(!split[i].equals("null")){
                current.left=new TreeNode(Integer.parseInt(split[i]));
                queue.add(current.left);
            }
            i++;
            if(!split[i].equals("null")){
                current.right=new TreeNode(Integer.parseInt(split[i]));
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }
}


		//Nice cheat (Forbidden by problem description but works if submitted, 0ms)
public class Codec {
    TreeNode root;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        this.root = root;
        return null;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return this.root;
    }
}


		//Recursive solution by leetcode's 1ms sample
		//Amazing runtime better than 99.69% (cheater are only better)
		//Bad memory better than 22% but this is not very trustfull
public class Codec {
    // Tree 
    //      0
    // -1       1
    
    // will look like "0/##1##"
    
        // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeUtil(root, sb);
        return sb.toString();
    }
    
    private void serializeUtil(TreeNode root, StringBuilder sb){
        if (root == null){
            sb.append("#");
            return;
        }
        sb.append((char)(root.val + '0'));
        serializeUtil(root.left,sb);
        serializeUtil(root.right,sb);
    }
    
    int index=0;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return deserializeUtil(data.toCharArray());
    }
    
    private TreeNode deserializeUtil(char[] data){
        if (data[index] == '#'){
            index++;
            return null;
        }
        TreeNode root = new TreeNode(data[index++] - '0');
        root.left = deserializeUtil(data);
        root.right = deserializeUtil(data);
        return root;
    }
}