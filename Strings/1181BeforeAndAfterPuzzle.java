class Solution {
    
    class Mapping{
        int index;
        String word;
    }
    
    public List<String> beforeAndAfterPuzzles(String[] phrases) {
        List<String> result=new ArrayList<String>();
        HashMap<String,List<Mapping>> mapping=new HashMap<String,List<Mapping>>();
        for(String phrase:phrases){
            String[] words=phrase.split(" ");
            /*for(String word:words){
                System.out.println(word);    
            }*/
            if(mapping.containsKey(words[0])){
                Mapping current=new Mapping();
                //current.index=
                mapping.put(words[0],new )
            }else{
                
            }
        }
        return null;
    }
}