        //Solution based on leetcode's 1ms sample
        //1ms sample used chars to store numbers, but that was a limitation
        //so i implemented it with an array of integers, but the runtime goes high
        //So the max value will be 65535, more than that and the program fails
        //but not for this case thou, anyway you would only need to replace it
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
        StringBuilder sb=new StringBuilder("");
        sb.append(root.val+",");
        appendHelper(sb,root.left);
        appendHelper(sb,root.right);
        return sb.toString();
    }
    
    public void appendHelper(StringBuilder sb,TreeNode root){
        if(root==null) return;
        sb.append(root.val+",");
        appendHelper(sb,root.left);
        appendHelper(sb,root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null || data.length()==0) return null;
        int[] nums = getArray(data);
        return constructTree(nums, new int[]{0}, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    //(Do not use class member/global/static variables to store states)
    private TreeNode constructTree(int[] nums, int[] idx, int low, int high) {
        if(idx[0]==nums.length) return null;
        int value = (int)nums[idx[0]];
        if(value < low || value > high) return null;
        TreeNode root = new TreeNode(value);
        idx[0]++;
        root.left = constructTree(nums, idx, low, value);
        root.right = constructTree(nums, idx, value, high);
        return root;
    }
    
    public int[] getArray(String sb){
        if(sb==null || sb.length()==0) return new int[0];
        LinkedList<Integer> list=new LinkedList<Integer>();
        StringBuilder num=new StringBuilder("");
        int len=sb.length();
        int i;
        for(i=0;i<len;i++){
            if(sb.charAt(i)==','){
                list.add(Integer.parseInt(num.toString()));
                num.setLength(0);
            }else{
                num.append(sb.charAt(i));    
            }
        }
        i=0;
        int[] res=new int[list.size()];
        for(int number:list){
            res[i++]=number;
        }
        return res;
    }
}

/*
    USING CHAR FOR DESERIALIZATION
    //Runtime goes down to 1ms
    //But the max value of a node will be 65535, more than that and the program fails
    //but not for the test cases of leetcode

    public TreeNode deserialize(String data) {
        if(data==null || data.length()==0) return null;
        char[] chs = data.toCharArray();
        return constructTree(chs, new int[]{0}, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    //(Do not use class member/global/static variables to store states)
    private TreeNode constructTree(int[] chs, int[] idx, int low, int high) {
        if(idx[0]==chs.length) return null;
        int value = (int)chs[idx[0]];
        if(value < low || value > high) return null;
        TreeNode root = new TreeNode(value);
        idx[0]++;
        root.left = constructTree(chs, idx, low, value);
        root.right = constructTree(chs, idx, value, high);
        return root;
    }
*/