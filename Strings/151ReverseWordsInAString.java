class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        String arr[]=s.split(" ");
        StringBuilder st=new StringBuilder();
        for(int i=arr.length-1;i>=0;i--){
            if(!arr[i].equals("")){
                //System.out.println(arr[i].trim());
                st.append(arr[i].trim()+" ");    
            }
        }
        return st.toString().trim();
    }
}