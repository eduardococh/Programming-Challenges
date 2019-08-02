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


import javafx.util.Pair;

class Solution {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {

    // Since all words are of same length.
    int L = beginWord.length();

    // Dictionary to hold combination of words that can be formed,
    // from any given word. By changing one letter at a time.
    HashMap<String, ArrayList<String>> allComboDict = new HashMap<String, ArrayList<String>>();

    wordList.forEach(
        word -> {
          for (int i = 0; i < L; i++) {
            // Key is the generic word
            // Value is a list of words which have the same intermediate generic word.
            String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
            ArrayList<String> transformations =
                allComboDict.getOrDefault(newWord, new ArrayList<String>());
            transformations.add(word);
            allComboDict.put(newWord, transformations);
          }
        });

    // Queue for BFS
    Queue<Pair<String, Integer>> Q = new LinkedList<Pair<String, Integer>>();
    Q.add(new Pair(beginWord, 1));

    // Visited to make sure we don't repeat processing same word.
    HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
    visited.put(beginWord, true);

    while (!Q.isEmpty()) {
      Pair<String, Integer> node = Q.remove();
      String word = node.getKey();
      int level = node.getValue();
      for (int i = 0; i < L; i++) {

        // Intermediate words for current word
        String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

        // Next states are all the words which share the same intermediate state.
        for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<String>())) {
          // If at any point if we find what we are looking for
          // i.e. the end word - we can return with the answer.
          if (adjacentWord.equals(endWord)) {
            return level + 1;
          }
          // Otherwise, add it to the BFS Queue. Also mark it visited
          if (!visited.containsKey(adjacentWord)) {
            visited.put(adjacentWord, true);
            Q.add(new Pair(adjacentWord, level + 1));
          }
        }
      }
    }

    return 0;
  }
}