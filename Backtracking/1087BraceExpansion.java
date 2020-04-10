      //My solution
      //Simple, sort options using preprocess method
      //Then just use backtracking to generate all posibilities, which will be sorted 
      //because of the preprocessing
      //Good runtime of 3ms better than 87.26% O(P) where P is the total number of pos
      //
class Solution {
    public String[] expand(String S) {
        String processed=preprocess(S);
        List<String> result=new ArrayList<String>();
        createStrings(new StringBuilder(""),result,0,processed);
        return null;//result.toArray();
    }
    
    public void createStrings(StringBuilder soFar,List<String> result, int index,String s){
        if(index>s.length()) return;
        if(index==s.length()) result.add(new String(soFar.toString()));
        if(s.charAt(index)=='{'){
            int nextIndex=index;
            while(nextIndex < s.length()  && s.charAt(nextIndex)!='}'){
              nextIndex++; 
            }
            index++;//skip {
            while( s.charAt(index) != '}'){
              soFar.append(s.charAt(index));
              createStrings(soFar,result,nextIndex,s);
              soFar.setLength(soFar.length()-1);
              index++;//next letter
              index++;//skip comma
            } 
        }else{
            soFar.append(s.charAt(index));
            createStrings(soFar,result,index+1,s);
            soFar.setLength(soFar.length()-1);
        }
    }
  
    public String preprocess(String s){
        int i=0,len=s.length();
        StringBuilder result=new StringBuilder("");
        while(i<len){
          ArrayList<Character> options=new ArrayList<>();
          if(s.charAt(i)=='{'){
            i++;
            options.add(s.charAt(i));
            while(i<len && i!='}'){
              i++;//skip comma
              options.add(s.charAt(i));
              i++;
            }
            Collections.sort(options);//Arrays sort does not work on array list
            result.append('{');
            for(Character car:options){
               result.append(car);
               result.append(',');
            }
            result.setLength(result.length()-1);
            result.append('}');
          }else{
            result.append(s.charAt(i));
          }
          i++;
        }
        return result.toString();          
    }
}

class Solution {
    public String[] expand(String S) {
        String[] array = S.split("\\{|\\}");
        List<String> res = new ArrayList<>();
        dfs(res, array, 0, "");
        return res.toArray(new String[res.size()]);
    }
    
    private void dfs(List<String> res, String[] array, int curr, String word) {
        if (curr >= array.length) {
            res.add(word);
            return;
        }
        String[] possibles = array[curr].split(",");
        Arrays.sort(possibles);
        for (String s : possibles) dfs(res, array, curr + 1, word + s);
    }
}