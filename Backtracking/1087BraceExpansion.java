      //My solution
      //Simple, sort options using preprocess method
      //Then just use backtracking to generate all posibilities, which will be sorted 
      //because of the preprocessing
      //Good runtime of 3ms better than 87.26% O¿(P)? where P is the total number of pos
class Solution {
    public String[] expand(String S) {
        String processed=preprocess(S);
        List<String> result=new ArrayList<String>();
        System.out.println(processed);
        createStrings(new StringBuilder(""),result,0,processed);
        String res[]=new String[result.size()];
        int i=0;
        for(String st:result){
            res[i++]=st;
        }
        return res;
    }
    
    public void createStrings(StringBuilder soFar,List<String> result, int index,String s){
        if(index>s.length()) return;
        if(index==s.length()){//
            result.add(new String(soFar.toString()));
            return;//YOU DID NOT RETURN HERE, IF YOU WANT TO END RETURN
        }
        if(s.charAt(index)=='{'){
            int nextIndex=index;
            while(s.charAt(nextIndex)!='}'){
              nextIndex++; 
            }
            while(s.charAt(index) != '}'){
              index++;//skip comma or open brace
              soFar.append(s.charAt(index));
              createStrings(soFar,result,nextIndex+1,s);
              soFar.setLength(soFar.length()-1);
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
          if(s.charAt(i)=='{'){
            i++;
            int optionsEnd=i+1;
            while(s.charAt(optionsEnd)!='}'){
                optionsEnd++;
            }
            String[] options=s.substring(i,optionsEnd).split(",");
            Arrays.sort(options);//Arrays sort does not work on array list
            result.append('{');
            for(String car:options){
               result.append(car);
               result.append(',');
            }
            result.setLength(result.length()-1);
            result.append('}');
            i=optionsEnd;
          }else{
            result.append(s.charAt(i));
          }
          i++;
        }
        return result.toString();          
    }
}  


        //Super simple solution from a leetcode post I can't find again 
        //Runtime of 5ms better than 59.93% O¿(P)?
        //Bad memory
        //Worse runtime than my solution, but not much, by contrast super simple and readable 
        //compared to my solution
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
        for (String s : possibles){
            dfs(res, array, curr + 1, word + s);    
        }
    }
}