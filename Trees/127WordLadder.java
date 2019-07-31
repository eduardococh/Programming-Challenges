class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        
        Queue<ArrayList<String>> myQueue=new LinkedList<ArrayList<String>>();
        myQueue.add(new ArrayList(Arrays.asList(beginWord)));
        HashMap<String,Boolean> wordListM=new HashMap<>();
        
        while(!myQueue.isEmpty()){
            
            ArrayList<String> currentList=myQueue.poll();
            String topOfList=currentList.get(currentList.size()-1);
            
            for(int i=0;i<wordList.size();i++){
                String testWord=wordList.get(i);
                if(!currentList.contains(testWord)){
                    if(canTransition(topOfList,testWord)){
                        currentList.add(testWord);
                        if(testWord.equals(endWord)){
                            return currentList.size();
                        }
                        myQueue.add(new ArrayList(currentList));
                        currentList.remove(testWord);
                    }
                }
            }
        }
        return 0;
    }
    
    public boolean canTransition(String original, String next){
        byte differentChars=0;
        for(int i=0;i<original.length();i++){
            if(original.charAt(i)!=next.charAt(i)){
                differentChars++;
            }
            if(differentChars>1) return false;
        }
        return true;
    }
    
}

/*class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        
        Queue<ArrayList<String>> myQueue=new LinkedList<ArrayList<String>>();
        myQueue.add(new ArrayList(Arrays.asList(beginWord)));
        HashMap<String,Boolean> wordListM=new HashMap<>();
        wordListM.put(beginWord,false);
        for(int i=0;i<wordList.size();i++){
            wordListM.put(wordList.get(i),true);
        }
        while(!myQueue.isEmpty()){
            
            ArrayList<String> currentList=myQueue.poll();
            /*System.out.println("start list");
            for(int i=0;i<wordList.size();i++){
                System.out.println(wordList.get(i));
            }
            for(int i=0;i<currentList.size();i++){
                //System.out.println("Removing");
                wordListM.put(currentList.get(i),false);
            }/*
            System.out.println("end list");
            for(int i=0;i<wordList.size();i++){
                System.out.println(wordList.get(i));
            }
            String topOfList=currentList.get(currentList.size()-1);
            //System.out.println("testing "+topOfList);
            
            for(int i=0;i<wordList.size();i++){
                if(wordListM.get(wordList.get(i))){
                    String testWord=wordList.get(i);
                    if(canTransition(topOfList,testWord)){
                        //System.out.println("transition to "+testWord);
                        currentList.add(testWord);
                        if(testWord.equals(endWord)){
                            return currentList.size();
                        }
                        myQueue.add(new ArrayList(currentList));
                        currentList.remove(testWord);
                        /*System.out.println("inside end list");
                        for(int j=0;j<currentList.size();j++){
                            System.out.println(currentList.get(j));
                        }
                    }
                }
            }
            
            for(int i=0;i<currentList.size();i++){
                wordListM.put(currentList.get(i),true);
            }
        }
        return 0;
    }
    
    public boolean canTransition(String original, String next){
        byte differentChars=0;
        for(int i=0;i<original.length();i++){
            if(original.charAt(i)!=next.charAt(i)){
                differentChars++;
            }
            if(differentChars>1) return false;
        }
        return true;
    }
    
}
*/