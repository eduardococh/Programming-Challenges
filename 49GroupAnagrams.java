class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answer=new ArrayList<List<String>>();
        int chars[][]=new int[strs.length][26];
        int position[]=new int[strs.length];
        int currentCounter=0;
        for(int i=0;i<strs.length;i++){
            
            String str=strs[i];
            final int length=str.length();
            //FILL ARRAY
            for(int j=0;j<str.length();j++){
                char character=str.charAt(j);
                chars[i][character-'a']++;
            }
            //VERIFY IF THIS STRING ARRAY IS EQUAL TO SOME OTHER STRING ARRAY
            boolean isEqual=false;
            for(int k=0;k<i;k++){
                //System.out.println("STRING i "+strs[i]);
                //System.out.println("STRING k "+strs[k]);
                if(i!=k && Arrays.equals(chars[i],chars[k])){
                    //System.out.println("equal "+currentCounter);
                    position[i]=position[k];
                    isEqual=true;
                }
            }
            if(isEqual==false){
                //System.out.println(currentCounter+" not equal "+strs[i]);
                position[i]=currentCounter;
                currentCounter++;
            }
        }
        for(int i=0;i<currentCounter;i++){
            List<String> list=new ArrayList<String>();
            for(int j=0;j<strs.length;j++){
                if(position[j]==i){
                    list.add(strs[j]);
                }
            }
            answer.add(list);
        }
        return answer;
    }
}