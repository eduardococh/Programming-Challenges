
        //My solution (time limit exceeded, so maybe no solution)
        //Like "brute force approach", the problem with my approach is that I understood issue as
        //a "tree" where every word would branch to all other words, and this works but takes a big amount of time
        //in worse case scenario runtime would be O(n!) since every word would be checked against every other n-1 word
        //It takes a breadth first search, which guarantees that whenever you find a result you have come to the
        //shortest one
        //Good principle but thinking it as a tree is not the way to go
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

        //Leetcode's Breadth First Search approach 
        //The key to the problem is to take it as a graph, my mistake was that I thought that a word could be visited
        //in several ways and so the three maked sense, but when you think it as a graph you see that a word
        //can only be visited once, and once you reach it there's no way to reach it which is not a cycle, breadth first
        //search guarantees that you visit all words in every level, so when you reach the one you've reached it
        //First you do a preprocessing and create the graph and then you do BFS
        //Average runtime at 70ms better than 46.45% O(N*M) N number of words and M length of words
        //the preprocessing takes N*M and then the BFS at most takes N 
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


        //Bidirectional approach
        //Really smart, start a BFS from start word and from end word, which reduces BFS time complexity in half
        //Have to visited dictionaries, when you find a 

import javafx.util.Pair;

class Solution {

  private int L;
  private HashMap<String, ArrayList<String>> allComboDict;

  Solution() {
    this.L = 0;

    // Dictionary to hold combination of words that can be formed,
    // from any given word. By changing one letter at a time.
    this.allComboDict = new HashMap<String, ArrayList<String>>();
  }

  private int visitWordNode(
      Queue<Pair<String, Integer>> Q,
      HashMap<String, Integer> visited,
      HashMap<String, Integer> othersVisited) {
    Pair<String, Integer> node = Q.remove();
    String word = node.getKey();
    int level = node.getValue();

    for (int i = 0; i < this.L; i++) {

      // Intermediate words for current word
      String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

      // Next states are all the words which share the same intermediate state.
      for (String adjacentWord : this.allComboDict.getOrDefault(newWord, new ArrayList<String>())) {
        // If at any point if we find what we are looking for
        // i.e. the end word - we can return with the answer.
        if (othersVisited.containsKey(adjacentWord)) {
          return level + othersVisited.get(adjacentWord);
        }

        if (!visited.containsKey(adjacentWord)) {

          // Save the level as the value of the dictionary, to save number of hops.
          visited.put(adjacentWord, level + 1);
          Q.add(new Pair(adjacentWord, level + 1));
        }
      }
    }
    return -1;
  }

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {

    if (!wordList.contains(endWord)) {
      return 0;
    }

    // Since all words are of same length.
    this.L = beginWord.length();

    wordList.forEach(
        word -> {
          for (int i = 0; i < L; i++) {
            // Key is the generic word
            // Value is a list of words which have the same intermediate generic word.
            String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
            ArrayList<String> transformations =
                this.allComboDict.getOrDefault(newWord, new ArrayList<String>());
            transformations.add(word);
            this.allComboDict.put(newWord, transformations);
          }
        });

    // Queues for birdirectional BFS
    // BFS starting from beginWord
    Queue<Pair<String, Integer>> Q_begin = new LinkedList<Pair<String, Integer>>();
    // BFS starting from endWord
    Queue<Pair<String, Integer>> Q_end = new LinkedList<Pair<String, Integer>>();
    Q_begin.add(new Pair(beginWord, 1));
    Q_end.add(new Pair(endWord, 1));

    // Visited to make sure we don't repeat processing same word.
    HashMap<String, Integer> visitedBegin = new HashMap<String, Integer>();
    HashMap<String, Integer> visitedEnd = new HashMap<String, Integer>();
    visitedBegin.put(beginWord, 1);
    visitedEnd.put(endWord, 1);

    while (!Q_begin.isEmpty() && !Q_end.isEmpty()) {

      // One hop from begin word
      int ans = visitWordNode(Q_begin, visitedBegin, visitedEnd);
      if (ans > -1) {
        return ans;
      }

      // One hop from end word
      ans = visitWordNode(Q_end, visitedEnd, visitedBegin);
      if (ans > -1) {
        return ans;
      }
    }

    return 0;
  }
}